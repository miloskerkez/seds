package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
public class Club {

    @Id
    @GeneratedValue
    private Long clubId;

    @NotNull
    private String clubName;

    @NotNull
    private int clubBirthYear;

    @NotNull
    private String clubCountry;

    @NotNull
    private String clubCity;

    @OneToMany(mappedBy = "playerClub", fetch = FetchType.EAGER)
    private List<Player> clubPlayers = new ArrayList<Player>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "club_competition",
            joinColumns = {@JoinColumn(name = "cluid", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "comid", nullable = false, updatable = false)})
    private List<Competition> clubCompetition = new ArrayList<Competition>();

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getClubBirthYear() {
        return clubBirthYear;
    }

    public void setClubBirthYear(int clubBirthYear) {
        this.clubBirthYear = clubBirthYear;
    }

    public String getClubCountry() {
        return clubCountry;
    }

    public void setClubCountry(String clubCountry) {
        this.clubCountry = clubCountry;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public List<Player> getClubPlayers() {
        return clubPlayers;
    }

    public void setClubPlayers(List<Player> clubPlayers) {
        this.clubPlayers = clubPlayers;
    }

    public List<Competition> getClubCompetition() {
        return clubCompetition;
    }

    public void setClubCompetition(List<Competition> clubCompetition) {
        this.clubCompetition = clubCompetition;
    }
}
