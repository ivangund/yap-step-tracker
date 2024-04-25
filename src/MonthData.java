public class MonthData {

    private final int[] days = new int[30];

    public int getStepsForDay(int day) {
        return days[day - 1]; // Вычитаем единицу, так как получаем нумерацию от 1
    }

    public void setStepsForDay(int day, int steps) {
        days[day - 1] = steps; // Вычитаем единицу, так как получаем нумерацию от 1
    }

    public int sumSteps() {
        // Находим сумму шагов за весь месяц
        int sum = 0;
        for (int steps : days) {
            sum += steps;
        }
        return sum;
    }

    public int findMaxSteps() {
        // Находим максимальное количество шагов за день
        int maxSteps = 0;
        for (int steps : days) {
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }
        return maxSteps;
    }

    public int findBestSeries(int dailyStepGoal) {
        // Находим длину лучшей серии
        // Учитываем день в серии, если количество шагов больше или равно ежедневной цели
        int currentSeries = 0;
        int finalSeries = 0;
        for (int steps : days) {
            if (steps >= dailyStepGoal) {
                currentSeries++;
            } else {
                finalSeries = Math.max(currentSeries, finalSeries);
            }
        }
        // Учитываем случай, когда месяц заканчивается лучшей серией
        return Math.max(currentSeries, finalSeries);
    }
}
