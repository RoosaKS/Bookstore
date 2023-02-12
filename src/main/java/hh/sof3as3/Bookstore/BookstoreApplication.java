package hh.sof3as3.Bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository bookRepository) {
		return (arg) -> {
			Book book1 = new Book("Harry Potter And The Philosopher's Stone", "J.K. Rowling", 1997, "978-0-7475-3269-9", 23.95);
			Book book2 = new Book("Heartstopper Volume One", "Alice Oseman", 2018, "978-1-5272-2533-6", 17.95);
			bookRepository.save(book1); // SQL Insert
			bookRepository.save(book2); // SQL Insert
			
			// haetaan tietokannasta kirjat
			List<Book> books = (List<Book>)bookRepository.findAll();
			for (Book book : books) {
				System.out.println(book.toString());
			}
			
		};
	}
}
