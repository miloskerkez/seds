package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.model.Player;
import com.kerkez.repository.ClubRepository;
import com.kerkez.repository.PlayerRepository;
import com.kerkez.viewModel.ClubViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service("clubService")
public class ClubServiceImpl implements ClubService {

    @Qualifier("clubRepository")
    @Autowired
    private ClubRepository clubRepository;

    @Qualifier("playerRepository")
    @Autowired
    private PlayerRepository playerRepository;

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

    //POTREBAN FIX
    @Override
    public void delete(Long c) {
        Club club = clubRepository.findOne(c);
        List<Competition> competitionList = club.getClubCompetition();
       for (Competition comp: competitionList){
           comp.getCompetitionClubs().remove(club);
       }
        List<Player> playerList = club.getClubPlayers();
        for(Player p: playerList){
            Player player = playerRepository.findOne(p.getPlayerId());
            Club club1 = clubRepository.findOne((long) 11);
            player.setPlayerClub(club1);
            playerRepository.save(player);
        }
        clubRepository.delete(club);
    }
}
