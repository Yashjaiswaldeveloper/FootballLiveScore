package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamLeague implements Serializable {
    private String country;
    private String key;
    private String league;
    private String position;
    private String round;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getLeague() {
        return this.league;
    }

    public void setLeague(String str) {
        this.league = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getRound() {
        return this.round;
    }

    public void setRound(String str) {
        this.round = str;
    }

    public String toString() {
        return "TeamLeague{country='" + this.country + '\'' + ", league='" + this.league + '\'' + ", key='" + this.key + '\'' + ", position='" + this.position + '\'' + ", round='" + this.round + '\'' + '}';
    }
}
