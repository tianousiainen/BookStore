package homework.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import homework.bookstore.domain.Book;
import homework.bookstore.domain.BookStoreRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookStoreRepository bookStoreRepository){
		return (args) -> {
			Book book1 = new Book("Maailma loppui", "Miika koski", 2022, null ,39349L, 12.34f);
			bookStoreRepository.save(book1);

			Book book2 = new Book("Taru sormusten herrasta", "J.R. Tolkien", 2022, null ,39349L, 20.45f);
			bookStoreRepository.save(book2);
		};
	}



}
