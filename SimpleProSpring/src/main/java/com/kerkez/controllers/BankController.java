package com.kerkez.controllers;

import com.kerkez.model.Bank;
import com.kerkez.service.BankService;
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
    List<Bank> getBankss() {
        List<Bank> viewBankList = bankService.load();
        return viewBankList;
    }
}