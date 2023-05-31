package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueAppStart implements Serializable {
    private String key;
    private String leagueName;

    public String getLeagueName() {
        return this.leagueName;
    }

    public void setLeagueName(String str) {
        this.leagueName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String toString() {
        return "LeagueAppStart{leagueName='" + this.leagueName + '\'' + ", key='" + this.key + '\'' + '}';
    }
}
