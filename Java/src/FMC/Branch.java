package FMC;

import java.util.Iterator;
import java.util.function.Consumer;

public class Branch implements Iterable<Atom> {
    int id;
    Atom first;
    int length;
    public static int count = 1;

    public Branch(int length){
        this.length = length;
        int countL = 0;
        first = new Atom("C");
        Atom current = first;
        Atom next;
        Atom[] currentLinks;
        Atom[] nextLinks;
        while (countL < length-1){
            next = new Atom("C");
            currentLinks = current.getBonds();
            currentLinks[1] = next;
            current.incrementNumBonds();
            nextLinks = next.getBonds();
            nextLinks[0] = current;
            next.incrementNumBonds();

            current = next;
            countL++;
        }
        this.id = ++count;
    }

    public int getId(){
        return this.id;
    }

    public int getLength(){
        return this.length;
    }

    public Atom get(int position){
        if (position < 0 || position > this.length) return null;
        int count = 1;
        Atom current = first;
        while (count < position){
            current = current.getBonds()[1];
            count++;
        }
        return current;
    }


    public String toString(){
        String s = "";
        Atom current = this.first;
        int count = 0;
        while (count < this.length){
            s = s + current.getElement() + "-";
            current = current.getBonds()[1];
            count++;
        }
        return s;
    }


    public static void main(String... args){
        Branch b = new Branch(5);
        System.out.println(b.toString());
        System.out.println(b.get(2).getId());
    }

    @Override
    public Iterator<Atom> iterator() {

        return new Iterator<Atom>() {
            Atom current = first;
            Atom previous = null;
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < length;
            }

            @Override
            public Atom next() {
                previous = current;
                current = current.getBonds()[1];
                count++;
                return previous;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Atom> action) {
        Iterable.super.forEach(action);
    }
}
