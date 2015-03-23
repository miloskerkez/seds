package com.kerkez.controllers;

import com.kerkez.model.Contract;
import com.kerkez.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Mima on 23-Mar-15.
 */

@Controller
@SessionAttributes("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @RequestMapping("setContract")
    @ResponseBody
    public void doSomeThing(@RequestBody Contract input) {
        contractService.save(input);
    }
}
