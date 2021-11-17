package ioc.container;

import java.util.List;

public class Book {
	private int isbn;
	private String author;
	private Title title;
	private List<Chapter> chapters;
	
	public Book(){
	}
	
	public Book(int isbn, String author, Title title, List<Chapter> chapters){
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.chapters = chapters;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

}
