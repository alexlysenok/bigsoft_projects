package by.lesson11.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.lesson11.dal.BookDao;
import by.lesson11.entity.Genre;
import by.lesson11.exception.DalException;


@Controller
public class SidebarController {
	

	@Autowired
	private BookDao bookDao; 
	
	private List<Genre> genres = new ArrayList<Genre>();

	
	@RequestMapping("/sidebar")
	public String genreJsp(Model model) {
		return "sidebar";
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
