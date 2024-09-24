package Pangram;


public class PangramChecker {
    public boolean check(String sentence){
        sentence = sentence.toLowerCase();
        int[] letters = new int[26];

        for (int i=0 ; i < sentence.length() ; i++){
            char c = sentence.charAt(i);
            if (Character.isLetter(c)){
                letters[Character.getNumericValue(c)-10]++;
            }

        }

        for (int i : letters){
            if (i == 0) return false;
        }
        return true;
    }

    public static void main(String... args){
        PangramChecker p = new PangramChecker();
        System.out.println(p.check("You shall not pass!"));

    }
}
