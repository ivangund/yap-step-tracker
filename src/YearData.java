public class YearData {

    private final MonthData[] months = new MonthData[12];

    public YearData() {
        // Заполняем массив объектами MonthData
        for (int i = 0; i < months.length; i++) {
            months[i] = new MonthData();
        }
    }

    public MonthData getMonthData(int month) {
        // Вычитаем единицу, так как получаем нумерацию от 1
        return months[month - 1];
    }

    public int getStepsForDay(int month, int day) {
        // Вычитаем единицу, так как получаем нумерацию от 1
        return months[month - 1].getStepsForDay(day);
    }

    public void setStepsForDay(int steps, int month, int day) {
        // Вычитаем единицу, так как получаем нумерацию от 1
        months[month - 1].setStepsForDay(day, steps);
    }
}
