package com.kerkez.service;

import com.kerkez.model.Club;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface ClubService {
    Club save(Club club);
    List<Club> load();

}
