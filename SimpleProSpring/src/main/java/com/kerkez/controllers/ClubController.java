package com.kerkez.controllers;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.service.ClubService;
import com.kerkez.service.CompetitionService;
import com.kerkez.viewModel.ClubCompetitionViewModel;
import com.kerkez.viewModel.ClubViewModel;
import com.kerkez.viewModel.UpdateBankViewModel;
import com.kerkez.viewModel.UpdateClubViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Controller
@SessionAttributes("club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private CompetitionService competitionService;

    @RequestMapping("setClub")
    @ResponseBody
    public void doSomeThing(@RequestBody Club input) {
        clubService.save(input);
    }

    @RequestMapping(value = "getViewClub", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<ClubViewModel> getClubss() {
        List<ClubViewModel> viewClubList = clubService.load();
        return viewClubList;
    }

    @RequestMapping("delClub")
    @ResponseBody
    public void delDog(@RequestBody Long c) {
        clubService.delete(c);
    }

    @RequestMapping("getClubWithId")
    @ResponseBody
    public UpdateClubViewModel getThisClub(@RequestBody Long id) {
        Club club = clubService.getOne(id);
        UpdateClubViewModel updateClubViewModel = new UpdateClubViewModel();
        updateClubViewModel.setUcvmCity(club.getClubCity());
        updateClubViewModel.setUcvmCountry(club.getClubCountry());
        updateClubViewModel.setUcvmName(club.getClubName());
        updateClubViewModel.setUcvmYear(club.getClubBirthYear());
        updateClubViewModel.setUcvmId(club.getClubId());
        return updateClubViewModel;
    }

    @RequestMapping("updClub")
    @ResponseBody
    public void updClubb(@RequestBody UpdateClubViewModel updateClubViewModel) {
        clubService.update(updateClubViewModel);

    }

    @RequestMapping("addClubToCompetition")
    @ResponseBody
    public void addClubToCompetition(@RequestBody ClubCompetitionViewModel clubCompetitionViewModel) {
        Competition competition = competitionService.getOne(clubCompetitionViewModel.getCoid());
        Club club = clubService.getOne(clubCompetitionViewModel.getClid());
        competition.getClubs().add(club);
        competitionService.save(competition);
    }
}
