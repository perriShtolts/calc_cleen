import java.util.Scanner;



public class CCC {
    static Scanner scanner = new Scanner(System.in);
    static String number1, number2, num1inRomRES,num2inRomRES;
    static String operation;
    static String result;
    static boolean r = true, g = false, h = true;


    public static void main(String[] args) {


        System.out.println("Введите выражение [2+2] или два римских числа [V+V] + Enter \nВНИМАНИЕ, калькулятор принимает числа от 1 и до 10 включительно");

        String userInput = scanner.nextLine();
        CCC.calc(userInput);


        if (r) {System.out.println("--Результат для арабских цифр----");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        } else {
            System.out.println("--Результат для арабских цифр----");
            String resultRoman = convertNumToRoman(result);
            System.out.println(num1inRomRES + " " + operation + " " + num2inRomRES + " = " + resultRoman);
        }



    }
    public static boolean checkRom (String chackRom1, String chackRom2){

        boolean x = true, c = true;

        switch (chackRom1) {
            case "I":
                x = false;
                break;
            case "II":
                x = false;
                break;
            case "III":
                x = false;
                break;
            case "IV":
                x = false;
                break;
            case "V":
                x = false;
                break;
            case "VI":
                x = false;
                break;
            case "VII":
                x = false;
                break;
            case "VIII":
                x = false;
                break;
            case "IX":
                x = false;
                break;
            case "X":
                x = false;
                break;
        }

        switch (chackRom2) {
            case "I":
                c = false;
                break;
            case "II":
                c = false;
                break;
            case "III":
                c = false;
                break;
            case "IV":
                c = false;
                break;
            case "V":
                c = false;
                break;
            case "VI":
                c = false;
                break;
            case "VII":
                c = false;
                break;
            case "VIII":
                c = false;
                break;
            case "IX":
                c = false;
                break;
            case "X":
                c = false;
                break;
        }

        if (x == false || c == false) {
            r = false;
        }

        return r;
    }

    public static String convertNumToRoman (String numArabian){
        int numArabianInt = Integer.parseInt(numArabian);
        String[] roman = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabianInt];
        return s;
    }


    private static String romanToNumber (String roman){

        //try {
        switch (roman) {
            case "I":
                return "1";

            case "II":
                return "2";

            case "III":
                return "3";

            case "IV":
                return "4";

            case "V":
                return "5";

            case "VI":
                return "6";

            case "VII":
                return "7";

            case "VIII":
                return "8";

            case "IX":
                return "9";

            case "X":
                return "10";

            default:
                return "error input rom";
        }

        //} catch (InputMismatchException e) {
        //throw new InputMismatchException("Неверный формат данных");
        //}

    }


    public static String calc (String input){
        char[] under_char = new char[11];

        for (int i = 0; i < input.length(); i++) {
            under_char[i] = input.charAt(i);
            if (under_char[i] == '+') {
                operation = "+";
            } else if (under_char[i] == '-') {
                operation = "-";
            } else if (under_char[i] == '*') {
                operation = "*";
            } else if (under_char[i] == '/') {
                operation = "/";
            }
        }

        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[/*+-]");
        String stable01 = blacks[0];
        String stable02 = blacks[1];

        String stable11 = stable01.trim();
        String stable22 = stable02.trim();

        num1inRomRES = stable11;
        num2inRomRES = stable22;


        if (blacks.length == 3) {
            g = true;
        }
        if (g) {
            throw new IllegalArgumentException("кадькулятор не может решать сразу 2 выражения, \nсначала решите первое, а за тем второе с результатом первого");
        }


        if (operation != "/") {
            if (operation != "*") {
                if (operation != "+") {
                    if (operation != "-") {

                        h = false;
                    }
                }
            }
        }

        checkRom(stable11, stable22);

        if (h != true) {
            throw new IllegalArgumentException("не верный знак операции");
        } else {

            if (r) {

                //try{
                //number1 = Integer.parseInt(stable11);
                //}catch (NumberFormatException u){
                //throw new NumberFormatException("первое число не в той системе счисления");
                //}
                //try{
                //number2 = Integer.parseInt(stable22);
                //}catch (NumberFormatException u){
                //throw new NumberFormatException("первое число не в той системе счисления");
                //}

                number1 = stable11;
                number2 = stable22;

                //checkInputNum(number1, number2);

                //result = calc(number1, number2, operation);

            } else {
                number1 = romanToNumber(stable11);
                number2 = romanToNumber(stable22);

                checkInputNum(number1, number2);

                if (number1 == "error input rom") {
                    throw new NumberFormatException("первое число не в той системе счисления или не подходит по размеру");
                }
                if (number2 == "error input rom") {
                    throw new NumberFormatException("второе число не в той системе счисления или не подходит по размеру");
                }


                //result = calc(number1, number2, operation);




            }
        }
        int num1Int = Integer.parseInt(number1);
        int num2Int = Integer.parseInt(number2);
        int resultInt;

        switch (operation) {
            case "+":
                resultInt = num1Int + num2Int;
                break;
            case "-":
                resultInt = num1Int - num2Int;
                break;
            case "*":
                resultInt = num1Int * num2Int;
                break;
            case "/":
                resultInt = num1Int / num2Int;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        if (resultInt < 1) {
            throw new IllegalArgumentException("в данной системе счисления нет чисел меньше 1");
        }

        result = String.valueOf(resultInt);
        return result;
    }


    public static void checkInputNum (String chack1, String chack2){
        int number1check = Integer.parseInt(chack1);
        int number2check = Integer.parseInt(chack2);

        if (number1check < 1 || number2check < 1) {

            throw new IllegalArgumentException("не верно введено 1 из чисел");

        } else if (number1check > 10 || number2check > 10) {

            throw new IllegalArgumentException("не верно введено 1 из чисел");
        }
    }
}
