package by.lesson11.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "authors")
public class Author extends AbstractEntity implements Comparable<Author>{

	@Column
	private String name;
	
	@Column
	private String surname;
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] image;
	
	@OneToMany(mappedBy = "author", fetch=FetchType.EAGER)
	private List<Book> books;
	
	
	public Author(){}

	@Override
	public boolean entityEquals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int entityHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public int compareTo(Author obj) {
		
		
		return (int)this.surname.compareTo(obj.surname);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
