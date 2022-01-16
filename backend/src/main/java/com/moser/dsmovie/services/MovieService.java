package com.moser.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moser.dsmovie.dto.MovieDTO;
import com.moser.dsmovie.entities.Movie;
import com.moser.dsmovie.repositories.MovieRepository;

/**
 * @author Juliano Moser
 *
 */
@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> pageMovies = movieRepository.findAll(pageable);
		Page<MovieDTO> page = pageMovies.map(MovieDTO::new);
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie movie = movieRepository.findById(id).get();
		MovieDTO movieDto = new MovieDTO(movie); 
		return movieDto;
	}
}
