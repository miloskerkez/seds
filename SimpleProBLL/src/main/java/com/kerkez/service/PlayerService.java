package com.kerkez.service;

import com.kerkez.model.Player;
import com.kerkez.viewModel.PlayerViewModel;
import com.kerkez.viewModel.UpdatePlayerViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface PlayerService {

    List<PlayerViewModel> load();

    Player save(Player player);

    void delete(Long p);

    Player getOne(Long id);

    void update(UpdatePlayerViewModel updatePlayerViewModel);
}
