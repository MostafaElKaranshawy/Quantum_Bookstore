public class MailService {
    public static void sendEmail(String email, Book book) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        System.out.println("MailService: Sending email to " + email +
                " about the purchase of '" + book.getTitle() + "' (ISBN: " + book.getISBN() + ")");
    }
}
