//Напишите программу на Java, чтобы поменять местами значения,
//хранящиеся в двух переменных, без использования третьей
//переменной.
import java.util.Scanner;

public class Number9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = scanner.nextInt();
        System.out.print("Input b: ");
        int b = scanner.nextInt();
        //int a = 5;
        //int b = 10;

        System.out.println("Before exchange: a = " + a + ", b = " + b);

        // Меняем местами значения без использования третьей переменной
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After exchange: a = " + a + ", b = " + b);
    }
}