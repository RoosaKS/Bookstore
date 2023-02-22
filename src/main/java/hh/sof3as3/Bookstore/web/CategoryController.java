package hh.sof3as3.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3as3.Bookstore.domain.Category;
import hh.sof3as3.Bookstore.domain.CategoryRepository;



@Controller

public class CategoryController {
	@Autowired 
	// Spring etsii sovelluksen käynnistyessä CategoryRepository-rajapinnan toteuttavan 
	// luokan, luo siitä olion ja asettaa sen attribuuttimuuttujaan arvoksi
	CategoryRepository categoryRepository; 
	
	// kategorioidenlistaus
		@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
		public String getCategories(Model model) {

			List<Category> categories = (List<Category>)categoryRepository.findAll(); // haetaan tietokannasta 
			model.addAttribute("categories", categories); // välitetään lista templatelle model-olion avulla

			return "categorylist"; // DispatherServlet saa tämän template-nimen ja kutsuu seuraavaksi categorylist.html-templatea,
								// joka prosessoidaan palvelimella
		}

	// tyhjän kategorialomakkeen muodostaminen
	@RequestMapping(value = "/newcategory", method = RequestMethod.GET)
	public String getNewCategoryForm(Model model) {
		model.addAttribute("category", new Category()); // "tyhjä" kategoria-olio
		return "addcategory";
	}

	// kategorialomakeella syötettyjen tietojen vastaanotto ja tallennus
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category, Model model) {
		// talletetaan uusi kategoria tietokantaan
		categoryRepository.save(category); // SQL Insert, jos id-arvo null tai 0
		
		return "redirect:/categorylist"; // uudelleenohjataan suorittamaan endpoint /categorylist (GET)
	}

	@RequestMapping(value = "/deletecategory/{categoryid}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("categoryid") Long Categoryid, Model model) {
		categoryRepository.deleteById(Categoryid);
		
		return "redirect:/categorylist";
	}

	// Edit category
	@RequestMapping(value = "/editcategory/{categoryid}")
	public String showModCategory(@PathVariable("categoryid") Long categoryid, Model model){
		model.addAttribute("category", categoryRepository.findById(categoryid));
	//	model.addAttribute("categories", categoryRepository.findAll());
		
		return "editcategory";
	}
	
	
}

