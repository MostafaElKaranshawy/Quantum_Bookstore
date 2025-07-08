public class PaperBook extends Book{
    private int quantity;

    public PaperBook(String ISBN, String title, int year, double price, int quantity) {
        super(ISBN, title, year, price);
        this.quantity = quantity;
    }
    @Override
    public boolean isPurchasable() {
        return true;
    }
    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Not enough stock available.");
        }
        this.quantity -= quantity;
        return this.price * quantity;
    }
}
