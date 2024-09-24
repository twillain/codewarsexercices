package Int32ToIPv4;

public class Kata {
    public static String longToIP(long ip){
        String bit = Long.toBinaryString(ip);
        int diff = 32 - bit.length();
        if (diff > 0) bit = "0".repeat(diff).concat(bit);
        int binarySize = 8;
        int[] bytes = new int[4];
        for (int i=0 ; i < 4 ; i++){
            bytes[i] = Integer.parseInt(bit.substring(i*binarySize,(i+1)*binarySize),2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : bytes){
            sb.append(i).append('.');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String... args){
        //System.out.println(Long.toBinaryString(2149583361L));
        System.out.println(longToIP(0));
        System.out.println(longToIP(1361723013L));
        //System.out.println(Long.parseLong("01010001001010100011111010000101",2));
    }
}
