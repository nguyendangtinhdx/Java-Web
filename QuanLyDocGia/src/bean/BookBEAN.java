package bean;

public class BookBEAN {
    private String bookID;
    private String bookName;
    private String author;
    private int yearPublisher;
    private int price;
    public BookBEAN(String bookID, String bookName, String author,
            int yearPublisher, int price) {
        super();
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.yearPublisher = yearPublisher;
        this.price = price;
    }
    public String getBookID() {
        return bookID;
    }
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYearPublisher() {
        return yearPublisher;
    }
    public void setYearPublisher(int yearPublisher) {
        this.yearPublisher = yearPublisher;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
}
