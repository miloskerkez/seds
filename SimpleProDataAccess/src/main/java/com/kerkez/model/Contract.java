package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
public class Contract implements Serializable{

    @Id
    @GeneratedValue
    private Long contractId;

    @NotNull
    private int contractSalary;

    @NotNull
    private int contractDuration;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "playerId")
    private Player contractPlayer;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public int getContractSalary() {
        return contractSalary;
    }

    public void setContractSalary(int contractSalary) {
        this.contractSalary = contractSalary;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public Player getContractPlayer() {
        return contractPlayer;
    }

    public void setContractPlayer(Player contractPlayer) {
        this.contractPlayer = contractPlayer;
    }
}
