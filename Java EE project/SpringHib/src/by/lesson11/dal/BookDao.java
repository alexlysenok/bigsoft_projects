package by.lesson11.dal;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.lesson11.entity.Book;
import by.lesson11.exception.DalException;

public interface BookDao extends CrudDao{

	List<Book> searchCriteria(String searchString) throws DalException;

	List<Book> getBook(Long id) throws DalException;

	

	



	
}
