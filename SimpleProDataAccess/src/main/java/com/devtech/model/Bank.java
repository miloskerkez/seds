package com.devtech.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
@Table(name="bank")
public class Bank implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "bankid")
    private Long bankId;

    @OneToMany(mappedBy = "managerBank", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Column(name = "bankmanagers")
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
}
