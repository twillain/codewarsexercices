package TwoLowestIntegers;
import java.util.Arrays;

class Kata{
    public static long sumTwoSmallestNumbers(final long [] numbers) {

        long n1 = numbers[0];
        long n2 = numbers[1];

        for (int i=2 ; i < numbers.length ; i++){
            if (numbers[i] < n1){
                n2 = n1;
                n1 = numbers[i];
            } else if (numbers[i] < n2){
                n2 = numbers[i];
            }
        }
        return n1 + n2;
    }

    public static void main(String[] args) {
        long[] l = new long []{10, 343445353, 3453445,345354535};
        System.out.println(sumTwoSmallestNumbers(l));
    }
}
