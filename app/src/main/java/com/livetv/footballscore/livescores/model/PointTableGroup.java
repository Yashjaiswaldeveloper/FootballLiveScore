package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointTableGroup implements Serializable {
    private String country;
    private String group;
    private String league;
    private String leaugeid;
    private String round;
    private String season;
    private String stageid;
    private List<TeamStanding> teams;

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public String getRound() {
        return this.round;
    }

    public void setRound(String str) {
        this.round = str;
    }

    public String getStageid() {
        return this.stageid;
    }

    public void setStageid(String str) {
        this.stageid = str;
    }

    public String getLeaugeid() {
        return this.leaugeid;
    }

    public void setLeaugeid(String str) {
        this.leaugeid = str;
    }

    public String getSeason() {
        return this.season;
    }

    public void setSeason(String str) {
        this.season = str;
    }

    public String getLeague() {
        return this.league;
    }

    public void setLeague(String str) {
        this.league = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public List<TeamStanding> getTeams() {
        return this.teams;
    }

    public void setTeams(List<TeamStanding> list) {
        this.teams = list;
    }
}
