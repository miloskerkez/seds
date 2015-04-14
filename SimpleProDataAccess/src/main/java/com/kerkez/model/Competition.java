package com.kerkez.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
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

    @ManyToMany(mappedBy = "competitions", fetch = FetchType.EAGER)
    private Collection<Club> clubs;
    //private List<Club> competitionClubs = new ArrayList<Club>();

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

   /* public List<Club> getCompetitionClubs() {
        return competitionClubs;
    }

    public void setCompetitionClubs(List<Club> competitionClubs) {
        this.competitionClubs = competitionClubs;
    }*/

    public Collection<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Collection<Club> clubs) {
        this.clubs = clubs;
    }
}
