public class Converter {

    public static int cmPerStep = 75;
    public static int calPerStep = 50;

    public static int convertStepsToKm(int steps) {
        return steps * cmPerStep / 100000;
    }

    public static int convertStepsToKcal(int steps) {
        return steps * calPerStep / 1000;
    }
}
