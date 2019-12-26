package lab4;

import java.io.Serializable;

public class Textbook implements Serializable {
	
	private static final long serialVersionUID = 2165035512772076363L;
	int isbn;
	String title;
	String author;
	
	public Textbook(int isbn, String title, String author) {
		this.isbn=isbn;
		this.title=title;
		this.author=author;
	}
	public Textbook() {
		
	}
	int getIsbn() {
		return isbn;
	}
	void setIsbn(int isbn) {
		this.isbn=isbn;
	}
	
	String getTitle() {
		return title;
	}
	
	void setTitle(String title) {
		this.title=title;
	}
	String getAuthor() {
		return author;
	}
	
	void setAuthor(String author) {
		this.author=author;
	}
	
	public String toString() {
		String s =" isbn = "+ isbn + " title = "+title+" author = "+author;
		return s;
	}
	
	public int hashCode() {
		int prime = 31;
		int result=1;
		result=result*prime+title.length();
		result=result*prime+author.length();
		result=result*prime+isbn;
		return result;
	}
	public boolean equals(Object e) {
		if(e==null)
			return false;
		if(e.getClass()!=this.getClass())
			return false;
		if(e.hashCode()!=this.hashCode())
			return false;
		Textbook t = (Textbook)e;
		if(t.isbn!=this.isbn)
			return false;
		if(t.title!=this.title)
			return false;
		if(t.author!=this.author)
			return false;
		return true;
		
	}

}
