package hh.sof3as3.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	
	// peritään findAll(), findById(), save(), deleteById()
	
    List<Book> findByTitle(String title);


}

