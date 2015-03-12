package com.kerkez.viewModel;

import com.kerkez.model.Bank;

/**
 * Created by milos.kerkez on 3/12/2015.
 */
public class BankViewModel {

    private Long bankvmId;

    private String bankvmName;

    public BankViewModel(Bank bank){
        if (bank == null){
            System.out.println("Dog doesn't exist!");
        }else{
            this.bankvmId = bank.getBankId();
            this.bankvmName = bank.getBankName();
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
}
