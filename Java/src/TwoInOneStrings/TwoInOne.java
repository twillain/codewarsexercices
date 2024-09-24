package TwoInOneStrings;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoInOne {
    public static String longest(String s1, String s2){
        IntStream s = IntStream.concat(s1.codePoints(), s2.codePoints());
        return s.distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }


    public static void main(String[] args) {
        System.out.println(longest("abcd", "abcd"));
    }
}
