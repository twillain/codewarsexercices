package FMC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Atom {

    String element;
    int valence;
    int numBonds;
    double atomicWeight;
    Atom[] bonds;
    int id = 0;
    public static int count = 0 ;

    public Atom(String element) {
        try{
            this.mutate(element);
            this.bonds = new Atom[this.valence];
        } catch (InvalidBondException e) {
            System.err.println(e.getMessage());
        } finally {
            this.id = ++count;
            numBonds = 0;
        }
    }

    public String getElement() {
        return this.element;
    }

    public int getId(){
        return this.id;
    }

    public int getValence(){
        return this.valence;
    }

    public double getAtomicWeight(){
        return this.atomicWeight;
    }

    public Atom[] getBonds(){
        return this.bonds;
    }

    public void mutate(String e) throws InvalidBondException{
        this.element = e;
        switch (e) {
            case "H":
                this.valence = 1;
                this.atomicWeight = 1.0;
                break;
            case "B":
                this.valence = 3;
                this.atomicWeight = 10.8;
                break;
            case "C":
                this.valence = 4;
                this.atomicWeight = 12.0;
                break;
            case "N":
                this.valence = 3;
                this.atomicWeight = 14.0;
                break;
            case "O":
                this.valence = 2;
                this.atomicWeight = 16.0;
                break;
            case "F":
                this.valence = 1;
                this.atomicWeight = 19.0;
                break;
            case "Mg":
                this.valence = 2;
                this.atomicWeight = 24.3;
                break;
            case "P":
                this.valence = 3;
                this.atomicWeight = 31.0;
                break;
            case "S":
                this.valence = 2;
                this.atomicWeight = 32.1;
                break;
            case "Cl":
                this.valence = 1;
                this.atomicWeight = 35.5;
                break;
            case "Br":
                this.valence = 1;
                this.atomicWeight = 80.0;
                break;
        }
        if (numBonds > this.valence) {throw new InvalidBondException();}
    }

    public Atom add(String element) throws InvalidBondException{
        if (this.numBonds + 1 > this.valence) throw new InvalidBondException();
        Atom newAtom = null;
        for (int i=0 ; i < this.bonds.length ; i++){
            if (bonds[i] == null){
                newAtom = new Atom(element);
                newAtom.getBonds()[0] = this;
                this.incrementNumBonds();
                bonds[i] = newAtom;
                newAtom.incrementNumBonds();
                break;
            }
        }
        return newAtom;
    }

    public Atom remove(){
        for (Atom a : bonds){

        }
        return new Atom(this.element);
    }
    
    public void incrementNumBonds(){
        this.numBonds++;
    }

    public int getNumBonds(){
        return this.numBonds;
    }

    public String toString(){
        List<String> list = new ArrayList<String>();
        for (Atom a : this.bonds){
            if (a == null) continue;
            else if (a.getElement().equals("H")){
                if (!list.contains("H")) list.add("H");
            }
            else list.add(a.getElement()+a.getId()+',');
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.contains("C")){
                    if (o2.contains("C")) return o1.compareTo(o2);
                    else return -1;
                }
                if (o1.contains("O")){
                    if (o2.contains("O")) return o1.compareTo(o2);
                    else return -1;
                }
                if (o1.contains("H")) return 1;
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Atom(%s.%d: ",this.getElement(), this.getId()));
        for (String s : list){
            sb.append(s);
        }
        sb.append(")");
        return sb.toString();
    }

}
