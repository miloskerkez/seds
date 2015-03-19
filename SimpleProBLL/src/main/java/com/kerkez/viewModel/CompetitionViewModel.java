package com.kerkez.viewModel;

import com.kerkez.model.Competition;

/**
 * Created on 3/19/2015.
 *
 * @author milos.kerkez
 */
public class CompetitionViewModel {


    private Long competitionvmId;

    private String competitionvmName;

    private String competitionvmType;

    public CompetitionViewModel(Competition competition){
        this.competitionvmId = competition.getCompetitionId();
        this.competitionvmName = competition.getCompetitionName();
        this.competitionvmType = competition.getCompetitionType();
    }

    public Long getCompetitionvmId() {
        return competitionvmId;
    }

    public void setCompetitionvmId(Long competitionvmId) {
        this.competitionvmId = competitionvmId;
    }

    public String getCompetitionvmName() {
        return competitionvmName;
    }

    public void setCompetitionvmName(String competitionvmName) {
        this.competitionvmName = competitionvmName;
    }

    public String getCompetitionvmType() {
        return competitionvmType;
    }

    public void setCompetitionvmType(String competitionvmType) {
        this.competitionvmType = competitionvmType;
    }
}
