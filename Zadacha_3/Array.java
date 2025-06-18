package Zadacha_3;

public class Array {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int secondLargest = SecondElement.findSecondLargest(array);

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Второй по величине элемент: " + secondLargest);
        } else {
            System.out.println("Нет второго по величине элемента.");
        }
    }
}

