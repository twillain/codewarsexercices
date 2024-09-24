package SumSumSum;
import java.math.BigInteger;

public class Solution {


    public static BigInteger sumOfSums(int n){
        BigInteger k = new BigInteger(String.valueOf(n));
        BigInteger z = k.multiply(k.add(BigInteger.ONE)).multiply(k.add(new BigInteger(String.valueOf(2)))).divide(new BigInteger(String.valueOf(6)));
        //Z = N*(N+1)*(N+2)/6
        return z.multiply(z.add(BigInteger.ONE)).divide(new BigInteger(String.valueOf(2))); //Z*(Z+1)/2
    }



     public static void main(String[] args) {
        System.out.println(sumOfSums(151));
    }
}
