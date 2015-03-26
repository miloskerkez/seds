package com.kerkez.controllers;

import com.kerkez.model.Bank;
import com.kerkez.service.BankService;
import com.kerkez.viewModel.BankViewModel;
import com.kerkez.viewModel.ManagerViewModel;
import com.kerkez.viewModel.UpdateBankViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Controller
@SessionAttributes("bank")
public class BankController {

    @Autowired
    private BankService bankService;


    @RequestMapping("setBank")
    @ResponseBody
    public void doSomeThing(@RequestBody Bank input) {
        bankService.save(input);
    }

    @RequestMapping(value = "getViewBank", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<BankViewModel> getBankss() {
        List<BankViewModel> viewBankList = bankService.load();
        return viewBankList;
    }

    @RequestMapping("delBank")
    @ResponseBody
    public void delDog(@RequestBody Long d) {
        bankService.delete(d);
    }

    @RequestMapping("getBankWithId")
    @ResponseBody
    public UpdateBankViewModel getThisBank(@RequestBody Long id) {
        Bank bank = bankService.getOne(id);
        UpdateBankViewModel updateBankViewModel = new UpdateBankViewModel();
        updateBankViewModel.setUbvmId(bank.getBankId());
        updateBankViewModel.setUbvmName(bank.getBankName());
       /* BankViewModel bvm = new BankViewModel(bank);
        List<ManagerViewModel> mvm = bvm.getBankvmManagers();
        bvm.getBankvmManagers().removeAll(mvm);*/
        return updateBankViewModel;
    }

    @RequestMapping("updBank")
    @ResponseBody
    public void updBankk(@RequestBody UpdateBankViewModel updateBankViewModel) {
        bankService.update(updateBankViewModel);

    }
}
