import java.util.Scanner;

public class Confession {
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем длину забора у пользователя
        System.out.print("Введите длину забора в см: ");
        int fenceLength = scanner.nextInt();

        // Константы
        int lettersCount = 15; // количество букв
        int spacesCount = 3;   // количество пробелов

        // Расчет длины надписи
        int lengthForLetters = (lettersCount / 3) * 62; // длина для букв
        int lengthForSpaces = spacesCount * 12;          // длина для пробелов

        // Общая длина надписи
        int totalLength = lengthForLetters + lengthForSpaces; // 346 см надо чтобы текст поместился на заборе

        // Проверка, поместится ли надпись на заборе
        if (totalLength <= fenceLength) {
            System.out.println("Надпись поместится на заборе.");
        } else {
            System.out.println("Надпись не поместится на заборе.");
        }

        // Закрытие сканера
        scanner.close();
    }
}
