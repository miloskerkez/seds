package com.kerkez.viewModel;

import com.kerkez.model.Player;

/**
 * Created by milos.kerkez on 3/17/2015.
 */
public class PlayerViewModel {

    private Long playervmId;

    private String playervmFirstName;
    
    private String playervmLastName;

    private String playervmNationality;

    private int playervmPrice;

    private int playervmYear;

    private String playervmClub;

    private String playervmManager;

    public PlayerViewModel(Player player){
        this.playervmId = player.getPlayerId();
        this.playervmFirstName = player.getPlayerFirstName();
        this.playervmLastName = player.getPlayerLastName();
        this.playervmNationality = player.getPlayerNationality();
        this.playervmPrice = player.getPlayerPrice();
        this.playervmYear = player.getPlayerYearOfBirth();
        this.playervmClub = player.getPlayerClub().getClubName();
        this.playervmManager = player.getPlayerManager().getManagerLastName();
    }

    public Long getPlayervmId() {
        return playervmId;
    }

    public void setPlayervmId(Long playervmId) {
        this.playervmId = playervmId;
    }

    public String getPlayervmFirstName() {
        return playervmFirstName;
    }

    public void setPlayervmFirstName(String playervmFirstName) {
        this.playervmFirstName = playervmFirstName;
    }

    public String getPlayervmLastName() {
        return playervmLastName;
    }

    public void setPlayervmLastName(String playervmLastName) {
        this.playervmLastName = playervmLastName;
    }

    public String getPlayervmNationality() {
        return playervmNationality;
    }

    public void setPlayervmNationality(String playervmNationality) {
        this.playervmNationality = playervmNationality;
    }

    public int getPlayervmPrice() {
        return playervmPrice;
    }

    public void setPlayervmPrice(int playervmPrice) {
        this.playervmPrice = playervmPrice;
    }

    public int getPlayervmYear() {
        return playervmYear;
    }

    public void setPlayervmYear(int playervmYear) {
        this.playervmYear = playervmYear;
    }

    public String getPlayervmClub() {
        return playervmClub;
    }

    public void setPlayervmClub(String playervmClub) {
        this.playervmClub = playervmClub;
    }

    public String getPlayervmManager() {
        return playervmManager;
    }

    public void setPlayervmManager(String playervmManager) {
        this.playervmManager = playervmManager;
    }
}
