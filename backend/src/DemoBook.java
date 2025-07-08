public class DemoBook extends Book{
    public DemoBook(String ISBN, String title, int year) {
        super(ISBN, title, year, 0.0); // DemoBooks are free
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }
    @Override
    public double buy(int quantity, String email, String address) {
        throw new UnsupportedOperationException("DemoBooks cannot be purchased.");
    }

}
