package hh.sof3as3.Bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;
import hh.sof3as3.Bookstore.domain.User;
import hh.sof3as3.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			Category category1 = new Category("Scifi");
			categoryRepository.save(category1);
			Category category2 = new Category("Comic");
			categoryRepository.save(category2);
			Category category3 = new Category("Fiction");
			categoryRepository.save(category3);
			
			
			Book book1 = new Book("Harry Potter And The Philosopher's Stone", "J.K. Rowling", 1997, "978-0-7475-3269-9", 23.95, category3);
			Book book2 = new Book("Heartstopper Volume One", "Alice Oseman", 2018, "978-1-5272-2533-6", 17.95, category3);
			bookRepository.save(book1); // SQL Insert
			bookRepository.save(book2); // SQL Insert
			
			// haetaan tietokannasta kirjat
			List<Book> books = (List<Book>)bookRepository.findAll();
			for (Book book : books) {
				System.out.println(book.toString());
			}
				
			List<Category> categories = (List<Category>)categoryRepository.findAll();
			for (Category category : categories) {
				System.out.println(category.toString());
			}
			
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@bookstore.com", "ADMIN");
			User user3 = new User("pekka","$2a$10$PK5krnLfQfQ7LZx5sQoXMemQwJ7D91itbfPodTcGOa9vrKlXCnQeO", "pekka@pekka.com" ,"USER");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
						
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
