package com.kerkez.controllers;

import com.kerkez.model.Competition;
import com.kerkez.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
