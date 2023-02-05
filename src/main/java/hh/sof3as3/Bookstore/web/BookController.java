package hh.sof3as3.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookController {

	@RequestMapping("/index")
	public String index(){
		return "This is a page :)";
	}

}
