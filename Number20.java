//20. На строке в позициях 1 до 79 набито арифметическое выражение. В
//нечетных позициях набиты цифры, в четных - знаки арифметических
//операций: "+" (сложение), "-" (вычитание), "*" (умножение) и "/" (деление).
//Напечатать числовое значение арифметического выражения. Порядок
//выполнения операций соответствует общепринятому.

import java.util.Scanner;

public class Number20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        String expression = scanner.nextLine();
        
        // Проверяем корректность длины строки
        if (expression.length() % 2 == 0 || expression.length() < 3 || expression.length() > 79) {
            System.out.println("Incorrect expression!");
            return;
        }

        try {
            // Вычисляем результат
            int i = 0;
            float[] numbers = new float[expression.length() / 2 + 1];
            String[] operators = new String[expression.length() / 2]; 
            while (i < expression.length()) {
                if (i% 2 == 0){
                    numbers[i/2] = Character.getNumericValue(expression.charAt(i));
                }
                else{
                    operators[i/2] = Character.toString(expression.charAt(i));  
                }
                i++;
            } 
            float result = 0;
            float[] numbers2 = new float[expression.length() / 2 + 1];
            i=0; 
            int m = 0;
            while(i < (expression.length() / 2+1)){
                if (i==0){
                    numbers2[i] = numbers[i];
                    i++;
                    continue;
                }
                switch (operators[i-1]) {
                    case "+":
                        numbers2[i-m] = numbers[i];
                        i++;
                        continue;
                    case "-":
                        numbers2[i-m] = numbers[i];
                        i++;
                        continue;
                    case "*":
                        numbers2[i-m-1] = numbers2[i-m-1] * numbers[i];
                        m++;
                        i++;
                        continue;
                    case "/":
                        numbers2[i-m-1] = numbers2[i-m-1] / numbers[i];
                        m++;
                        i++;
                        continue;
                        
                }
            }
            i=0;
            m=0;
            while(i < (expression.length() / 2+1)){
                if (i==0){
                    result = numbers2[i];
                    i++;
                    continue;
                }
                switch (operators[i-1]) {
                    case "+":
                        result += numbers2[i-m];
                        i++;
                        continue;
                    case "-":
                        result -= numbers2[i-m];
                        i++;
                        continue;
                    case "*":
                        m++;
                        i++;
                        continue;
                    case "/":
                        m++;
                        i++;
                        continue;
                        
                }
                i++;
            }
            System.out.println("The result of the expression: " + result); 
        } 
        catch (Exception e) {
            System.out.println("Error in calculation: " + e.getMessage());
        }
    }
}
