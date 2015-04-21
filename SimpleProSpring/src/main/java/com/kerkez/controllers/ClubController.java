package com.kerkez.controllers;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;
import com.kerkez.service.ClubService;
import com.kerkez.service.CompetitionService;
import com.kerkez.viewModel.*;
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
    public MessageViewModel addClubToCompetition(@RequestBody ClubCompetitionViewModel clubCompetitionViewModel) {
        MessageViewModel message = new MessageViewModel();
        message.setMessageBuy("break");
        Boolean exist = false;
        Competition competition = competitionService.getOne(clubCompetitionViewModel.getCoid());
        Club club = clubService.getOne(clubCompetitionViewModel.getClid());
        Collection<Competition> competitions = club.getCompetitions();
        for(Competition c: competitions) {
            if (c.getCompetitionId() == competition.getCompetitionId()) {
                message.setMessageBuy("This club is already in that competition");
                exist = true;
                return message;
            }
        }
         if (!exist) {
             competitions.add(competition);
             club.setCompetitions(competitions);
             clubService.save(club);
             message.setMessageBuy("Club added");
             return message;
         }
        return message;
    }

    @RequestMapping("remainClubs")
    @ResponseBody
    public List<ClubViewModel> remainClubss(@RequestBody Long id) {
        List<ClubViewModel> clubList = clubService.load();
        List<ClubViewModel> clubViewModelList = new ArrayList<ClubViewModel>();
        Boolean exist= false;
        for(ClubViewModel cvm: clubList){
            List<CompetitionViewModel> competitionViewModelList = cvm.getClubvmCompetition();
            exist = false;
            for (CompetitionViewModel covm: competitionViewModelList){
                if(covm.getCompetitionvmId()==id){
                    exist=true;
                    break;
                }
            }
            if(!exist){
                clubViewModelList.add(cvm);
            }
        }
        return clubViewModelList;
    }
}
