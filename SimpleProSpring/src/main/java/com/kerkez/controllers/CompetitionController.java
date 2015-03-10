package com.kerkez.controllers;

import com.kerkez.model.Competition;
import com.kerkez.service.CompetitionService;
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
    List<Competition> getCompetition() {
        List<Competition> viewCompetitionList = competitionService.load();
        return viewCompetitionList;
    }
}
