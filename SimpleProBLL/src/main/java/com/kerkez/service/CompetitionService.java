package com.kerkez.service;

import com.kerkez.model.Competition;
import com.kerkez.viewModel.CompetitionViewModel;
import com.kerkez.viewModel.UpdateCompetitionViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface CompetitionService {
    Competition save(Competition competition);
    List<CompetitionViewModel> load();

    void delete(Long c);

    Competition getOne(Long id);

    void update(UpdateCompetitionViewModel updateCompetitionViewModel);
}
