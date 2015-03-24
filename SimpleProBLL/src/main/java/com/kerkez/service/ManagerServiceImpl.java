package com.kerkez.service;

import com.kerkez.model.Bank;
import com.kerkez.model.Manager;
import com.kerkez.model.Player;
import com.kerkez.repository.ManagerRepository;
import com.kerkez.viewModel.ManagerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/5/2015.
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Qualifier("managerRepository")
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public List<ManagerViewModel> load() {
        List<Manager> managers = managerRepository.findAll();
        List<ManagerViewModel> managersvm = new ArrayList<ManagerViewModel>();
        for(Manager m: managers){
            managersvm.add(new ManagerViewModel(m));
        }
        return managersvm;
    }

    @Override
    public void delete(Long m) {
        Manager manager = managerRepository.findOne(m);
        Bank bank = manager.getManagerBank();
        bank.getBankManagers().remove(manager);
        List<Player> playerList = manager.getManagerPlayers();
        manager.getManagerPlayers().remove(playerList);
        managerRepository.delete(manager);
    }
}
