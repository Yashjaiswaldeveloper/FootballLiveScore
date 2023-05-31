package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchTeamStat implements Serializable {
    private String corners;
    private String fouls;
    private String offsides;
    private String possessationTime;
    private String redCards;
    private String saves;
    private String shotsToGoal;
    private String totalShots;
    private String yellowCards;

    @JsonProperty("shotstotal")
    public String getTotalShots() {
        return this.totalShots;
    }

    public void setTotalShots(String str) {
        this.totalShots = str;
    }

    @JsonProperty("shotsgoal")
    public String getShotsToGoal() {
        return this.shotsToGoal;
    }

    public void setShotsToGoal(String str) {
        this.shotsToGoal = str;
    }

    public String getFouls() {
        return this.fouls;
    }

    public void setFouls(String str) {
        this.fouls = str;
    }

    public String getCorners() {
        return this.corners;
    }

    public void setCorners(String str) {
        this.corners = str;
    }

    public String getOffsides() {
        return this.offsides;
    }

    public void setOffsides(String str) {
        this.offsides = str;
    }

    @JsonProperty("possestiontime")
    public String getPossessationTime() {
        return this.possessationTime;
    }

    public void setPossessationTime(String str) {
        this.possessationTime = str;
    }

    @JsonProperty("yellowcards")
    public String getYellowCards() {
        return this.yellowCards;
    }

    public void setYellowCards(String str) {
        this.yellowCards = str;
    }

    @JsonProperty("redcards")
    public String getRedCards() {
        return this.redCards;
    }

    public void setRedCards(String str) {
        this.redCards = str;
    }

    public String getSaves() {
        return this.saves;
    }

    public void setSaves(String str) {
        this.saves = str;
    }
}
