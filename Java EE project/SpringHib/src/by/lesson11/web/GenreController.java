package by.lesson11.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.lesson11.dal.BookDao;
import by.lesson11.entity.Book;
import by.lesson11.entity.Genre;
import by.lesson11.exception.DalException;


@Controller
public class GenreController {


	@Autowired
	private BookDao bookDao; 
	
	private List<Genre> genres = new ArrayList<Genre>();
	private Long currentID;
	
	@RequestMapping("/genre")
	public String genreJsp(Model model) {
		return "genre";
	}
	
	
	@RequestMapping("/opengenre")
	public String openGenre(Model model, @RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		
		currentID=id;
		
		try {
			
			model.addAttribute("booklist", bookDao.getBook(id));
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "genres";
	}
	
	
	
	@ModelAttribute("genres")
	public List<Genre> allGenres() {
		
		try {
			genres = bookDao.list(Genre.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return genres;
	}
	
	
	
}
