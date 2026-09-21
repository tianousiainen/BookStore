package homework.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import homework.bookstore.domain.Book;
import homework.bookstore.domain.BookStoreRepository;
import homework.bookstore.domain.Category;
import homework.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookStoreRepository bookStoreRepository, CategoryRepository crepository){
		return (args) -> {

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Fantasy");
			crepository.save(category1);
			crepository.save(category2);

			Book book1 = new Book("Maailma loppui", "Miika koski",
					2022, null ,"39349", 12.34f, category1);
			bookStoreRepository.save(book1);

			Book book2 = new Book("Taru sormusten herrasta", "J.R.R. Tolkien", 
						1954, null ,"97895", 20.45f, category2);
			bookStoreRepository.save(book2);
		};
	}



}
