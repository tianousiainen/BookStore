package homework.bookstore.domain;

public class Book {
    public Book(String title, String author, int publicationYear,
                Long isbn, float price) {
        _title = title;
        _author = author;
        _publicationYear = publicationYear;
        _isbn = isbn;
        _price = price;
    }

    public Book(){
        _title = null;
        _author = null;
        _publicationYear = 0;
        _isbn = null;
        _price = 0;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public void setPublicationYear(int publicationYear) {
        _publicationYear = publicationYear;
    }

    public void setIsbn(Long isbn) {
        _isbn = isbn;
    }

    public void setPrice(float price) {
        _price = price;
    }    

    public String getTitle() {
        return _title;
    }

    public String getAuthor() {
        return _author;
    }

    public int getPublicationYear() {
        return _publicationYear;
    }

    public Long getIsbn() {
        return _isbn;
    }

    public float getPrice() {
        return _price;
    }

    @Override
    public String toString() {
        return "Book [_title=" + _title + ", _author=" + _author + 
            ", _publicationYear=" + _publicationYear + ", _isbn="
                + _isbn + ", _price=" + _price + "]";
    }

    private String _title;
    private String _author;
    private int _publicationYear;
    private Long _isbn;
    private float _price;
}
