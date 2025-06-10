import java.util.Scanner;
public class Mainapp {

        private static final Library library = new Library();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            boolean running = true;

            while (running) {
                showMenu();
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1 -> addBook();
                        case 2 -> registerUser();
                        case 3 -> issueBook();
                        case 4 -> returnBook();
                        case 5 -> library.listBooks();
                        case 6 -> library.listUsers();
                        case 7 -> {
                            running = false;
                            System.out.println("Exiting system. Goodbye!");
                        }
                        default -> System.out.println("Invalid option. Try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }

        private static void showMenu() {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. List All Users");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
        }

        private static void addBook() {
            try {
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Title: ");
                String title = scanner.nextLine();
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                library.addBook(new Book(id, title, author));
                System.out.println("Book added successfully.");
            } catch (Exception e) {
                System.out.println("Failed to add book. Please check inputs.");
            }
        }

        private static void registerUser() {
            try {
                System.out.print("Enter User ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                library.registerUser(new User(id, name));
                System.out.println("User registered successfully.");
            } catch (Exception e) {
                System.out.println("Failed to register user. Please check inputs.");
            }
        }

        private static void issueBook() {
            try {
                System.out.print("Enter Book ID to issue: ");
                int bookId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter User ID: ");
                int userId = Integer.parseInt(scanner.nextLine());
                library.issueBook(bookId, userId);
            } catch (Exception e) {
                System.out.println("Failed to issue book.");
            }
        }

        private static void returnBook() {
            try {
                System.out.print("Enter Book ID to return: ");
                int bookId = Integer.parseInt(scanner.nextLine());
                library.returnBook(bookId);
            } catch (Exception e) {
                System.out.println("Failed to return book.");
            }
        }
    }

