package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Test  // testataan BookRepositoryn findById()-metodin toimivuutta
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Harry Potter And The Philosopher's Stone");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K. Rowling");
    }
    
    @Test // testataan BookRepositoryn save()-metodin toimivuutta
    public void createNewBook() {
    	Book book = new Book("Alice in Borderland, Vol. 1", "Haro Aso", 2022 , "978-1974728374", 15.99, categoryRepository.findByName("Comic").get(0));
    	bookRepository.save(book); // SQL Insert
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test // testataan BookRepositoryn deleteById()-metodin toimivuutta
    public void deleteBook() {
    	bookRepository.deleteById((long)1); 
    	
  
    }   
}
