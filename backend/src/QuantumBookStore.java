import java.time.LocalDate;
import java.util.*;

class QuantumBookStore {
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
        System.out.println("Quantum book store: Added book " + book.getTitle());
    }

    public Book removeBook(String ISBN) {
        return inventory.remove(ISBN);
    }

    public List<Book> removeOutdatedBooks(int yearsOld) {
        int currentYear = LocalDate.now().getYear();
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            if (currentYear - book.getYear() > yearsOld) {
                removed.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book " + book.getTitle());
            }
        }
        return removed;
    }

    public void buyBook(String ISBN, int quantity, String email, String address) {
        Book book = inventory.get(ISBN);
        if (book == null) {
            throw new IllegalArgumentException("Quantum book store: Book not found: " + ISBN);
        }
        if (!book.isPurchasable()) {
            throw new IllegalArgumentException("Quantum book store: Book is not purchasable: " + ISBN);
        }
        double price = book.buy(quantity, email, address);

        try {
            if (book instanceof EBook) {
                MailService.sendEmail(email, book); // pseudo-call
            } else if (book instanceof PaperBook) {
                ShippingService.shipBook(book, quantity, price, address); // pseudo-call
            }
            System.out.println("Quantum book store: Purchased " + quantity + " copies of '" +
                    book.getTitle() + "' for " + price);
        }
        catch (Exception e) {
            System.err.println("Quantum book store: Error processing purchase: " + e.getMessage());
            throw new RuntimeException("Quantum book store: Purchase failed for " + book.getTitle(), e);
        }
    }
}