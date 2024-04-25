public class StepTracker {

    private final YearData yearData = new YearData();

    private int dailyStepGoal = 10000;

    public void setStepsForDay(int steps, int month, int day) {
        yearData.setStepsForDay(steps, month, day);
    }

    public void setDailyStepGoal(int steps) {
        dailyStepGoal = steps;
    }

    private void printMonthSteps(int month) {
        for (int day = 1; day <= 30; day++) {
            System.out.println(day + " день: " + yearData.getStepsForDay(month, day));
        }
    }

    public void printStatisticsForMonth(int month) {
        MonthData monthData = yearData.getMonthData(month); // Получаем данные за нужный месяц
        int stepsSum = monthData.sumSteps();
        int stepsMax = monthData.findMaxSteps();
        int bestSeries = monthData.findBestSeries(dailyStepGoal);

        System.out.println("\nСтатистика за месяц " + month + ":");
        printMonthSteps(month);
        System.out.println("\nВсего пройдено шагов: " + stepsSum);
        System.out.println("Максимальное количество шагов за день: " + stepsMax);
        System.out.println("Среднее количество шагов за день: " + (stepsSum / 30));
        System.out.println(
                "Пройденное расстояние: " + Converter.convertStepsToKm(stepsSum) + " км");
        System.out.println("Сожжено: " + Converter.convertStepsToKcal(stepsSum) + " ккал");
        System.out.println("Лучшая серия: " + bestSeries + " дней");
    }
}