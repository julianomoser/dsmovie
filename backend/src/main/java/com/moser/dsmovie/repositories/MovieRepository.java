package com.moser.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moser.dsmovie.entities.Movie;

/**
 * @author Juliano Moser
 *
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
