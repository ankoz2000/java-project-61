package hexlet.code.utils;

public class RandomGenerator {
    private static final int MIN_NUMBER_OF_INTERVAL = 0;
    private static final int MAX_NUMBER_OF_INTERVAL = 100;

    private static final int OPERATIONS_COUNT = 3;

    public static int getRandomNumber() {
        return generateRandomNumber(MIN_NUMBER_OF_INTERVAL, MAX_NUMBER_OF_INTERVAL);
    }

    public static int getRandomNumberWithInterval(int low, int high) {
        return generateRandomNumber(low, high);
    }

    private static int generateRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }

    public static String getRandomOperation() {
        int min = 1;
        int number = generateRandomNumber(min, OPERATIONS_COUNT);

        int plusIntEquivalent = 1;
        int minusIntEquivalent = 2;
        if (number == plusIntEquivalent) {
            return "+";
        } else if (number == minusIntEquivalent) {
            return "-";
        }
        return "*";
    }
}
