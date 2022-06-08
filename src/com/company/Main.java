package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        int num1;
        int num2;
        while (true){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение, состоящее только из арабских или только из римских цифр через пробел и нажмите Enter");
        String userInput = sc.nextLine();

        try {

            String[] in = userInput.split(" ");
            String number1 = in[0];
            String number2 = in[2];
            char operation = in[1].charAt(0);


            if (in.length > 3)
                throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");


            if (isNumeric(number1)) {
                if ((Integer.parseInt(number1) <= 0 || Integer.parseInt(number1) > 11) || (Integer.parseInt(number2) <= 0 || Integer.parseInt(number2) > 11)) {
                    throw new Exception("Введите числа от 1 до 10.");
                }

                int num12 = Integer.parseInt(number1);
                int num22 = Integer.parseInt(number2);
                String resultArab = calc(num12, num22, operation);
                System.out.println(num12 + " " + operation + " " + num22 + " = " + resultArab);
            } else {

                num1 = romanToNumber(number1);
                num2 = romanToNumber(number2);
                if ((num1 <= 0 || num1 > 11) || (num2 <= 0 || num2 > 11)) {
                    throw new Exception("Введите числа от I до X.");
                }
                if (num1-num2<= 0 && operation=='-') throw new Exception("В римской системе нет отрицательных чисел.");
                String result = calc(num1, num2, operation);
                String resultRom = convertNumToRoman(result);
                System.out.println(number1 + " " + operation + " " + number2 + " = " + resultRom);


            }
        }catch (NumberFormatException e){
            throw new Exception("В выражении используются одновременно разные системы счисления.");
        } catch (IndexOutOfBoundsException e){
            throw new Exception("Введенная строка не является математической операцией, либо Вы забыли про пробелы.");
        }
    }
    }
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    static String convertNumToRoman(String  numArabian) {

        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        return roman[Integer.parseInt(numArabian)];

        }

    static int romanToNumber(String roman) {

        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;
        };


    }

    public static String calc(int num1, int num2, char oper) {
        if(num1<0 || num1>10 || num2<0 || num2>10) throw new IllegalArgumentException("Введенное число меньше 0 или больше 10.");
        int result = switch (oper) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalArgumentException("Вы ввели неверный знак.");
        };
        return String.valueOf(result);
    }
}



