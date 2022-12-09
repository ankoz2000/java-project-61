package hexlet.code.utils;

public class Utils {
    public static int getRandomNumberWithInterval(int low, int high) {
        return (int) ((Math.random() * (high - low)) + low);
    }
}
