package RGB;

import java.util.HexFormat;

public class RGB {

    public static String rgb(int r, int g, int b) {
        if (r < 0 ) r=0;
        if (g < 0 ) g=0;
        if (b < 0 ) b=0;
        if (r > 255) r = 255;
        if (g > 255) g = 255;
        if (b > 255) b = 255;
        byte[] rgb = {(byte) r, (byte) g, (byte) b};

        return HexFormat.of().formatHex(rgb).toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(rgb(256,255,255));
        System.out.println(rgb(0,0,0));
        System.out.println(rgb(148,1,211));
    }
}
