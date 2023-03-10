package hh.sof3as3.Bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //tietokannan taulu
public class Book {
	
	@Id //pääavainsarake tietokannan taulussa 
	@GeneratedValue(strategy = GenerationType.AUTO)//autom. generoituva id-arvo uudelle kirjalle 

	private Long id;
	private String title;
	private String author;
	@Column(name="publishing_year")
	private Integer year;
	private String isbn;
	private Double price;
	
	 @ManyToOne
	 	@JsonIgnoreProperties ("books")
	    @JoinColumn(name = "categoryid")
	    private Category category;
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = 0.0;
	}

	public Book(String title, String author, Integer year, String isbn, Double price, Category category) {
		super();
		this.id = null;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;

	}

	public Book(Long id, String title, String author, Integer year, String isbn, Double price, Category category) {
		super();
		this.id = null;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYear() {
		return year;
	}

	public String getIsbn() {
		return isbn;
	}

	public Double getPrice() {
		return price;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	@Override
	public String toString() {
		if (this.category != null)
			return "id=" + id + "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price + ", category="+ this.getCategory();		
		else
			return "id=" + id + "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price;
	}
	
	
	
	
}
