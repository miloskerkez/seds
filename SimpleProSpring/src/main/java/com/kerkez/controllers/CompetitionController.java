package com.kerkez.controllers;

import com.kerkez.model.Competition;
import com.kerkez.service.CompetitionService;
import com.kerkez.viewModel.CompetitionViewModel;
import com.kerkez.viewModel.UpdateCompetitionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Controller
@SessionAttributes("competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

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
        return updateCompetitionViewModel;
    }

    @RequestMapping("updCompetition")
    @ResponseBody
    public void updClubb(@RequestBody UpdateCompetitionViewModel updateCompetitionViewModel) {
        competitionService.update(updateCompetitionViewModel);

    }
}
