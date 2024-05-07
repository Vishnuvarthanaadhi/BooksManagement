package com.kooku.Books.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kooku.Books.Book;

@RepositoryRestResource
public interface BooksDao extends JpaRepository<Book, Integer>{

}
