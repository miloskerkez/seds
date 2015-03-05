package com.kerkez.repository;

import com.kerkez.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
