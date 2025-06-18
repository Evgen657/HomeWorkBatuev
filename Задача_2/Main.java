package Задача_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Запрос ввода даты последнего полива
        System.out.print("Введите дату последнего полива (yyyy-MM-dd): ");
        String lastWateredDateString = scanner.nextLine();
        LocalDate lastWateredDate = LocalDate.parse(lastWateredDateString, formatter);

        // Создание экземпляра CactusWateringScheduler
        CactusWateringPlan scheduler = new CactusWateringPlan(lastWateredDate);
        LocalDate nextWateringDate = scheduler.getNextWateringDate();

        // Получение текущей влажности
        int currentHumidity = scheduler.getCurrentHumidity();

        // Ожидаемое сообщение о поливе кактуса
        if (nextWateringDate != null) {
            System.out.println("Кактус нужно полить в следующий раз: " + nextWateringDate);
        } else {
            System.out.println("Кактус не нуждается в поливе.");
        }

        // Вывод текущей влажности
        System.out.println("Текущая влажность: " + currentHumidity + "%");

        // Закрытие сканера
        scanner.close();
    }
}