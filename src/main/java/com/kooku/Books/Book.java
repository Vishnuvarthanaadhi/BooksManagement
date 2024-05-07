package com.kooku.Books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Integer Book_ID;
	private String  title;
	private Integer Author_ID;
	private String  ISBN;
	private String  Description;
	private Integer publication_year;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getAuthor_ID() {
		return Author_ID;
	}
	public void setAuthor_ID(Integer author_ID) {
		Author_ID = author_ID;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(Integer publication_year) {
		this.publication_year = publication_year;
	}

}


