package com.kooku.Books.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kooku.Books.Book;
import com.kooku.Books.Dao.BooksDao;
@Service
public class BooksService {
	
	private static final Logger logger = LoggerFactory.getLogger(BooksService.class);
	
	@Autowired
	BooksDao booksDao;
	public  List<Book> getAllBooks(){
		List<Book> books = booksDao.findAll();
        
        if (!books.isEmpty()) {
            books.forEach(book -> logger.info("Book: Inside {}", book));
        } else {
            logger.info("No books found in the database.");
        }
        return books;
		}
	
	public Book getBookById(Integer id) {
        Optional<Book> book = booksDao.findById(id);

        return book.orElse(null);
    }
	
	public Book addBook(Book book) {
        return booksDao.save(book);
    }
	
	public Book updateBook(Integer id, Book bookDetails) {
        Optional<Book> existingBook = booksDao.findById(id);

        if (existingBook.isPresent()) {
            Book updatedBook = existingBook.get();
            
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setAuthor_ID(bookDetails.getAuthor_ID()); 
            updatedBook.setISBN(bookDetails.getISBN());
            updatedBook.setDescription(bookDetails.getDescription());
            updatedBook.setPublication_year(bookDetails.getPublication_year());

            
            return booksDao.save(updatedBook);
        }
        return null; 
    }
	
	public boolean deleteBook(Integer id) {
        if (booksDao.existsById(id)) {
            booksDao.deleteById(id);
            return true;
        }
        return false;
    }
	

}
