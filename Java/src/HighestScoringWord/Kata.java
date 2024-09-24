package HighestScoringWord;

import java.util.stream.IntStream;

public class Kata {
    public static String high(String s){

        String[] words = s.split(" ");

        int highest = 0;
        String highestWord = "";

        for (int i=0; i<words.length; i++){
            int count = 0;
            for (int j=0 ; j<words[i].length(); j++){
                count += (int) words[i].charAt(j) - (int) 'a' + 1;
            }
            if (count > highest){
                highest = count;
                highestWord = words[i];
            }
        }

        return highestWord;
    }


    public static void main(String[] args) {
        System.out.println(high("what time are we climbing up to the volcano"));
    }
}
