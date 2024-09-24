package PINValidation;

public class Pin {
    public static boolean validePin(String pin) {
        if (pin.length() != 6 && pin.length() != 4) return false;

        return pin.chars().allMatch(Character::isDigit);
    }

    public static void main(String[] args) {
        System.out.println(Pin.validePin("1234"));
        System.out.println(Pin.validePin("0000"));
        System.out.println(Pin.validePin("1111"));
        System.out.println(Pin.validePin("123456"));
        System.out.println(Pin.validePin("098765"));
        System.out.println(Pin.validePin("a234"));
        System.out.println(Pin.validePin("1"));
        System.out.println(Pin.validePin("1234567"));

    }
}
