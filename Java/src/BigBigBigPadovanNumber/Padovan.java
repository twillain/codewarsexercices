package BigBigBigPadovanNumber;

import java.math.BigInteger;
import java.util.ArrayList;

public class Padovan {

    public static BigInteger get(long power){
        if (power < 3) return BigInteger.ONE;

        return null;
    }

    public static void main(String[] args) {
        System.out.println(get(100));
    }
}
