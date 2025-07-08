public class EBook extends Book{
    private String downloadLink;

    public EBook(String ISBN, String title, int year, double price, String downloadLink) {
        super(ISBN, title, year, price);
        this.downloadLink = downloadLink;
    }

    @Override
    public boolean isPurchasable() {
        return true; // EBooks are always purchasable
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if(email.isEmpty()) {
            throw new IllegalArgumentException("Email must be provided for EBook purchases.");
        }
        else {
            return this.price;
        }
    }

    public String getDownloadLink() {
        return downloadLink;
    }
}
