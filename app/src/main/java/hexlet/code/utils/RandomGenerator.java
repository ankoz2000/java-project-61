package hexlet.code.utils;

public class RandomGenerator {
    private static final int minNumberOfInterval = 0;
    private static final int maxNumberOfInterval = 100;

    private static final int operationsCount = 3;

    public static int getRandomNumber() {
        return generateRandomNumber(minNumberOfInterval, maxNumberOfInterval);
    }

    public static int getRandomNumberWithInterval(int low, int high) {
        return generateRandomNumber(low, high);
    }

    private static int generateRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }

    public static String getRandomOperation() {
        int min = 1;
        int number = generateRandomNumber(min, operationsCount);

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
