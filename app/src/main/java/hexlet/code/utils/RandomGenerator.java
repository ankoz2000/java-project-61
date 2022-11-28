package hexlet.code.utils;

public class RandomGenerator {
    public static int getRandomNumber() {
        int minNumber = 0;
        int maxNumberOfInterval = 100;

        return generateRandomNumber(minNumber, maxNumberOfInterval);
    }

    public static int getRandomNumberWithInterval(int low, int high) {
        return generateRandomNumber(low, high);
    }

    private static int generateRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }

    public static String getRandomOperation() {
        int min = 1;
        int maxNumberOfInterval = 3;

        int plusIntEquivalent = 1;
        int minusIntEquivalent = 2;

        int number = generateRandomNumber(min, maxNumberOfInterval);
        if (number == plusIntEquivalent) {
            return "+";
        } else if (number == minusIntEquivalent) {
            return "-";
        }
        return "*";
    }
}
