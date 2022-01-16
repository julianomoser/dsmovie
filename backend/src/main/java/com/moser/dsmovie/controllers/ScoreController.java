package com.moser.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moser.dsmovie.dto.MovieDTO;
import com.moser.dsmovie.dto.ScoreDTO;
import com.moser.dsmovie.services.ScoreService;

/**
 * @author Juliano Moser
 *
 */
@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO scoreDto) {
		return scoreService.saveScore(scoreDto);
	}
}
