package com.kooku.Books.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kooku.Books.Author;


@RepositoryRestResource
public interface AuthorDao extends JpaRepository<Author, Integer>{

}
