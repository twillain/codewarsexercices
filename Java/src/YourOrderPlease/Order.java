package YourOrderPlease;

public class Order {
    public static String order(String words){
        if (words.isEmpty()) return "";
        String[] w = words.split(" ");
        String[] sorted = new String[w.length];

        for (int i=0; i<w.length; i++){
            for (int j=0; j<w[i].length(); j++){
                if (Character.isDigit(w[i].charAt(j))){
                    int k = Character.getNumericValue(w[i].charAt(j)-1);
                    sorted[k] = w[i];
                }
            }
        }
        String result = "";
        for (int i=0 ; i < sorted.length-1 ; i++){
            result += sorted[i] + " ";
        }
        result += sorted[sorted.length-1];
        return result;
    }

    public static void main(String... args){
        String s1 = "is2 Thi1s T4est 3a";
        String s2 = "4of Fo1r pe6ople g3ood th5e the2";
        String s3 = "";
        System.out.println(order(s1));
        System.out.println(order(s2));
        System.out.println(order(s3));
    }
}
