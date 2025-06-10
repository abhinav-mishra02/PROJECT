
    import java.util.*;

    public class Library {
        private Map<Integer, Book> books = new HashMap<>();
        private Map<Integer, User> users = new HashMap<>();
        private Map<Integer, Integer> issuedBooks = new HashMap<>(); // bookId -> userId

        public void addBook(Book book) {
            books.put(book.getId(), book);
        }

        public void registerUser(User user) {
            users.put(user.getId(), user);
        }

        public void issueBook(int bookId, int userId) {
            if (!books.containsKey(bookId)) {
                System.out.println("Error: Book ID not found.");
                return;
            }

            if (!users.containsKey(userId)) {
                System.out.println("Error: User ID not found.");
                return;
            }

            Book book = books.get(bookId);
            if (book.isIssued()) {
                System.out.println("Error: Book is already issued.");
                return;
            }

            book.issueBook();
            issuedBooks.put(bookId, userId);
            System.out.println("Book issued successfully to user: " + users.get(userId).getName());
        }

        public void returnBook(int bookId) {
            if (!books.containsKey(bookId) || !issuedBooks.containsKey(bookId)) {
                System.out.println("Error: Book not issued or does not exist.");
                return;
            }

            books.get(bookId).returnBook();
            issuedBooks.remove(bookId);
            System.out.println("Book returned successfully.");
        }

        public void listBooks() {
            books.values().forEach(System.out::println);
        }

        public void listUsers() {
            users.values().forEach(System.out::println);
        }
    }


