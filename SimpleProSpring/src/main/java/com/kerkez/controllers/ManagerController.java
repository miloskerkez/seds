package com.kerkez.controllers;

import com.kerkez.model.Manager;
import com.kerkez.service.ManagerService;
import com.kerkez.viewModel.ManagerViewModel;
import com.kerkez.viewModel.UpdateManagerViewModel;
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

    @RequestMapping("getManagerWithId")
    @ResponseBody
    public UpdateManagerViewModel getThisManager(@RequestBody Long id) {
        Manager manager = managerService.getOne(id);
        UpdateManagerViewModel updateManagerViewModel = new UpdateManagerViewModel();
        updateManagerViewModel.setUmvmId(manager.getManagerId());
        updateManagerViewModel.setUmvmFirstName(manager.getManagerFirstName());
        updateManagerViewModel.setUmvmLastName(manager.getManagerLastName());
        updateManagerViewModel.setUmvmMoney(manager.getManagerMoney());
        updateManagerViewModel.setUmvmNationality(manager.getManagerNationality());

        return updateManagerViewModel;
    }

    @RequestMapping("updManager")
    @ResponseBody
    public void updManagerr(@RequestBody UpdateManagerViewModel updateManagerViewModel) {
        managerService.update(updateManagerViewModel);

    }
}
