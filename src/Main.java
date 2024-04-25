import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в счётчик калорий!");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            System.out.print("Выберите одну из команд: ");
            int actionNumber = scanner.nextInt();

            switch (actionNumber) {
                // Ввод количества шагов за определённый день
                case 1:
                    setStepsForDay(scanner, stepTracker);
                    break;
                // Изменение ежедневной цели
                case 2:
                    setDailyStepGoal(scanner, stepTracker);
                    break;
                // Вывод статистики за месяц
                case 3:
                    printStatisticsForMonth(scanner, stepTracker);
                    break;
                // Завершение работы
                case 0:
                    System.out.println("\nЗавершение работы...");
                    return;
                // Обработка неизвестной команды
                default:
                    System.out.println("\nКоманда не найдена!");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Статистика за определённый месяц");
        System.out.println("0. Завершить работу");
    }

    public static void printError() {
        System.out.println("\nОшибка! Проверьте вводимые данные.");
    }

    public static void setStepsForDay(Scanner scanner, StepTracker stepTracker) {
        System.out.print("\nВведите номер месяца (1 - 12): ");
        int month = scanner.nextInt();

        System.out.print("Введите номер дня (1 - 30): ");
        int day = scanner.nextInt();

        System.out.print("Введите количество шагов: ");
        int steps = scanner.nextInt();

        if (month >= 1 && month <= 12 && day >= 1 && day <= 30 && steps > 0) {
            stepTracker.setStepsForDay(steps, month, day);
            System.out.println("\nКоличество шагов успешно записано!");
        } else {
            printError();
        }
    }

    public static void setDailyStepGoal(Scanner scanner, StepTracker stepTracker) {
        System.out.print("\nВведите новую цель: ");
        int steps = scanner.nextInt();

        if (steps > 0) {
            stepTracker.setDailyStepGoal(steps);
            System.out.println("\nЦель успешна изменена!");
        } else {
            printError();
        }
    }

    public static void printStatisticsForMonth(Scanner scanner, StepTracker stepTracker) {
        System.out.print("\nВведите номер месяца: ");
        int month = scanner.nextInt();

        if (month >= 1 && month <= 12) {
            stepTracker.printStatisticsForMonth(month);
        } else {
            printError();
        }
    }
}
