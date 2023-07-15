import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class to represent a book
class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Library class to manage books and users
class Library {
    private List<Book> books;
    private List<String> members;
    private Scanner scanner;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Admin module methods

    public void addBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void modifyBook(int id, String title, String author) {
        Book book = findBookById(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            System.out.println("Book modified successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // User module methods

    public void viewBooks() {
        for (Book book : books) {
            System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void issueBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            System.out.println("Book issued: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int id) {
        Book book = findBookById(id);
        if (book != null) {
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book not found.");
        }
    }

    // Helper methods

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Main method to run the program

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(1, "Book 1", "Author 1");
        library.addBook(2, "Book 2", "Author 2");

        System.out.println("Welcome to the Library!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = library.scanner.nextInt();

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    System.out.println("Enter the book ID to issue:");
                    int issueId = library.scanner.nextInt();
                    library.issueBook(issueId);
                    break;
                case 3:
                    System.out.println("Enter the book ID to return:");
                    int returnId = library.scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Thank you for using the Library!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}