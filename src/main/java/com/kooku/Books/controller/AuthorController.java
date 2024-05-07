package com.kooku.Books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kooku.Books.Author;
import com.kooku.Books.service.AuthorService;
@RestController
@RequestMapping("author")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("allAuthor")
	public List<Author> getAllAuthor() {
		return  authorService.getAllAuthor();
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
		Author author = authorService.getAuthorById(id);
        return author != null ? new ResponseEntity<>(author, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		Author newAuthor = authorService.addAuthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @RequestBody Author authorDetails) {
		Author updatedAuthor = authorService.updateAuthor(id, authorDetails);
        return updatedAuthor != null ? new ResponseEntity<>(updatedAuthor, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
        boolean deleted = authorService.deleteAuthor(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
