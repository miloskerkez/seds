package com.devtech.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue
    @Column(name = "clubid")
    private Long clubId;

    @NotNull
    @Column(name = "clubname")
    private String clubName;

    @NotNull
    @Column(name = "clubbirthyear")
    private int clubBirthYear;

    @NotNull
    @Column(name = "clubcountry")
    private String clubCountry;

    @NotNull
    @Column(name = "clubcity")
    private String clubCity;

    @OneToMany(mappedBy = "playerClub", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Column(name = "clubplayers")
    private List<Player> clubPlayers = new ArrayList<Player>();

    @ManyToMany(mappedBy = "competitionClubs")
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
