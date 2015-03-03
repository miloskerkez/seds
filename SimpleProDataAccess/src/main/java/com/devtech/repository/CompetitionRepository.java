package com.devtech.repository;

import com.devtech.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */

@Repository("competitionRepository")
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
