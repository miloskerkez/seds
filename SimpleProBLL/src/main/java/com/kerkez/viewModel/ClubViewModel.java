package com.kerkez.viewModel;

import com.kerkez.model.Club;
import com.kerkez.model.Competition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/19/2015.
 *
 * @author milos.kerkez
 */
public class ClubViewModel {

    private Long clubvmId;

    private String clubvmName;

    private int clubvmBirthYear;

    private String clubvmCountry;

    private String clubvmCity;

    private List<CompetitionViewModel> clubvmCompetition;

    private Long competitionId;

    public ClubViewModel(Club club){
        this.clubvmId = club.getClubId();
        this.clubvmName = club.getClubName();
        this.clubvmBirthYear = club.getClubBirthYear();
        this.clubvmCountry = club.getClubCountry();
        this.clubvmCity = club.getClubCity();
        clubvmCompetition = new ArrayList<CompetitionViewModel>();
        /*if (club.getClubCompetition().size() > 0) {
            for (Competition c : club.getClubCompetition()) {
                clubvmCompetition.add(new CompetitionViewModel(c));
            }
        }*/
        if (club.getCompetitions().size() > 0) {
            for (Competition c : club.getCompetitions()) {
                clubvmCompetition.add(new CompetitionViewModel(c));
            }
        }
    }

    public Long getClubvmId() {
        return clubvmId;
    }

    public void setClubvmId(Long clubvmId) {
        this.clubvmId = clubvmId;
    }

    public String getClubvmName() {
        return clubvmName;
    }

    public void setClubvmName(String clubvmName) {
        this.clubvmName = clubvmName;
    }

    public int getClubvmBirthYear() {
        return clubvmBirthYear;
    }

    public void setClubvmBirthYear(int clubvmBirthYear) {
        this.clubvmBirthYear = clubvmBirthYear;
    }

    public String getClubvmCountry() {
        return clubvmCountry;
    }

    public void setClubvmCountry(String clubvmCountry) {
        this.clubvmCountry = clubvmCountry;
    }

    public String getClubvmCity() {
        return clubvmCity;
    }

    public void setClubvmCity(String clubvmCity) {
        this.clubvmCity = clubvmCity;
    }

    public List<CompetitionViewModel> getClubvmCompetition() {
        return clubvmCompetition;
    }

    public void setClubvmCompetition(List<CompetitionViewModel> clubvmCompetition) {
        this.clubvmCompetition = clubvmCompetition;
    }

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }
}
