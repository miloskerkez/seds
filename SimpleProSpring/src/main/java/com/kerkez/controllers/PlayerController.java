package com.kerkez.controllers;

import com.kerkez.model.Player;
import com.kerkez.service.PlayerService;
import com.kerkez.viewModel.PlayerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milos.kerkez on 3/17/2015.
 */

@Controller
@SessionAttributes("player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "getViewPlayer", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<PlayerViewModel> getBankss() {
        List<PlayerViewModel> viewPlayerList = playerService.load();
        return viewPlayerList;
    }

    @RequestMapping("setPlayer")
    @ResponseBody
    public void doSomeThing(@RequestBody Player input) {
        playerService.save(input);
    }
}
