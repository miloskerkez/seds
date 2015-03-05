package com.kerkez.controllers;

import com.kerkez.model.Bank;
import com.kerkez.service.BankService;
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
@SessionAttributes("bank")
public class BankController {

    @Autowired
    private BankService bankService;


    @RequestMapping("setBank")
    @ResponseBody
    public void doSomeThing(@RequestBody Bank input) {
        bankService.save(input);
    }
}
