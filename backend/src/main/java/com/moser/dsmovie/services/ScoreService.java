package com.moser.dsmovie.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moser.dsmovie.dto.MovieDTO;
import com.moser.dsmovie.dto.ScoreDTO;
import com.moser.dsmovie.entities.Movie;
import com.moser.dsmovie.entities.Score;
import com.moser.dsmovie.entities.User;
import com.moser.dsmovie.repositories.MovieRepository;
import com.moser.dsmovie.repositories.ScoreRepository;
import com.moser.dsmovie.repositories.UserRepository;

/**
 * @author Juliano Moser
 *
 */
@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		movie.setSocore(movie.getScores().stream().collect(Collectors.averagingDouble(Score::getValue)));
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
