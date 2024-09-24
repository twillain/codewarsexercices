package DigitalRoot;

import java.util.stream.IntStream;

public class DRoot {
    public static int digital_root(int n){
        if (n < 10) return n;
        IntStream.Builder builder = IntStream.builder();
        while (n > 0){
            builder.add(n % 10);
            //System.out.println(n%10);
            n /= 10;
        }
        IntStream stream = builder.build();
        return digital_root(stream.sum());
    }

    public static void main(String[] args) {
        System.out.println(DRoot.digital_root(456));
    }
}
