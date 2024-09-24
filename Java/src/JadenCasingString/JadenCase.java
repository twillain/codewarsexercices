package JadenCasingString;

import java.util.function.Function;

public class JadenCase {

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase == "") return null;

        StringBuilder sb = new StringBuilder(phrase);
        boolean word = true;

        for (int i=0 ; i < sb.length() ; i++){
            char c = sb.charAt(i);

            if (Character.isLetter(c) && word){
                sb.setCharAt(i, Character.toUpperCase(c));
                word = false;
            }
            if (c == ' ') word = true;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        System.out.print(jadenCase.toJadenCase("ceci est un petit test des familles."));
        System.out.println("|");
    }

}
