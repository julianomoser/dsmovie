package com.moser.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moser.dsmovie.entities.User;

/**
 * @author Juliano Moser
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
