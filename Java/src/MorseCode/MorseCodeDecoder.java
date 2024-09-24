package MorseCode;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;

public class MorseCodeDecoder {

    public static String decodeBits(String bits){
        String[] s = bits.split("00");
        System.out.println(s);

        StringBuilder morseString = new StringBuilder();
        int count = 0;
        for (String a : s){
            if (a.length() == 0) count++;
            if (a.length() != 0){
                if (count == 2) morseString.append(' ');
                else if (count == 6) morseString.append("   ");
                count = 0;
            }
            if (a.length() == 2) morseString.append('.');
            else if (a.length() == 6) morseString.append('-');
        }
        return morseString.toString();
    }

    public static String decodeMorse(String morseCode){
        HashMap<String,String> morseTable = new HashMap<>();
        morseTable.put(".-","A");
        morseTable.put("-...","B");
        morseTable.put("-.-.","C");
        morseTable.put("-..","D");
        morseTable.put(".","E");
        morseTable.put("..-.","F");
        morseTable.put("--.","G");
        morseTable.put("....","H");
        morseTable.put("..","I");
        morseTable.put(".---","J");
        morseTable.put("-.-","K");
        morseTable.put(".-..","L");
        morseTable.put("--","M");
        morseTable.put("-.","N");
        morseTable.put("---","O");
        morseTable.put(".--.","P");
        morseTable.put("--.-","Q");
        morseTable.put(".-.","R");
        morseTable.put("...","S");
        morseTable.put("-","T");
        morseTable.put("..-","U");
        morseTable.put("...-","V");
        morseTable.put(".--","W");
        morseTable.put("-..-","X");
        morseTable.put("-.--","Y");
        morseTable.put("--..","Z");
        morseTable.put(".----","1");
        morseTable.put("..---","2");
        morseTable.put("...--","3");
        morseTable.put("....-","4");
        morseTable.put(".....","5");
        morseTable.put("-....","6");
        morseTable.put("--...","7");
        morseTable.put("---..","8");
        morseTable.put("----.","9");
        morseTable.put("-----","0");

        String[] letters = morseCode.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String a : letters){
            if (a.length() == 0){
                count++;
                if (count == 2){
                    sb.append(' ');
                    count = 0 ;
                }
            } else {
                sb.append(morseTable.get(a));
            }
        }
        return sb.toString();
    }


    public static void main(String... args) throws Exception {
        String testBits = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        String expectedResult = "HEY JUDE";
        System.out.println("Result = " + decodeMorse(decodeBits(testBits)));
        System.out.println("Working ? " + decodeMorse(decodeBits(testBits)).equals(expectedResult));
        System.out.println((int) '-');
    }

}
