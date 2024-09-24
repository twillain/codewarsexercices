package ParseIntReloaded;

public class Parser {

    public static int parseInt(String numStr) {
        String[] parts = numStr.split(" and | ");
        int total = 0;
        int sum = 0;
        for (String part : parts) {
            int i = strToAdditioner(part);
            if (i > 0) sum += i;
            i = strToMultiplicationer(part);
            if (i > 0) {
                sum *= i;
            }
            if (i > 100){
                total += sum;
                sum = 0;
            }
        }
        total += sum;
        return total;
    }

    public static int strToAtomicNum(String numStr) {
        return switch (numStr) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            case "ten" -> 10;
            case "eleven" -> 11;
            case "twelve" -> 12;
            case "thirteen" -> 13;
            case "fourteen" -> 14;
            case "fifteen" -> 15;
            case "sixteen" -> 16;
            case "seventeen" -> 17;
            case "eighteen" -> 18;
            case "nineteen" -> 19;
            default -> 0;
        };
    }

    public static int strToAdditioner(String numStr){
        String[] tens = numStr.split("-");
        int ten = switch (tens[0]) {
            case "twenty" -> 20;
            case "thirty" -> 30;
            case "forty" -> 40;
            case "fifty" -> 50;
            case "sixty" -> 60;
            case "seventy" -> 70;
            case "eighty" -> 80;
            case "ninety" -> 90;
            default -> 0;
        };
        if (tens.length > 1) ten += strToAtomicNum(tens[1]);
        else ten += strToAtomicNum(tens[0]);
        return ten;
    }

    public static int strToMultiplicationer(String numStr){
        return switch(numStr) {
            case "hundred" -> 100;
            case "thousand" -> 1000;
            case "million" -> 1000000;
            default -> 0;
        };
    }


    public static void main(String... args){
        System.out.println(strToAdditioner("twenty"));
        System.out.println(strToAdditioner("eighty-three"));
        System.out.println(strToAdditioner("five"));
        System.out.println(strToAdditioner("zero"));
        System.out.println("---------------------------------");
        System.out.println(parseInt("one"));
        System.out.println(parseInt("twenty"));
        System.out.println(parseInt("two hundred forty-six"));
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }


}
