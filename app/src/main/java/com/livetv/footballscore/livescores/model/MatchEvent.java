package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchEvent implements Serializable {
    private String f92id;
    private String minute;
    private String player;
    private String playerId;
    private String result;
    private String team;
    private String type;

    public String getId() {
        return this.f92id;
    }

    public void setId(String str) {
        this.f92id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String str) {
        this.team = str;
    }

    public String getMinute() {
        return this.minute;
    }

    public void setMinute(String str) {
        this.minute = str;
    }

    public String getPlayer() {
        return this.player;
    }

    public void setPlayer(String str) {
        this.player = str;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(String str) {
        this.playerId = str;
    }

    public String toString() {
        return "MatchEvent{id='" + this.f92id + '\'' + ", type='" + this.type + '\'' + ", team='" + this.team + '\'' + ", minute='" + this.minute + '\'' + ", player='" + this.player + '\'' + ", result='" + this.result + '\'' + ", playerId='" + this.playerId + '\'' + '}';
    }
}
