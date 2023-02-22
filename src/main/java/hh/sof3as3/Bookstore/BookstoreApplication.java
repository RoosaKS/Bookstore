package hh.sof3as3.Bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository, CategoryRepository categoryRepository) {
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
			
		};
	}
}
