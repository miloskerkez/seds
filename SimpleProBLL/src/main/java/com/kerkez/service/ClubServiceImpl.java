package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("clubService")
public class ClubServiceImpl implements ClubService {

    @Qualifier("clubRepository")
    @Autowired
    private ClubRepository clubRepository;

    @Override
    @Transactional
    public Club save(Club club) {
        return clubRepository.save(club);
    }
}
