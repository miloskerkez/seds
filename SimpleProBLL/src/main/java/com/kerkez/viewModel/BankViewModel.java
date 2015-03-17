package com.kerkez.viewModel;

import com.kerkez.model.Bank;
import com.kerkez.model.Manager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/12/2015.
 */
public class BankViewModel {

    private Long bankvmId;

    private String bankvmName;

    private List<ManagerViewModel> bankvmManagers;

    public BankViewModel(Bank bank) {
        if (bank == null) {
            System.out.println("Dog doesn't exist!");
        } else {
            this.bankvmId = bank.getBankId();
            this.bankvmName = bank.getBankName();
            /*for(Manager m : bank.getBankManagers()){
               ManagerViewModel mvm = new ManagerViewModel(m);
               // bankvmManagers.add(mvm);
            }*/
            if (bank.getBankManagers() != null) {
                List<ManagerViewModel> bvm = new ArrayList<ManagerViewModel>();
                for (Manager d : bank.getBankManagers()) {
                    bvm.add(new ManagerViewModel(d));
                }
                this.bankvmManagers = bvm;
            }
        }
    }

    public Long getBankvmId() {
        return bankvmId;
    }

    public void setBankvmId(Long bankvmId) {
        this.bankvmId = bankvmId;
    }

    public String getBankvmName() {
        return bankvmName;
    }

    public void setBankvmName(String bankvmName) {
        this.bankvmName = bankvmName;
    }

    public List<ManagerViewModel> getBankvmManagers() {
        return bankvmManagers;
    }

    public void setBankvmManagers(List<ManagerViewModel> bankvmManagers) {
        this.bankvmManagers = bankvmManagers;
    }
}
