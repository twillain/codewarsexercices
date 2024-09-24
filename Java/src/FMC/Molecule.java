package FMC;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Molecule {

    String name;
    Branch[] branches = null;
    List<Atom> atoms = null;
    String[][] elems = {{"C","H","O"}, {"B","N","F","Mg","P","S","Cl","Br"}}; /** elems[0][*] priority [1][*] others **/

    public Molecule() {
        this.branches = new Branch[0];
        atoms = new ArrayList<>();
    }

    public Molecule(String name) {
        this();
        this.name = name;
    }

    public static void main(String... args) throws Exception {
        //Molecule molecule = new Molecule("test");
        /*molecule
                .brancher(3, 1,1)
                .bounder(new T(3,1,1,2), new T(3,1,1,2))
                .mutate(new T(1,3,"Mg"))
                .add(new T(2,1,"S"), new T(1,1,"O"))
                .closer();*/
        Molecule molec = new Molecule("octane").brancher(8).closer().add(new T(1,1,"P"));
        System.out.println(molec.getFormula());

    }

    public String getFormula() {
        StringBuilder sb = new StringBuilder();
        for (String[] elem : elems) {
            for (String e : elem){
                Stream<Atom> stream = atoms.stream().sorted((a1,a2) -> a1.getElement().compareTo(a2.getElement()));
                long count = stream.filter(a -> a.getElement().equals(e)).count();
                if (count > 1) sb.append(e).append(count);
                else if (count == 1) sb.append(e);
            }
        }
        return sb.toString();

    }

    public double getMolecularWeight() {
        double weight = 0.0;
        for (Atom a : this.atoms){
            weight += a.getAtomicWeight();
        }
        return weight;
    }


    public List<Atom> getAtoms() {
        return this.atoms;
    }

    public String getName() {
        return this.name;
    }

    public Branch[] getBranches() {
        return this.branches;
    }

    public Molecule brancher(int... args){
        this.branches = new Branch[args.length];
        for (int i = 0; i < args.length; i++) {
            this.branches[i] = new Branch(args[i]);
            for (Atom a : this.branches[i]) {
                atoms.add(a);
            }
        }
        return this;
    }

    public Molecule bounder(T... args) throws InvalidBondException{
        if (branches == null) return this;
        for (T t : args) {
            Atom from = this.branches[t.b1-1].get(t.c1);
            Atom to = this.branches[t.b2-1].get(t.c2);
            boolean valenceOk = false;
            for (int i=0 ; i < from.getBonds().length ; i++) {
                if (from.getBonds()[i] == null){
                    from.getBonds()[i] = to;
                    from.incrementNumBonds();
                    valenceOk = true;
                    break;
                }
            }
            if (!valenceOk) throw new InvalidBondException();
            for (int i=0 ; i < to.getBonds().length ; i++) {
                if (to.getBonds()[i] == null){
                    to.getBonds()[i] = from;
                    to.incrementNumBonds();
                    valenceOk = true;
                    break;
                }
            }
            if (!valenceOk) throw new InvalidBondException();
        }
        return this;
    }

    public Molecule mutate(T... args) throws InvalidBondException{
        for (T t : args) {
            Atom a = this.branches[t.nb-1].get(t.nc);
            a.mutate(t.elt);
        }
        return this;
    }

    public Molecule add(T... args) throws InvalidBondException{
        for (T t : args){
            Atom a = this.branches[t.nb-1].get(t.nc).add(t.elt);
            atoms.add(a);
        }
        return this;
    }

    public Molecule addChaining(int nc, int nb, String... args){
        Atom a = this.branches[nb-1].get(nc);
        Atom first = null;
        Atom temp = null;
        try{
            for (String s : args){
                temp = a.add(s);
                if (first == null) first = temp;
                atoms.add(temp);
                a = temp;
            }
        } catch (InvalidBondException e){
            System.err.println(e.getMessage());
        } finally {

            return this;
        }
    }

    public final Molecule closer(){
        for (Branch b : branches){
            b.forEach(new Consumer<Atom>() {
                @Override
                public void accept(Atom atom){
                    Atom a = null;
                    for (int i=0 ; i < atom.getBonds().length ; i++){
                        if (atom.getNumBonds() < atom.getValence()){
                            try{
                                a = atom.add("H");
                                atoms.add(a);
                            } catch (InvalidBondException e){
                                System.err.println(e.getMessage());
                            }
                        }
                    }
                }
            });
        }
        return this;
    }

    public String toString() {
        for (Branch b : branches) {
            System.out.println(b.toString());
        }
        return "";
    }
}
