package hh.sof3as3.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class CategoryRepositoryTest {

	
	@Autowired
    private CategoryRepository repository;
	
	@Test  // testataan BookRepositoryn findById()-metodin toimivuutta
    public void findByNameShouldReturnCategoryId() {
        List<Category> categories = repository.findByName("Fiction");
        
        assertThat(categories.get(0).getCategoryid()).isEqualTo(3);
    }
    
    @Test // testataan CategoryRepositoryn save()-metodin toimivuutta
    public void createNewCategory() {
    	Category category = new Category("Horror");
    	repository.save(category); // SQL Insert
    	assertThat(category.getCategoryid()).isNotNull();
    }    
    
    @Test // testataan CategoryRepositoryn deleteById()-metodin toimivuutta
    public void deleteCategory() {
    	repository.deleteById((long)1); 
    	
  
    } 
}
