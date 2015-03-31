package com.kerkez.service;

import com.kerkez.model.Player;
import com.kerkez.repository.ContractRepository;
import com.kerkez.repository.PlayerRepository;
import com.kerkez.viewModel.PlayerViewModel;
import com.kerkez.viewModel.UpdatePlayerViewModel;
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

    @Qualifier("contractRepository")
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<PlayerViewModel> load() {
        List<Player> playerList = playerRepository.findAll();
        List<PlayerViewModel> pvm = new ArrayList<PlayerViewModel>();
        for(Player p: playerList){
            pvm.add(new PlayerViewModel(p));
        }
        return pvm;
    }

    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void delete(Long p) {
        Player player = playerRepository.findOne(p);
        contractRepository.delete(player.getPlayerContract());
        playerRepository.delete(p);
    }

    @Override
    public Player getOne(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public void update(UpdatePlayerViewModel updatePlayerViewModel) {
        Player player = playerRepository.findOne(updatePlayerViewModel.getUpvmId());
        player.setPlayerFirstName(updatePlayerViewModel.getUpvmFirstName());
        player.setPlayerLastName(updatePlayerViewModel.getUpvmLastName());
        player.setPlayerNationality(updatePlayerViewModel.getUpvmNationality());
        player.setPlayerPrice(updatePlayerViewModel.getUpvmPrice());
        player.setPlayerYearOfBirth(updatePlayerViewModel.getUpvmYear());
        playerRepository.save(player);
    }
}
