package com.kerkez.controllers;

import com.kerkez.model.Club;
import com.kerkez.service.ClubService;
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
@SessionAttributes("club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @RequestMapping("setClub")
    @ResponseBody
    public void doSomeThing(@RequestBody Club input) {
        clubService.save(input);
    }
}
