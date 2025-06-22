package Zadacha_4;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"К", "Н", "Б"};
        String[] optionsNames = {"камень", "ножницы", "бумага"};

        int userScore = 0;     // Счет пользователя
        int computerScore = 0; // Счет компьютера
        int rounds = 5;        // Количество раундов

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Раунд " + round + ":");
            System.out.println("Введите 'К' для камня, 'Н' для ножниц, 'Б' для бумаги. Для выхода введите 'В'.");

            String userInput = scanner.nextLine().toUpperCase();

            // Сообщение при выходе
            if (userInput.equals("В")) {
                System.out.println("Спасибо за игру!");
                return;
            }

            // Сообщение при вводе некорректного значения
            if (!userInput.equals("К") && !userInput.equals("Н") && !userInput.equals("Б")) {
                System.out.println("Некорректный ввод. Пожалуйста, попробуйте снова.");
                round--; // Не увеличиваем раунд при некорректном вводе
                continue;
            }

            // Рандомный ввод компьютера
            int computerChoiceIndex = random.nextInt(options.length);
            String computerChoice = options[computerChoiceIndex];

            // Вывод выбора
            System.out.println("Вы выбрали: " + optionsNames[getIndex(userInput)]);
            System.out.println("Компьютер выбрал: " + optionsNames[computerChoiceIndex]);

            // Вычисляем победителя и начисление баллов
            if (userInput.equals(computerChoice)) {
                System.out.println("Ничья!");
            } else if (
                    (userInput.equals("К") && computerChoice.equals("Н")) ||         // Игрок выигрывает камнем
                            (userInput.equals("Н") && computerChoice.equals("Б")) || // Игрок выигрывает ножницами
                            (userInput.equals("Б") && computerChoice.equals("К"))    // Игрок выигрывает бумагой
            ) {
                System.out.println("Вы выиграли!");
                userScore += getPoints(userInput);         // Начисление баллов игроку
            } else {
                System.out.println("Вы проиграли!");
                computerScore += getPoints(computerChoice); // Начисление баллов компьютеру
            }

            // Вывод текущего счета после раунда
            System.out.println("Текущий счет: Вы " + userScore + " - " + computerScore + " Компьютер");
            System.out.println();
        }

        // Итоговый результат
        System.out.println("Игра окончена!");
        System.out.println("Ваш счет: " + userScore);
        System.out.println("Счет компьютера: " + computerScore);

        // Объявление победителя
        if (userScore > computerScore) {
            System.out.println("Поздравляем! Вы победили!");
        } else if (userScore < computerScore) {
            System.out.println("Компьютер победил! Попробуйте снова.");
        } else {
            System.out.println("Ничья! Отличная игра!");
        }

        scanner.close();
    }

    // Метод для получения индекса выбора
    private static int getIndex(String userInput) {
        switch (userInput) {
            case "К": return 0; // камень
            case "Н": return 1; // ножницы
            case "Б": return 2; // бумага
            default: return -1; // неверный ввод
        }
    }

    // Метод для получения баллов в игре
    private static int getPoints(String choice) {
        switch (choice) {
            case "К": return 1; // 1 балл за камень
            case "Н": return 2; // 2 балла за ножницы
            case "Б": return 5; // 5 баллов за бумагу
            default: return 0; // при ничье и некорректный ввод - 0 баллов
        }
    }
}