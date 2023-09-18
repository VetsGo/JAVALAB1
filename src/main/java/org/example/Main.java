package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Виберіть число для взаємодії з бібліотекою:");
        System.out.println("1. Додати книгу");
        System.out.println("2. Показати усі книги");
        System.out.println("3. Знайти книгу за назвою");
        System.out.println("4. Видалити книгу за номером ISBN");
        System.out.println("5. Вийти з програми");
        while (true) {
            System.out.print("Введіть число: ");

            int num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1:
                    System.out.print("Введіть назву: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть автора: ");
                    String author = scanner.nextLine();
                    System.out.print("Введіть номером ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Введіть рік видання: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    System.out.println("Книжку додано.");
                    break;
                case 2:
                    if (library.isEmpty()) {
                        System.out.println("Бібліотека порожня.");
                    } else {
                        System.out.println("Усі книжки в бібліотеці:");
                        library.displayBooks();
                    }
                    break;
                case 3:
                    System.out.print("Введіть назву книжки для пошуку: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Книжку не знайдено.");
                    }
                    break;
                case 4:
                    System.out.print("Введіть номер ISBN для видалення книжки: ");
                    String isbnToRemove = scanner.nextLine();
                    boolean removed = library.removeBookByISBN(isbnToRemove);
                    if (removed) {
                        System.out.println("Книжку видалено.");
                    } else {
                        System.out.println("Книжку за номером ISBN не знайдено.");
                    }
                    break;
                case 5:
                    System.out.println("Завершено програму.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ви можете ввести лише значення від 1 до 5.");
            }
        }
    }
}