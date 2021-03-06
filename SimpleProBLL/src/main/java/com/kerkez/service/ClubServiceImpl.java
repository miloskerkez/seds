package com.kerkez.service;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.model.Player;
import com.kerkez.repository.ClubRepository;
import com.kerkez.repository.PlayerRepository;
import com.kerkez.viewModel.ClubViewModel;
import com.kerkez.viewModel.UpdateClubViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
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

    //POTREBAN FIX za brisanje za klubove koji imaju takmicenje
    @Override
    public void delete(Long c) {
        Club club = clubRepository.findOne(c);
        /*List<Competition> competitionList = club.getClubCompetition();
       for (Competition comp: competitionList){
           comp.getCompetitionClubs().remove(club);
       }*/
        Collection<Competition> competitionList = club.getCompetitions();
        for (Competition comp: competitionList){
            comp.getClubs().remove(club);
        }
        List<Player> playerList = club.getClubPlayers();
        for(Player p: playerList){
            Player player = playerRepository.findOne(p.getPlayerId());
            Club club1 = clubRepository.findOne((long) 1);
            player.setPlayerClub(club1);
            playerRepository.save(player);
        }
        clubRepository.delete(club);
    }

    @Override
    public Club getOne(Long id) {
        return clubRepository.findOne(id);
    }

    @Override
    public void update(UpdateClubViewModel updateClubViewModel) {
        Club club = clubRepository.findOne(updateClubViewModel.getUcvmId());
        club.setClubBirthYear(updateClubViewModel.getUcvmYear());
        club.setClubCity(updateClubViewModel.getUcvmCity());
        club.setClubCountry(updateClubViewModel.getUcvmCountry());
        club.setClubName(updateClubViewModel.getUcvmName());
        clubRepository.save(club);
    }
}
