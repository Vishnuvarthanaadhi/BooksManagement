package com.kooku.Books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kooku.Books.Author;
import com.kooku.Books.Dao.AuthorDao;
@Service
public class AuthorService {

	
	@Autowired
	AuthorDao authorDao;
	public  List<Author> getAllAuthor(){
		List<Author> Authors = authorDao.findAll();
        
        if (!Authors.isEmpty()) {
        } else {
        }
        return Authors;
		}
	
	public Author getAuthorById(Integer id) {
        Optional<Author> Author = authorDao.findById(id);

        return Author.orElse(null);
    }
	
	public Author addAuthor(Author author) {
        return authorDao.save(author);
    }
	
	public Author updateAuthor(Integer id, Author authorDetails) {
        Optional<Author> existingAuthor = authorDao.findById(id);

        if (existingAuthor.isPresent()) {
            Author updatedAuthor = existingAuthor.get();
            
            updatedAuthor.setName(authorDetails.getName());
            updatedAuthor.setBirth_Year(authorDetails.getBirth_Year()); 
            updatedAuthor.setBiography(authorDetails.getBiography());

            
            return authorDao.save(updatedAuthor);
        }
        return null; 
    }
	
	public boolean deleteAuthor(Integer id) {
        if (authorDao.existsById(id)) {
        	authorDao.deleteById(id);
            return true;
        }
        return false;
    }
	
}
