package homework.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import homework.bookstore.domain.AppUser;
import homework.bookstore.domain.AppUserRepository;
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
	public CommandLineRunner demo(BookStoreRepository bookStoreRepository, 
		CategoryRepository crepository, AppUserRepository appUserRepository){
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

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			AppUser user1 = new AppUser("Tia", "$2a$10$VQbZ2S.V8qgZKLx7E0d5VOfw040Dhy2COBTArfUqyzRi3.cUMcmxC",
				"tia@muikumai.com", "USER");

			AppUser user2 = new AppUser("Anna", "$2a$10$haQ0V7PkOu8Nk7slpN7Eoe7LneUNfSnhvOnntaqDT7B4zmn0ONaHG",
				"anna@miukumai.com", "ADMIN");

			appUserRepository.save(user1);
			appUserRepository.save(user2);

		};
	}



}
