package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.repository.ClubRepository;
import com.kerkez.repository.CompetitionRepository;
import com.kerkez.viewModel.CompetitionViewModel;
import com.kerkez.viewModel.UpdateCompetitionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("competitionService")
public class CompetitionServiceImpl implements CompetitionService {

    @Qualifier("competitionRepository")
    @Autowired
    private CompetitionRepository competitionRepository;

    @Qualifier("clubRepository")
    @Autowired
    private ClubRepository clubRepository;

    @Override
    @Transactional
    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public List<CompetitionViewModel> load() {
        List<Competition> competitions = competitionRepository.findAll();
        List<CompetitionViewModel> cvm = new ArrayList<CompetitionViewModel>();
        for(Competition c:competitions){
            cvm.add(new CompetitionViewModel(c));
        }
        return cvm;
    }

    @Override
    public void delete(Long c) {
        Competition competition = competitionRepository.findOne(c);
        competitionRepository.delete(c);
    }

    @Override
    public Competition getOne(Long id) {
        return competitionRepository.findOne(id);
    }

    @Override
    public void update(UpdateCompetitionViewModel updateCompetitionViewModel) {
        Competition competition = competitionRepository.findOne(updateCompetitionViewModel.getUcvmId());
        competition.setCompetitionName(updateCompetitionViewModel.getUcvmName());
        competitionRepository.save(competition);
    }
}
