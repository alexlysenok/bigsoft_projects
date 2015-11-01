package by.lesson11.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.multipart.MultipartFile;

import by.lesson11.dal.BookDao;
import by.lesson11.entity.Author;
import by.lesson11.entity.Book;
import by.lesson11.entity.Genre;
import by.lesson11.entity.User;
import by.lesson11.exception.DalException;


@Controller
public class UploadController {

	@Autowired
	private BookDao bookDao;
	private List<Genre> genres = new ArrayList<Genre>();
	private List<Author> authors = new ArrayList<Author>();
	
	@RequestMapping("/upload")
	public String uploadJsp(Model model) {
		return "upload";
	}
	
  
	
	
	
	@RequestMapping(value="/uploadpdf", method = RequestMethod.POST)
	public String newBook(HttpServletRequest req, HttpServletResponse resp, Model model, @ModelAttribute("uploadForm") FileUploadForm uploadForm) throws IOException {

	
	
		String name=req.getParameter("name");
	    String genre=req.getParameter("genre");
	    
		System.out.println(genre);
		
		
	    
		List<MultipartFile> files=null;
		MultipartFile file=null;
		byte[] content=new byte[1024*1024*10];
		byte[] image=new byte[1024*1024*10];
		
		files=uploadForm.getFiles();
		file=files.get(0);		
		content=file.getBytes();	
		System.out.println(content.length);		
		file=files.get(1);
		image=file.getBytes();
		System.out.println(image.length);
		
		Book book=new Book();
		book.setName(name);
		
		book.setImage(image);
		book.setContent(content);
		book.setGenre(getCurrentGenre(genre));
		
		
		
		try {
			bookDao.save(book);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "forward:/books";
	}
	
	
	
	public Genre getCurrentGenre(String myGenre){
		
		
		
		try {
			genres = bookDao.list(Genre.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		int index=0;
		
		for(int i=0; i<genres.size();i++){
			if(genres.get(i).getName().equals(myGenre)){
				index=i;
				break;
			}
		}
		
		
		
		return genres.get(index);
	}
	

	
	
	@ModelAttribute("book")
	public Book populateBook() {
		return new Book();
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
