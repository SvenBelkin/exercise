import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }
    public static String parse(String expression) throws Exception {
        int num1;
        int num2;
        String operation;
        String result;
        boolean isRoman;
        String[] number = expression.split("[+ \\-*/]");
        if (number.length != 2) throw new Exception("Должно быть два числа!");
        operation = detectOperation(expression);

        if (Roman.isRoman(number[0]) & Roman.isRoman(number[1])) {
            num1 = Roman.convertToArabic(number[0]);
            num2 = Roman.convertToArabic(number[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(number[0]) & !Roman.isRoman(number[1])) {
            num1 = Integer.parseInt(number[0]);
            num2 = Integer.parseInt(number[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 | num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(num1, num2, operation);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String detectOperation(String expression) {
        if (expression.contains("+")){
            return "+";
        } else if (expression.contains("-")) {
            return "-";
        } else if (expression.contains("*")) {
            return "*";
        } else {
            return "/";}
    }
    static int calc(int a, int b, String operation) {
        if (operation.equals("+")){
            return a + b;
        } else if (operation.equals("-")){
            return a - b;
        } else if (operation.equals("*")){
            return a * b;
        } else {
            return a / b;
        }
    }
}
class Roman {
    static String[] romanNum = new String[]{null,"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
    public static boolean isRoman(String val) {
        for (int i = 0; i < romanNum.length; i++) {
            if (val.equals(romanNum[i])) {
                return true;
            }
        }
        return false;
    }
    public static int convertToArabic(String roman) {
        for (int i = 0; i < romanNum.length; i++) {
            if (roman.equals(romanNum[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabic) {
        return romanNum[arabic];
    }

}
