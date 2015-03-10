package com.kerkez.service;

import com.kerkez.model.Competition;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface CompetitionService {
    Competition save(Competition competition);
    List<Competition> load();
}
