package hh.sof3as3.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3as3.Bookstore.domain.Book;
import hh.sof3as3.Bookstore.domain.BookRepository;


@Controller

public class BookController {

	@Autowired 
	// Spring etsii sovelluksen käynnistyessä BookRepository-rajapinnan toteuttavan 
	// luokan, luo siitä olion ja asettaa sen attribuuttimuuttujaan arvoksi
	BookRepository bookRepository; 
	
	// kirjojenlistaus
		@RequestMapping(value = "/index", method = RequestMethod.GET)
		public String getBooks(Model model) {

			List<Book> books = (List<Book>)bookRepository.findAll(); // haetaan tietokannasta 
			model.addAttribute("books", books); // välitetään kirjalista templatelle model-olion avulla

			return "book-list"; // DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi book-list.html-templatea,
								// joka prosessoidaan palvelimella
		}

	// tyhjän kirjalomakkeen muodostaminen
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
		return "bookform";
	}

	// kirjalomakeella syötettyjen tietojen vastaanotto ja tallennus
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, Model model) {
		// talletetaan uusi kirja tietokantaan
		bookRepository.save(book); // SQL Insert, jos id-arvo null tai 0
		
		return "redirect:/index"; // uudelleenohjataan suorittamaan endpoint /index (GET)
	}

	
	

	
	
}
