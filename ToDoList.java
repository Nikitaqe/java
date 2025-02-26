import java.util.ArrayList;
import java.util.Scanner;

// Класс для представления задачи
class Task {
    private String description;
    private boolean isCompleted;

    // Конструктор
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Геттеры и сеттеры
    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "[V]" : "[ ]";
        return status + " " + description;
    }
}

// Главный класс программы
public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Вывод меню
    private static void printMenu() {
        System.out.println("--- Меню ---");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Просмотреть задачи");
        System.out.println("3. Отметить задачу как выполненную");
        System.out.println("4. Удалить задачу");
        System.out.println("5. Выйти");
        System.out.print("Выберите действие: " + (char)240);
    }

    // Добавление задачи
    private static void addTask() {
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Задача добавлена!");
    }

    // Просмотр всех задач
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            System.out.println("\n--- Список задач ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Отметка задачи как выполненной
    private static void markTaskAsCompleted() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Введите номер задачи для отметки как выполненной: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                Task task = tasks.get(taskNumber - 1);
                task.setCompleted(true);
                System.out.println("Задача '" + task.getDescription() + "' отмечена как выполненная.");
            } else {
                System.out.println("Неверный номер задачи.");
            }
        }
    }

    // Удаление задачи
    private static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Введите номер задачи для удаления: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                Task removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Задача '" + removedTask.getDescription() + "' удалена.");
            } else {
                System.out.println("Неверный номер задачи.");
            }
        }
    }
}