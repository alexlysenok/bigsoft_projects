package by.lesson11.dal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.lesson11.entity.Book;
import by.lesson11.exception.DalException;


@Repository
@Transactional
public class BookDaoBean extends CrudDaoBean implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	 @SuppressWarnings("unchecked")
	@Override
	 @Transactional
	 public List<Book> searchCriteria(String searchString) throws DalException{
	  
		  Criteria criteria = currentSession().createCriteria(Book.class, "owner");		  
		  criteria.createAlias("owner.author", "author");
	
		  Criterion name = Restrictions.ilike("name", searchString,MatchMode.ANYWHERE);	
		  Criterion authorName = Restrictions.ilike("author.name", searchString,MatchMode.ANYWHERE);
		  Criterion authorSurname = Restrictions.ilike("author.surname", searchString,MatchMode.ANYWHERE);
		  Criterion oneWord = Restrictions.or(name, authorName, authorSurname);
		  Criterion moreWords = (Restrictions.or(Restrictions.in("name", toWords(searchString)),
				  Restrictions.in("author.name", toWords(searchString)),
				  Restrictions.in("author.surname", toWords(searchString))));
		   
		  
		  criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		  if(toWords(searchString).size() > 1) criteria.add(moreWords);
		  else criteria.add(oneWord);
	  

	 return criteria.list();
	 }
	
	 
	 
	 @Override
	 @Transactional
	 public List<Book> getBook(Long id) throws DalException {
	  Query query = currentSession().createQuery("from Book where genre_id = :genre_id");
	  query.setParameter("genre_id", id);
	  List<Book> bookList = query.list();
	  return bookList;
	 }


	 
	
	public HashSet<String> toWords(String str){
		
		String[] array=str.split(" ");
		
		HashSet<String> words = new HashSet<String>(Arrays.asList(array)); 
		
		return  words;
	}
	
	private Session currentSession() {
		Session currentSession = sessionFactory.getCurrentSession();		
		//Session currentSession = sessionFactory.openSession();
		return currentSession;
	}





}
