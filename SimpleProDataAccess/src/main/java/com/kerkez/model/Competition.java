package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
public class Competition {

    @Id
    @GeneratedValue
    private Long competitionId;

    @NotNull
    private String competitionName;

    @NotNull
    private String competitionType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "club_competition",
            joinColumns = {@JoinColumn(name = "comid", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "cluid", nullable = false, updatable = false)})
    private List<Club> competitionClubs = new ArrayList<Club>();

    public Long getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Long competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }

    public List<Club> getCompetitionClubs() {
        return competitionClubs;
    }

    public void setCompetitionClubs(List<Club> competitionClubs) {
        this.competitionClubs = competitionClubs;
    }
}
