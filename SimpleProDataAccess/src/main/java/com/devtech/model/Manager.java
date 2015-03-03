package com.devtech.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
@Table(name = "manager")
public class Manager implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "managerid")
    private Long managerId;

    @NotNull
    @Column(name = "managerfirstname")
    private String managerFirstName;

    @NotNull
    @Column(name = "managerlastname")
    private String managerLastName;

    @NotNull
    @Column(name = "managernationality")
    private String managerNationality;

    @NotNull
    @Column(name = "managermoney")
    private int managerMoney;

    @ManyToOne
    private Bank managerBank;

    @OneToMany(mappedBy = "playerManager", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Column(name = "managerplayers")
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
