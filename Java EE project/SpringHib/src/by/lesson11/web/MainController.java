package by.lesson11.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.lesson11.dal.BookDao;
import by.lesson11.dal.CrudDao;
import by.lesson11.entity.Book;
import by.lesson11.entity.Genre;
import by.lesson11.entity.User;
import by.lesson11.exception.DalException;


@Controller
public class MainController {
	
	@Autowired
	private BookDao bookDao; 
	private List<Book> books = new ArrayList<Book>();
	private List<Genre> genres = new ArrayList<Genre>();

	@RequestMapping("/main")
	public String mainJSP(@CookieValue("JSESSIONID") String sessionId, Model model) {
		model.addAttribute("sessionId", sessionId);
		return "main";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
				
		return "forward:/login";
	}

	@ModelAttribute("books")
	public List<Book> allBooks() {
		
		try {
			books = bookDao.list(Book.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
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
	
	
	
	
	@ModelAttribute("currentuser")
	public String currentUser() {
		return LoginController.currentUser;
	}
	

}
