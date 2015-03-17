package com.kerkez.service;

import com.kerkez.model.Player;
import com.kerkez.repository.PlayerRepository;
import com.kerkez.viewModel.PlayerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

    @Qualifier("playerRepository")
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerViewModel> load() {
        List<Player> playerList = playerRepository.findAll();
        List<PlayerViewModel> pvm = new ArrayList<PlayerViewModel>();
        for(Player p: playerList){
            pvm.add(new PlayerViewModel(p));
        }
        return pvm;
    }
}
