package com.kerkez.repository;

import com.kerkez.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */

@Repository("competitionRepository")
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
