//Имеется гирлянда, состоящая из 32 лампочек. Каждая лампочка имеет
//два состояния - включена или выключена. 
//Реализованы следующие методы:
//1. метод blink, который будет мигать лампочками гирлянды один раз
//(операция ~);
//2. метод run, который будет запускать гирлянду в режим бегущей
//строки (операция << или >>);
//3. метод isFirstLampOn, который будет выяснять включена ли лампочка
//в первой позиции (наложение маски с помощью &);
//4. метод, который будет распечатывать текущее состояние гирлянды.
//Для получения двоичного формата числа используется метод
//Integer.toBinaryString(a).
//5. Используются побитовые операции.
/*************  ✨ Codeium Command 🌟  *************/
//Добавить следующий функционал:
//1. Помощью класса Scanner введите число от 1 до 4.
//2. Если введено число 1 - выполните метод мигания, 2 - проверку
//первой лампочки, 3 - метод бегущей строки, 4 - вывод состояния
//гирлянды на консоль.
//3. Для выбора режима используйте оператор switch.
//4. Измените метод мигания: метод должен мигнуть гирляндой 10 раз.
//Используем оператор for.
//5. Измените метод бегущей строки: метод должен выполнить
//операцию 10 раз. Используем оператор for.

import java.util.Random;
import java.util.Scanner;

public class Number11 {
    private int state; // состояние гирлянды (32 бита)

    public Number11() {
        Random random = new Random();
        state = 0; // начнем с нулевого состояния
        // Инициализируем каждый бит случайным образом
        for (int i = 0; i < 32; i++) {
            // Если случайное значение четное, то включаем лампочку, иначе выключаем
            if (random.nextBoolean()) {
                state |= (1 << i); // устанавливаем бит на позицию i
            }
        }
    }

    public void blink() {
        state = ~state; // мигание лампочками гирлянды
    }

    public void run() {
        state = (state << 1) | (state >>> 31); // запуск гирлянды в режим бегущей строки
    }

    public boolean isFirstLampOn() {
        return (state & (1 << 31)) != 0; // проверка включена ли лампочка в первой позиции
    }

    public void printWholeNumber() {
         // Приводим к 32-битному двоичному представлению, добавляя ведущие нули
        String binaryString = String.format("%32s", Integer.toBinaryString(state)).replace(' ', '0');
        System.out.println(binaryString);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number(1 - blinking method, 2 - checking the first light, 3 - running line mode, 4 - print of the garland state): ");
        int number = scanner.nextInt();
        Number11 garland = new Number11(); // создание нового экземпляра гирлянды с случайным состоянием
        //System.out.println("Initial state of the garland:");
        //garland.printWholeNumber();

        switch (number) {
            case 1:
                System.out.println("Blinking lights:");
                for (int i = 0; i < 10; i++) {
                    garland.blink();
                    garland.printWholeNumber();
                }
                break;
            case 2:
                System.out.println("Is the first light on?");
                System.out.println(garland.isFirstLampOn());
                break;
            case 3:
                System.out.println("Running line mode:");
                for (int i = 0; i < 10; i++) {
                    garland.run();
                    garland.printWholeNumber();
                }
                break;
            case 4:
                System.out.println("State of the garland:");
                garland.printWholeNumber();
                break;
            default:
                System.out.println("Incorrect number");
        }
    }
}