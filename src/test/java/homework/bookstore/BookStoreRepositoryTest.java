package homework.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import homework.bookstore.domain.Book;
import homework.bookstore.domain.BookStoreRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@DataJpaTest
public class BookStoreRepositoryTest {
    @Autowired
    private BookStoreRepository bRepository;

    private Book testBook;

    @BeforeEach
    public void setUp(){
        testBook = bRepository.save(
            new Book("Test book", "Test author", 2024,
                           null, "12344", 9.99f, null));
        
    }

    @Test
    public void createNewBook(){
        Book book = new Book("Test book", "Test author", 2024,
                           null, "12344", 9.99f, null);
        
        bRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void findBookById(){
        Optional<Book> found = bRepository.findById(testBook.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getTitle()).isEqualTo("Test book");

    }

    @Test
    public void deleteBook(){
        bRepository.deleteById(testBook.getId());

        assertThat(bRepository.findById(testBook.getId())).isEmpty();
    }


}
