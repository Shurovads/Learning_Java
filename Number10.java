//Имеется гирлянда, состоящая из 32 лампочек. Каждая лампочка имеет
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


import java.util.Random;

public class Number10 {
    private int state; // состояние гирлянды (32 бита)

    public Number10() {
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

    /*public void printState() {
        System.out.println(Integer.toBinaryString(state)); // печать текущего состояния гирлянды
    }*/

    public void printWholeNumber() {
         // Приводим к 32-битному двоичному представлению, добавляя ведущие нули
        String binaryString = String.format("%32s", Integer.toBinaryString(state)).replace(' ', '0');
        System.out.println(binaryString);
    }

    public static void main(String[] args) {
        Number10 garland = new Number10(); // создание нового экземпляра гирлянды с случайным состоянием
        System.out.println("Initial state of the garland:");
        //garland.printState();
        garland.printWholeNumber();

        System.out.println("Blinking lights:");
        garland.blink();
        //garland.printState();
        garland.printWholeNumber();

        System.out.println("Running line mode:");
        garland.run();
        //garland.printState();
        garland.printWholeNumber();

        System.out.println("Is the first light on?");
        System.out.println(garland.isFirstLampOn());
    }
}