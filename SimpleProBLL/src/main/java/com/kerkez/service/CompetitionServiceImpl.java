package com.kerkez.service;

import com.kerkez.model.Competition;
import com.kerkez.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {

    @Qualifier("competitionRepository")
    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    @Transactional
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }
}
