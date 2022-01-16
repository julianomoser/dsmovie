package com.moser.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moser.dsmovie.entities.Score;
import com.moser.dsmovie.entities.ScorePK;

/**
 * @author Juliano Moser
 *
 */
public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
