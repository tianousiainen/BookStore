package homework.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    private String _title;
    private String _author;
    private int _publicationYear;
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _isbn;
    private float _price;


    public Book(String title, String author, int publicationYear, Long id,
                String isbn, float price) {
        _title = title;
        _author = author;
        _publicationYear = publicationYear;
        _id = id;
        _isbn = isbn;
        _price = price;
    }

    public Book(){
        _title = null;
        _author = null;
        _publicationYear = 0;
        _id = null;
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

    public void setId(Long id) {
        _id = id;
    }

    public void setIsbn(String isbn) {
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

    public Long getId() {
        return _id;
    }

    public String getIsbn() {
        return _isbn;
    }

    public float getPrice() {
        return _price;
    }

    @Override
    public String toString() {
        return "Book [_title=" + _title + ", _author=" + _author + 
            ", _publicationYear=" + _publicationYear + ", _id="
                + _id + ", _isbn=" + _isbn + ", _price=" + _price + "]";
    }

}
