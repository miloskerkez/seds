package com.devtech.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milos.kerkez on 3/3/2015.
 */
@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue
    @Column(name = "competitionid")
    private Long competitionId;

    @NotNull
    @Column(name = "competitionname")
    private String competitionName;

    @NotNull
    @Column(name = "competitiontype")
    private String competitionType;

    @ManyToMany
    @JoinTable(name = "club_competition",
            joinColumns = {@JoinColumn(name = "comid", referencedColumnName = "competitionid")},
            inverseJoinColumns = {@JoinColumn(name = "cluid", referencedColumnName = "clubid")})
    @Column(name = "competitionclubs")
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
