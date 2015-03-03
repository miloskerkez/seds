package com.devtech.repository;

import com.devtech.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Repository("clubRepository")
public interface ClubRepository extends JpaRepository<Club, Long> {
}
