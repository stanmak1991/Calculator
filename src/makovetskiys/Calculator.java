package makovetskiys;

import java.util.HashMap;
import java.util.Scanner;

class Calculator {
    private static Scanner scan;
    private static HashMap<String, Integer> RomanNumbers = new HashMap<>() {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    public static String EnterNum() {
        scan = new Scanner(System.in);
        String line = "";

        if (scan.hasNextLine()) {
            line = scan.nextLine();
            line = line.toUpperCase();
            if (RomanNumbers.containsKey(line) || TryParse(line)) {
                return line;
            } else {
                System.out.println("Некорректный ввод, повторите");
                line = EnterNum();
            }
        }
        return line;
    }

    public static char EnterOperation() {
        scan = new Scanner(System.in);
        char operation = ' ';
        if (scan.hasNext()) {
            operation = scan.next().charAt(0);
            if (operation == '+' || operation == '-' || operation == '*' || operation == '/')
                return operation;
            else {
                System.out.println("Некорректный ввод, повторите");
                operation = EnterOperation();
            }
        }
        return operation;
    }

    private static boolean TryParse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void Calculate(String FirstNumber, char operation, String SecondNumber) {
        if (TryParse(FirstNumber) != TryParse(SecondNumber))
            System.out.println("Ввод не может включать одновременно римские и арабские числа");
        else {
            int temp0;
            int temp1;

            if (TryParse(FirstNumber)) {
                temp0 = Integer.parseInt(FirstNumber);
                temp1 = Integer.parseInt(SecondNumber);
            } else {
                temp0 = RomanNumbers.get(FirstNumber);
                temp1 = RomanNumbers.get(SecondNumber);
            }

            switch (operation) {
                case '+':
                    System.out.println("Результат: " + (temp0 + temp1));
                    break;
                case '-':
                    System.out.println("Результат: " + (temp0 - temp1));
                    break;
                case '*':
                    System.out.println("Результат: " + (temp0 * temp1));
                    break;
                case '/':
                    System.out.println("Результат: " + (temp0 / temp1));
                    break;
            }
        }
    }

}