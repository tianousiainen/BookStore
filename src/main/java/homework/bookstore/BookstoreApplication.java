package homework.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookStoreRepository bookStoreRepository, CategoryRepository crepository){
		return (args) -> {

			Category category1 = new Category("Scifi");
			Category category2 = new Category("Fantasy");
			Category category3 = new Category("Historia");
			
			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			Book book1 = new Book("Maailma loppui", "Miika koski",
					2022, null ,"39349", 12.34f, category1);
			bookStoreRepository.save(book1);

			Book book2 = new Book("Taru sormusten herrasta", "J.R.R. Tolkien", 
						1954, null ,"97895", 20.45f, category2);
			bookStoreRepository.save(book2);

		for (Book book : bookStoreRepository.findAll()){
			log.info(book.toString());
		}

		for (Category category : crepository.findAll()){
			log.info(category.toString());
		}
		};
	}



}
