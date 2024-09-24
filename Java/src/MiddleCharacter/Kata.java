package MiddleCharacter;

public class Kata {
    public static String getMiddle(String word){
        if (word.length() == 1) return word;
        int middle = (int) word.length()/2;
        if (word.length()%2 == 0){

            return word.substring(middle-1 , middle+1);
        } else {
            return word.substring(middle,middle+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getMiddle("test"));
        System.out.println(getMiddle("testing"));
        System.out.println(getMiddle("middle"));
        System.out.println(getMiddle("A"));
        System.out.println(getMiddle("ab"));

    }
}
