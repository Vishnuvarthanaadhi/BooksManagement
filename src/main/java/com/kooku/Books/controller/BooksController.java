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

import com.kooku.Books.Book;
import com.kooku.Books.service.BooksService;

@RestController
@RequestMapping("books")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@GetMapping("allBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = booksService.getAllBooks();
		return  new ResponseEntity<>(books, HttpStatus.OK);
		
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Book book = booksService.getBookById(id);
        return book != null ? new ResponseEntity<>(book, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
	@PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book newBook = booksService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book bookDetails) {
        Book updatedBook = booksService.updateBook(id, bookDetails);
        return updatedBook != null ? new ResponseEntity<>(updatedBook, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        boolean deleted = booksService.deleteBook(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


