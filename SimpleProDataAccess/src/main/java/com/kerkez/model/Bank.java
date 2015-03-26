package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
public class Bank implements Serializable {

    @Id
    @GeneratedValue
    private Long bankId;

    @NotNull
    private String bankName;

    @OneToMany(mappedBy = "managerBank", fetch = FetchType.EAGER)
    private List<Manager> bankManagers = new ArrayList<Manager>();

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public List<Manager> getBankManagers() {
        return bankManagers;
    }

    public void setBankManagers(List<Manager> bankManagers) {
        this.bankManagers = bankManagers;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
