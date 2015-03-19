package com.kerkez.controllers;

import com.kerkez.model.Club;
import com.kerkez.service.ClubService;
import com.kerkez.viewModel.ClubViewModel;
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
}
