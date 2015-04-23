package com.kerkez.controllers;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.service.ClubService;
import com.kerkez.service.CompetitionService;
import com.kerkez.viewModel.ClubCompetitionViewModel;
import com.kerkez.viewModel.ClubViewModel;
import com.kerkez.viewModel.CompetitionViewModel;
import com.kerkez.viewModel.UpdateCompetitionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Controller
@SessionAttributes("competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private ClubService clubService;

    @RequestMapping("setCompetition")
    @ResponseBody
    public void doSomeThing(@RequestBody Competition input) {
        competitionService.save(input);
    }

    @RequestMapping(value = "getViewCompetitions", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<CompetitionViewModel> getCompetition() {
        List<CompetitionViewModel> viewCompetitionList = competitionService.load();
        return viewCompetitionList;
    }

    @RequestMapping("delCompetition")
    @ResponseBody
    public void delCompetitionn(@RequestBody Long c) {
        competitionService.delete(c);
    }

    @RequestMapping("getCompetitionWithId")
    @ResponseBody
    public UpdateCompetitionViewModel getThisCompetition(@RequestBody Long id) {
        Competition competition = competitionService.getOne(id);
        UpdateCompetitionViewModel updateCompetitionViewModel = new UpdateCompetitionViewModel();
        updateCompetitionViewModel.setUcvmId(competition.getCompetitionId());
        updateCompetitionViewModel.setUcvmName(competition.getCompetitionName());
        updateCompetitionViewModel.setUcvmType(competition.getCompetitionType());
        return updateCompetitionViewModel;
    }

    @RequestMapping("updCompetition")
    @ResponseBody
    public void updClubb(@RequestBody UpdateCompetitionViewModel updateCompetitionViewModel) {
        competitionService.update(updateCompetitionViewModel);

    }

    @RequestMapping("getCompetitionsClubs")
    @ResponseBody
    public List<ClubViewModel> getCompetitionsClubs(@RequestBody Long id) {
        Competition competition = competitionService.getOne(id);
        List<ClubViewModel> clubViewModelsList = new ArrayList<ClubViewModel>();
        for(Club club: competition.getClubs()){
            clubViewModelsList.add(new ClubViewModel(club));
        }
        for(ClubViewModel cvm: clubViewModelsList){
            cvm.setCompetitionId(id);
        }
        return clubViewModelsList;
    }

    @RequestMapping("removeClub")
    @ResponseBody
    public List<ClubViewModel> remClub(@RequestBody ClubCompetitionViewModel clubCompetitionViewModel) {
        Club club = clubService.getOne(clubCompetitionViewModel.getClid());
        Competition competition = competitionService.getOne(clubCompetitionViewModel.getCoid());
        Collection<Competition> competitions = club.getCompetitions();
        Collection<Competition> competitions2 = new ArrayList<Competition>();
        for (Competition c : competitions) {
            if (c.getCompetitionId().equals(competition.getCompetitionId())) {
            } else {
                competitions2.add(c);
            }
        }
        club.setCompetitions(competitions2);
        clubService.save(club);

        Collection<Club> clubs = competition.getClubs();
        Collection<Club> clubs2 = new ArrayList<Club>();
        for (Club cl : clubs) {
            if (cl.getClubId().equals(club.getClubId())) {
            } else {
                clubs2.add(cl);
            }
        }
        competition.setClubs(clubs2);
        competitionService.save(competition);

        List<ClubViewModel> clubViewModelsList = new ArrayList<ClubViewModel>();
        for (Club clubb : competition.getClubs()) {
            clubViewModelsList.add(new ClubViewModel(clubb));
        }
        for (ClubViewModel cvm : clubViewModelsList) {
            cvm.setCompetitionId(clubCompetitionViewModel.getCoid());
        }
        return clubViewModelsList;
    }

}
