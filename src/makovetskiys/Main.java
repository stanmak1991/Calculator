package makovetskiys;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        String FirstNum = Calculator.EnterNum();
        System.out.print("Введите оператор: ");
        char operation = Calculator.EnterOperation();
        System.out.print("Введите второе число: ");
        String SecondNum = Calculator.EnterNum();
        Calculator.Calculate(FirstNum, operation, SecondNum);
    }
}

