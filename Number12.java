 //9.Напишите программу на Java, чтобы поменять местами значения,
//хранящиеся в двух переменных, без использования третьей
//переменной.
//10.Имеется гирлянда, состоящая из 32 лампочек. Каждая лампочка имеет
//два состояния - включена или выключена. В начале работы программы
//случайным образом задайте какие лампочки будут включены.
//Напишите следующие методы:
//1. метод blink, который будет мигать лампочками гирлянды один раз
//(операция ~);
//2. метод run, который будет запускать гирлянду в режим бегущей
//строки (операция << или >>);
//3. метод isFirstLampOn, который будет выяснять включена ли лампочка
//в первой позиции (наложение маски с помощью &);
//4. метод, который будет распечатывать текущее состояние гирлянды.
//Для получения двоичного формата числа используйте метод
//Integer.toBinaryString(a).
//5. Используйте побитовые операции.
//12.Используя условия задачи 9 и 10, реализовать гирлянду, используя
//массивы. Для реализации бегущей строки используйте метод
//System.arraycopy(...).

import java.util.Random;

public class Number12 {
    // Массив для хранения состояния гирлянды (32 лампочки)
    private boolean[] lamps = new boolean[32];

    // Конструктор инициализирует гирлянду случайным образом
    public Number12() {
        Random random = new Random();
        // Инициализируем каждую лампочку случайным значением
        for (int i = 0; i < lamps.length; i++) {
            lamps[i] = random.nextBoolean(); // случайное включение или выключение лампочки
        }
    }

    // Метод для мигания лампочками (инверсия состояния каждой лампочки)
    public void blink() {
        for (int i = 0; i < lamps.length; i++) {
            lamps[i] = !lamps[i]; // инвертируем состояние каждой лампочки
        }
    }

    // Метод для режима бегущей строки с использованием System.arraycopy
    public void run() {
        boolean firstLamp = lamps[0]; // сохраняем состояние первой лампочки
        System.arraycopy(lamps, 1, lamps, 0, lamps.length - 1); // сдвигаем элементы массива на один влево
        lamps[lamps.length - 1] = firstLamp; // помещаем первую лампочку в конец массива
    }

    // Метод для проверки, включена ли первая лампочка
    public boolean isFirstLampOn() {
        return lamps[0];
    }

    // Метод для печати текущего состояния гирлянды
    public void printState() {
        for (boolean lamp : lamps) {
            System.out.print(lamp ? "1" : "0"); // выводим "1" для включенных лампочек и "0" для выключенных
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Number12 garland = new Number12();

        System.out.println("State of the garland:");
        garland.printState();

        System.out.println("\nBlinking lights:");
        garland.blink();
        garland.printState();

        System.out.println("\nRunning line mode:");
        garland.run();
        garland.printState();

        System.out.println("\nIs the first light on?");
        System.out.println(garland.isFirstLampOn() ? "Yes" : "No");
    }
}

