package com.kerkez.controllers;

import com.kerkez.model.Manager;
import com.kerkez.service.ManagerService;
import com.kerkez.viewModel.ManagerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by milos.kerkez on 3/12/2015.
 */
@Controller
@SessionAttributes("manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("setManager")
    @ResponseBody
    public void doSomeThing(@RequestBody Manager input) {
        managerService.save(input);
    }

    @RequestMapping(value = "getViewManager", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<ManagerViewModel> getMangerss() {
        List<ManagerViewModel> viewManagerList = managerService.load();
        return viewManagerList;
    }

    @RequestMapping("delManager")
    @ResponseBody
    public void delDog(@RequestBody Long m) {
        managerService.delete(m);
    }
}
