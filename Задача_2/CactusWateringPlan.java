package Задача_2;

import java.time.LocalDate;

public class CactusWateringPlan {
    private LocalDate lastWateredDate;
    private HumiditySensor humiditySensor;

    public CactusWateringPlan(LocalDate lastWateredDate) {
        this.lastWateredDate = lastWateredDate;
        this.humiditySensor = new HumiditySensor();
    }

    // Метод для определения, когда поливать кактус
    public LocalDate getNextWateringDate() {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int daysSinceLastWatering = (int) (today.toEpochDay() - lastWateredDate.toEpochDay());

        // Проверка сезона
        if (month >= 12 || month <= 2) { // Зима
            return lastWateredDate.plusMonths(1);
        } else if (month >= 3 && month <= 5) { // Весна
            return lastWateredDate.plusWeeks(1);
        } else { // Лето и Осень поливает по влажности погоды
            int humidity = humiditySensor.getHumidity();
            if (humidity < 30) {
                if (daysSinceLastWatering >= 2) {
                    return today; // Нужно полить сегодня
                } else {
                    return lastWateredDate.plusDays(2 - daysSinceLastWatering);
                }
            } else { // Если влажность 30% или выше, полив не требуется
                return null; // Не нужно поливать
            }
        }
    }

    // Метод для получения текущей влажности
    public int getCurrentHumidity() {
        return humiditySensor.getHumidity();
    }
}