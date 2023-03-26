package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.web.BookController;
import hh.sof3as3.Bookstore.web.CategoryController;
import hh.sof3as3.Bookstore.web.UserController;

@ExtendWith(SpringExtension.class)   // JUnit5 
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private UserController userController;
	

	
	@Test
	public void bookContextLoads() {
		assertThat(bookController).isNotNull();

	}
	
	@Test
	public void categoryContextLoads() {
		assertThat(categoryController).isNotNull();

	}
	
	@Test
	public void userContextLoads() {
		assertThat(userController).isNotNull();

	}

}
