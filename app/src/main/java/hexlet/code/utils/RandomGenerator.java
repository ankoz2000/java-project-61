package hexlet.code.utils;

public class RandomGenerator {
    public static int getRandomNumber() {
        int minNumber = 0;
        int maxNumber = 100;
        return generateRandomNumber(minNumber, maxNumber);
    }

    public static int getRandomNumberWithInterval(int low, int high) {
        return generateRandomNumber(low, high);
    }

    private static int generateRandomNumber(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }

    public static String getRandomOperation() {
        int min = 1;
        int plusIntEquivalent = 1, minusIntEquivalent = 2;
        int max = 3;
        int number = generateRandomNumber(min, max);
        if (number == plusIntEquivalent) {
            return "+";
        } else if (number == minusIntEquivalent) {
            return "-";
        }
        return "*";
    }
}
