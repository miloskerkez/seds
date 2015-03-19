package com.kerkez.service;

import com.kerkez.model.Player;
import com.kerkez.viewModel.PlayerViewModel;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
public interface PlayerService {

    List<PlayerViewModel> load();

    Player save(Player player);
}
