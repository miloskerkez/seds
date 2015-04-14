package com.kerkez.controllers;

import com.kerkez.model.Manager;
import com.kerkez.model.Player;
import com.kerkez.service.ManagerService;
import com.kerkez.service.PlayerService;
import com.kerkez.viewModel.BuyViewModel;
import com.kerkez.viewModel.MessageViewModel;
import com.kerkez.viewModel.PlayerViewModel;
import com.kerkez.viewModel.UpdatePlayerViewModel;
import jdk.nashorn.internal.objects.NativeJSON;
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

    @Autowired
    private ManagerService managerService;

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

    @RequestMapping("delPlayer")
    @ResponseBody
    public void delPlayer(@RequestBody Long p) {
        playerService.delete(p);
    }

    @RequestMapping("getPlayerWithId")
    @ResponseBody
    public UpdatePlayerViewModel getThisPlayer(@RequestBody Long id) {
        Player player = playerService.getOne(id);
        UpdatePlayerViewModel updatePlayerViewModel = new UpdatePlayerViewModel();
        updatePlayerViewModel.setUpvmId(player.getPlayerId());
        updatePlayerViewModel.setUpvmFirstName(player.getPlayerFirstName());
        updatePlayerViewModel.setUpvmLastName(player.getPlayerLastName());
        updatePlayerViewModel.setUpvmNationality(player.getPlayerNationality());
        updatePlayerViewModel.setUpvmPrice(player.getPlayerPrice());
        updatePlayerViewModel.setUpvmYear(player.getPlayerYearOfBirth());
        return updatePlayerViewModel;
    }

    @RequestMapping("updPlayer")
    @ResponseBody
    public void updPlayerr(@RequestBody UpdatePlayerViewModel updatePlayerViewModel) {
        playerService.update(updatePlayerViewModel);

    }

    @RequestMapping("ExchangePlayer")
    @ResponseBody
    public MessageViewModel buyPlayer(@RequestBody BuyViewModel buyViewModel) {
        MessageViewModel mvm = new MessageViewModel();
        Player player = playerService.getOne(buyViewModel.getPid());
        Manager manager = managerService.getOne(buyViewModel.getMid());
        if(player.getPlayerManager().getManagerId() == manager.getManagerId()){
            mvm.setMessageBuy("Igrac je vec u vlasnistvu menadzera");
        }else if(manager.getManagerMoney() < player.getPlayerPrice()){
            mvm.setMessageBuy("Nemate dovoljno para da kupite ovog igraca");
        }else{
            Manager manager1 = player.getPlayerManager();
            manager1.setManagerMoney(manager1.getManagerMoney()+player.getPlayerPrice());
            managerService.save(manager1);
            manager.setManagerMoney(manager.getManagerMoney()-player.getPlayerPrice());
            managerService.save(manager);
            player.setPlayerManager(manager);
            playerService.save(player);

            mvm.setMessageBuy("Uspesno ste kupili igraca");
        }
       return mvm;

    }
}
