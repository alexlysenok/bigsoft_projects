package by.lesson11.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "books")
public class Book extends AbstractEntity implements Comparable<Book> {

	@Column
	private String name;
	
	@Column
	private String info;
	
	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	@Cascade({ CascadeType.SAVE_UPDATE })
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "genre_id", referencedColumnName = "id")
	@Cascade({ CascadeType.SAVE_UPDATE })
	private Genre genre;
	
	
	@ManyToMany
	@JoinTable(name = "USER_BOOK", joinColumns = { @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "ID") })
	@Cascade({ CascadeType.SAVE_UPDATE })
	private List<User> users;

	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] image;
	
	@Lob
	@Column(columnDefinition="longblob")
	private byte[] content;
	
	
	public Book(){}
	
	
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


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public byte[] getContent() {
		return content;
	}


	public void setContent(byte[] content) {
		this.content = content;
	}


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
