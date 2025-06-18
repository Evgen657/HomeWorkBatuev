package Задача_2;

import java.util.Random;

public class HumiditySensor {
    private Random random;

    public HumiditySensor() {
        this.random = new Random();
    }

    // Для получения случайного значения влажности от 0 до 100
    public int getHumidity() {
        return random.nextInt(100); // Возвращает значение от 0 до 100, для теста можно уменьшить число
    }
}