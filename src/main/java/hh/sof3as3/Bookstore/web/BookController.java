package hh.sof3as3.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof3as3.Bookstore.domain.Book;


@Controller

public class BookController {

	@GetMapping("/index")
	public String GetBookList(Model model){
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Harry Potter And The Philosopher's Stone", "J.K. Rowling", 1997, "978-0-7475-3269-9", 23.95));
		books.add(new Book("Heartstopper Volume One", "Alice Oseman", 2018, "978-1-5272-2533-6", 17.95));
		model.addAttribute("books",books);
		
		return "book-list"; //book-list.html
	}

	
	
}
