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
public class Manager implements Serializable{

    @Id
    @GeneratedValue
    private Long managerId;

    @NotNull
    private String managerFirstName;

    @NotNull
    private String managerLastName;

    @NotNull
    private String managerNationality;

    @NotNull
    private int managerMoney;

    @ManyToOne
    private Bank managerBank;

    @OneToMany(mappedBy = "playerManager", fetch = FetchType.EAGER)
    private List<Player> managerPlayers = new ArrayList<Player>();


    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getManagerNationality() {
        return managerNationality;
    }

    public void setManagerNationality(String managerNationality) {
        this.managerNationality = managerNationality;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Bank getManagerBank() {
        return managerBank;
    }

    public void setManagerBank(Bank managerBank) {
        this.managerBank = managerBank;
    }

    public int getManagerMoney() {
        return managerMoney;
    }

    public void setManagerMoney(int managerMoney) {
        this.managerMoney = managerMoney;
    }

    public List<Player> getManagerPlayers() {
        return managerPlayers;
    }

    public void setManagerPlayers(List<Player> managerPlayers) {
        this.managerPlayers = managerPlayers;
    }
}
