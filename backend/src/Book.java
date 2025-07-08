public abstract class Book {
    protected String ISBN;
    protected String title;
    protected int year;
    protected double price;

    public Book(String ISBN, String title, int year, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getISBN() { return ISBN; }
    public int getYear() { return year; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }

    public abstract boolean isPurchasable();
    public abstract double buy(int quantity, String email, String address);
}