package com.kerkez.viewModel;

import com.kerkez.model.Manager;

/**
 * Created by milos.kerkez on 3/17/2015.
 */
public class ManagerViewModel {

    private Long managervmId;

    private String managervmLastName;

    private String managervmFirstName;

    private String managervmNationality;

    private int managervmMoney;

    private String managervmBankName;

    public ManagerViewModel(Manager manager){
        this.managervmId = manager.getManagerId();
        this.managervmLastName = manager.getManagerLastName();
        this.managervmFirstName = manager.getManagerFirstName();
        this.managervmMoney = manager.getManagerMoney();
        this.managervmNationality = manager.getManagerNationality();
        this.managervmBankName = manager.getManagerBank().getBankName();
    }

    public Long getManagervmId() {
        return managervmId;
    }

    public void setManagervmId(Long managervmId) {
        this.managervmId = managervmId;
    }

    public String getManagervmLastName() {
        return managervmLastName;
    }

    public void setManagervmLastName(String managervmLastName) {
        this.managervmLastName = managervmLastName;
    }

    public String getManagervmFirstName() {
        return managervmFirstName;
    }

    public void setManagervmFirstName(String managervmFirstName) {
        this.managervmFirstName = managervmFirstName;
    }

    public String getManagervmNationality() {
        return managervmNationality;
    }

    public void setManagervmNationality(String managervmNationality) {
        this.managervmNationality = managervmNationality;
    }

    public int getManagervmMoney() {
        return managervmMoney;
    }

    public void setManagervmMoney(int managervmMoney) {
        this.managervmMoney = managervmMoney;
    }

    public String getManagervmBankName() {
        return managervmBankName;
    }

    public void setManagervmBankName(String managervmBankName) {
        this.managervmBankName = managervmBankName;
    }
}
