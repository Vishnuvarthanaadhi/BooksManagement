package com.kooku.Books.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kooku.Books.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(String name);

}
