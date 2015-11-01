package by.lesson11.web;


import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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
import by.lesson11.entity.Book;
import by.lesson11.entity.Genre;
import by.lesson11.exception.DalException;


@Controller
public class BooksController {
	
	@Autowired
	private BookDao bookDao; 
	private List<Book> books = new ArrayList<Book>();
	private List<Genre> genres = new ArrayList<Genre>();
	
	

	@RequestMapping("/books")
	public String booksJsp(Model model) {
		return "books";
	}
	
	@RequestMapping("/getimage")
	public void imageForBook(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		try {
			books = bookDao.list(Book.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book: books){
			
			if(book.getId()==id){
				
				resp.setContentType("image/jpeg");
				OutputStream out=resp.getOutputStream();
				resp.setContentLength(book.getImage().length);
				out.write(book.getImage());
				
			}	
		}			
	}
		
	
	
		
	@RequestMapping("/readpdf")
	public void readPDF(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		try {
			books = bookDao.list(Book.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book: books){
			
			if(book.getId()==id){
				
				resp.setContentType("application/pdf");
				OutputStream out=resp.getOutputStream();
				resp.setContentLength(book.getContent().length);
				out.write(book.getContent());
				
			}	
		}		
	}
	
	@RequestMapping("/downloadpdf")
	public void downloadPDF(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		try {
			books = bookDao.list(Book.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book: books){
			
			if(book.getId()==id){
				
				resp.setContentType("application/pdf");
				OutputStream out=resp.getOutputStream();
				resp.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(book.getName(),"UTF-8")+".pdf");
				out.write(book.getContent());
				
			}	
		}		
	}
	
	
	 
	
	
	
	@RequestMapping("/deletepdf")
	public String deletePDF(@RequestParam("index") Long id, HttpServletResponse resp) throws IOException{
		try {
			books = bookDao.list(Book.class);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Book book: books){
			
			if(book.getId()==id){
				
				
				try {
					bookDao.delete(Book.class,id);
				} catch (DalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
		}		
		return "forward:/books";
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
	


	
}
