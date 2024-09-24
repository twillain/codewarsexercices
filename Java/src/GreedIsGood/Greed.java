package GreedIsGood;

public class Greed {

    public static int greedy(int[] dice){
        //count occurence of each dice
        int[] scores = new int[6];
        for (int d : dice){
            scores[d-1]++;
        }


        int score = 0 ;
        //sum the score
        for (int i=0 ; i < scores.length; i++){
            if (scores[i] >= 3){
                if (i==0) score += 1000;
                else score += (i+1)*100;
                scores[i] -= 3;
            }
            if (scores[i] > 0){
                if (i==0) score += scores[i]*100;
                if (i==4) score += scores[i]*50;
            }
        }
        return score;
    }

    public static void main(String...args){
        int[] test1 = {5,1,3,4,1};
        int[] test2 = {1,1,1,3,1};
        int[] test3 = {2,4,4,5,4};
        int[] test4 = {1,1,1,1,1};

        System.out.println(greedy(test1));
        System.out.println(greedy(test2));
        System.out.println(greedy(test3));
        System.out.println(greedy(test4));
    }
}
