public class ShippingService {
    public static void shipBook(Book book, int quantity, double price, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        System.out.println("ShippingService: Shipping " + quantity + " copies of '" +
                book.getTitle() + "' to " + address);
    }
}
