package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.repository.ClubRepository;
import com.kerkez.viewModel.ClubViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


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

    @Override
    public List<ClubViewModel> load() {
        List<Club> clubs= clubRepository.findAll();
        List<ClubViewModel> cvm = new ArrayList<ClubViewModel>();
        if (clubs != null) {
            for (Club c : clubs) {
                cvm.add(new ClubViewModel(c));
            }
        }
        return cvm;
    }
}
