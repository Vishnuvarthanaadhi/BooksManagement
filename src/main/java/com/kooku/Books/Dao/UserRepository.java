package com.kooku.Books.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kooku.Books.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
