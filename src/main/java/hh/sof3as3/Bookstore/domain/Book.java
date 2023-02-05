package hh.sof3as3.Bookstore.domain;

public class Book {

	private String title;
	private String author;
	private Integer year;
	private String isbn;
	private Double price;
	
	
	
	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.year = null;
		this.isbn = null;
		this.price = 0.0;
	}

	public Book(String title, String author, Integer year, String isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
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

	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price;
	}
	
	
	
	
}
