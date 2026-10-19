import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
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

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public void displayBook() {
        String status = available ? "Available" : "Borrowed";
        System.out.printf("%-5d %-34s %-27s %-12s%n", id, title, author, status);
    }
}

class Library {
    private Book[] books;

    public Library() {
        books = new Book[] {
            new Book(101, "Java Basics", "Herbert Schildt"),
            new Book(102, "Object-Oriented Programming", "E. Balagurusamy"),
            new Book(103, "Data Structures", "Seymour Lipschutz"),
            new Book(104, "Computer Networks", "Andrew Tanenbaum"),
            new Book(105, "Database Fundamentals", "Elmasri and Navathe"),
            new Book(106, "Clean Code", "Robert C. Martin")
        };
    }

    public void displayBooks() {
        System.out.println("\\n====================== BOOK LIST ======================");
        System.out.printf("%-5s %-34s %-27s %-12s%n", "ID", "Title", "Author", "Status");
        System.out.println("-------------------------------------------------------------------------------");
        for (Book book : books) {
            book.displayBook();
        }
    }

    public void searchBook(Scanner sc) {
        System.out.print("Enter full title or part of title: ");
        String search = sc.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Search text cannot be empty.");
            return;
        }

        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
                if (!found) {
                    System.out.printf("%-5s %-34s %-27s %-12s%n", "ID", "Title", "Author", "Status");
                    System.out.println("-------------------------------------------------------------------------------");
                }
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No book found with that title.");
        }
    }

    public void borrowBookById(Scanner sc) {
        System.out.print("Enter book ID to borrow: ");
        int id = readInt(sc);
        if (id == Integer.MIN_VALUE) return;

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Invalid book ID. Please check the ID and try again.");
        } else if (!book.isAvailable()) {
            System.out.println("This book is already borrowed.");
        } else {
            book.borrowBook();
            System.out.println("Book borrowed successfully: " + book.getTitle());
        }
    }

    public void returnBookById(Scanner sc) {
        System.out.print("Enter book ID to return: ");
        int id = readInt(sc);
        if (id == Integer.MIN_VALUE) return;

        Book book = findBookById(id);
        if (book == null) {
            System.out.println("Invalid book ID. Please check the ID and try again.");
        } else if (book.isAvailable()) {
            System.out.println("This book is already marked as available; it cannot be returned.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully: " + book.getTitle());
        }
    }

    public void showSummary() {
        int availableCount = 0;
        int borrowedCount = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableCount++;
            } else {
                borrowedCount++;
            }
        }

        System.out.println("\\n========== LIBRARY SUMMARY ==========");
        System.out.println("Total books     : " + books.length);
        System.out.println("Available books : " + availableCount);
        System.out.println("Borrowed books  : " + borrowedCount);
        System.out.println("=====================================");
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    private int readInt(Scanner sc) {
        String input = sc.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid whole number.");
            return Integer.MIN_VALUE;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        boolean running = true;

        System.out.println("========================================");
        System.out.println("       LIBRARY MANAGEMENT SYSTEM");
        System.out.println("            JAVA TRAINING - AIMT");
        System.out.println("========================================");

        while (running) {
            System.out.println("\\n--------------- MAIN MENU ---------------");
            System.out.println("1. Display all books");
            System.out.println("2. Search book by title");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Show library summary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Enter a number from 0 to 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.searchBook(sc);
                    break;
                case 3:
                    library.borrowBookById(sc);
                    break;
                case 4:
                    library.returnBookById(sc);
                    break;
                case 5:
                    library.showSummary();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Enter a number from 0 to 5.");
            }
        }

        sc.close();
    }
}
