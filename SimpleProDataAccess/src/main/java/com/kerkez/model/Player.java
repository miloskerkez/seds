package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
public class Player implements Serializable {

    @Id
    @GeneratedValue
    private Long playerId;

    @NotNull
    private String playerFirstName;

    @NotNull
    private String playerLastName;

    @NotNull
    private int playerYearOfBirth;

    @NotNull
    private String playerNationality;

    @NotNull
    private int playerPrice;

    @ManyToOne
    private Club playerClub;

    @OneToOne(mappedBy = "contractPlayer", fetch = FetchType.EAGER)
    private Contract playerContract;

    @ManyToOne
    private Manager playerManager;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public int getPlayerYearOfBirth() {
        return playerYearOfBirth;
    }

    public void setPlayerYearOfBirth(int playerYearOfBirth) {
        this.playerYearOfBirth = playerYearOfBirth;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public void setPlayerNationality(String playerNationality) {
        this.playerNationality = playerNationality;
    }

    public Club getPlayerClub() {
        return playerClub;
    }

    public void setPlayerClub(Club playerClub) {
        this.playerClub = playerClub;
    }

    public int getPlayerPrice() {
        return playerPrice;
    }

    public void setPlayerPrice(int playerPrice) {
        this.playerPrice = playerPrice;
    }

    public Contract getPlayerContract() {
        return playerContract;
    }

    public void setPlayerContract(Contract playerContract) {
        this.playerContract = playerContract;
    }

    public Manager getPlayerManager() {
        return playerManager;
    }

    public void setPlayerManager(Manager playerManager) {
        this.playerManager = playerManager;
    }
}
