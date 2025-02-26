import java.util.ArrayList;
import java.util.List;

// Интерфейс для объектов, которые можно печатать
interface Printable {
    void printInfo();
}

// Абстрактный класс для элементов библиотеки
abstract class Item implements Printable {
    private String title;
    private String author;

    public Item(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Абстрактный метод (должен быть реализован в подклассах)
    public abstract String getType();
}

// Класс для представления книги
class Book extends Item {
    private int year;

    public Book(String title, String author, int year) {
        super(title, author);
        this.year = year;
    }

    // Реализация абстрактного метода
    @Override
    public String getType() {
        return "Книга";
    }

    // Реализация метода интерфейса Printable
    @Override
    public void printInfo() {
        System.out.println("Тип: " + getType());
        System.out.println("Название: " + getTitle());
        System.out.println("Автор: " + getAuthor());
        System.out.println("Год издания: " + year);
        System.out.println("-----------------------");
    }
}

// Класс для управления библиотекой
class Library {
    private List<Item> items = new ArrayList<>();

    // Добавление элемента в библиотеку
    public void addItem(Item item) {
        items.add(item);
    }

    // Вывод информации о всех элементах
    public void printAllItems() {
        for (Item item : items) {
            item.printInfo();
        }
    }
}

// Главный класс программы
public class Shop {
    public static void main(String[] args) {
        // Создаем библиотеку
        Library library = new Library();

        // Создаем книги
        Book book1 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book2 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967);

        // Добавляем книги в библиотеку
        library.addItem(book1);
        library.addItem(book2);

        // Выводим информацию о всех книгах
        library.printAllItems();
    }
}   