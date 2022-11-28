package hexlet.code.utils;

import java.util.Calendar;
import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber() {
        return generateRandomNumber(0, 100);
    }

    public static int getRandomNumberWithInterval(int low, int high) {
        return generateRandomNumber(low, high);
    }

    private static int generateRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }

    public static String getRandomOperation() {
        int number = generateRandomNumber(1, 3);
        if (number == 1) {
            return "+";
        } else if (number == 2) {
            return "-";
        }
        return "*";
    }
}
