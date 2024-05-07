package com.kooku.Books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Integer Id;
	private String  Name;
	private String  Birth_Year;
	private String  biography;
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the birth_Year
	 */
	public String getBirth_Year() {
		return Birth_Year;
	}
	/**
	 * @param birth_Year the birth_Year to set
	 */
	public void setBirth_Year(String birth_Year) {
		Birth_Year = birth_Year;
	}
	/**
	 * @return the biography
	 */
	public String getBiography() {
		return biography;
	}
	/**
	 * @param biography the biography to set
	 */
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
}
