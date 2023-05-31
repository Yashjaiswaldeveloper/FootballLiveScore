package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStanding implements Serializable {
    private String description;
    private String goalDifference;
    private String points;
    private String position;
    private String team;
    private String teamId;
    private String totalDraw;
    private String totalGoalsAgainst;
    private String totalGoalsFor;
    private String totalLost;
    private String totalPlayed;
    private String totalWon;

    @JsonProperty("id_gs")
    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String str) {
        this.team = str;
    }

    @JsonProperty("matchPoints")
    public String getTotalPlayed() {
        return this.totalPlayed;
    }

    public void setTotalPlayed(String str) {
        this.totalPlayed = str;
    }

    public String getTotalWon() {
        return this.totalWon;
    }

    public void setTotalWon(String str) {
        this.totalWon = str;
    }

    public String getTotalDraw() {
        return this.totalDraw;
    }

    public void setTotalDraw(String str) {
        this.totalDraw = str;
    }

    public String getTotalLost() {
        return this.totalLost;
    }

    public void setTotalLost(String str) {
        this.totalLost = str;
    }

    public String getTotalGoalsFor() {
        return this.totalGoalsFor;
    }

    public void setTotalGoalsFor(String str) {
        this.totalGoalsFor = str;
    }

    public String getTotalGoalsAgainst() {
        return this.totalGoalsAgainst;
    }

    public void setTotalGoalsAgainst(String str) {
        this.totalGoalsAgainst = str;
    }

    public String getGoalDifference() {
        return this.goalDifference;
    }

    public void setGoalDifference(String str) {
        this.goalDifference = str;
    }

    public String getPoints() {
        return this.points;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String toString() {
        return "TeamStanding{teamId='" + this.teamId + '\'' + ", position='" + this.position + '\'' + ", team='" + this.team + '\'' + ", totalPlayed='" + this.totalPlayed + '\'' + ", totalWon='" + this.totalWon + '\'' + ", totalDraw='" + this.totalDraw + '\'' + ", totalLost='" + this.totalLost + '\'' + ", totalGoalsFor='" + this.totalGoalsFor + '\'' + ", totalGoalsAgainst='" + this.totalGoalsAgainst + '\'' + ", goalDifference='" + this.goalDifference + '\'' + ", points='" + this.points + '\'' + ", description='" + this.description + '\'' + '}';
    }
}
