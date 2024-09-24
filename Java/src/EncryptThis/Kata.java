package EncryptThis;

public class Kata {
    public static String encryptThis(String text){
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if (i==0) sb.append((int)c);
                else if (i==1) sb.append(word.charAt(word.length()-1));
                else if (i == word.length()-1) sb.append(word.charAt(1));
                else sb.append(c);
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(encryptThis("A wise old owl lived in an oak"));
    }
}
