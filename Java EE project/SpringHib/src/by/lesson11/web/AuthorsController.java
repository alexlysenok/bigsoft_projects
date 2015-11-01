package by.lesson11.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.lesson11.dal.BookDao;
import by.lesson11.dal.CrudDao;
import by.lesson11.entity.Author;
import by.lesson11.entity.Book;
import by.lesson11.entity.Genre;
import by.lesson11.exception.DalException;


@Controller
public class AuthorsController {

	@Autowired
	private BookDao bookDao; 
	private List<Genre> genres = new ArrayList<Genre>();
	private List<Author> authors = new ArrayList<Author>();
	private List<Book> books = new ArrayList<Book>();

	
	@RequestMapping("/authors")
	public String authorsJsp(Model model) {
		
		return "authors";
	}
	
	
	
	@ModelAttribute("authors")
	public List<Author> allAuthors(Model model) {
		
		try {
			authors = bookDao.list(Author.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(authors);
		
		return authors;
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

	@RequestMapping("/getauthorimage")
	public void imageForAuthor(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		try {
			authors = bookDao.list(Author.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Author author: authors){
			
			if(author.getId()==id){
				
				resp.setContentType("image/jpeg");
				OutputStream out=resp.getOutputStream();
				resp.setContentLength(author.getImage().length);
				out.write(author.getImage());
				
			}	
		}			
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
