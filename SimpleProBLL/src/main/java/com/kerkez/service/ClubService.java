package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.viewModel.ClubViewModel;
import com.kerkez.viewModel.UpdateClubViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface ClubService {
    Club save(Club club);
    List<ClubViewModel> load();

    void delete(Long c);

    Club getOne(Long id);

    void update(UpdateClubViewModel updateClubViewModel);
}
