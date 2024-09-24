package FMC;

public class InvalidBondException extends Exception{

    public InvalidBondException(){
        super("Exceeds valence number or bounded to itself");
    }
}
