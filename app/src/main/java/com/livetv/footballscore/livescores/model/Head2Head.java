package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Head2Head implements Serializable {
    private String total_draws;
    private String total_localteam_scored;
    private String total_localteam_won;
    private String total_visitorteam_scored;
    private String total_visitorteam_won;

    public String getTotal_localteam_won() {
        return this.total_localteam_won;
    }

    public void setTotal_localteam_won(String str) {
        this.total_localteam_won = str;
    }

    public String getTotal_visitorteam_won() {
        return this.total_visitorteam_won;
    }

    public void setTotal_visitorteam_won(String str) {
        this.total_visitorteam_won = str;
    }

    public String getTotal_draws() {
        return this.total_draws;
    }

    public void setTotal_draws(String str) {
        this.total_draws = str;
    }

    public String getTotal_localteam_scored() {
        return this.total_localteam_scored;
    }

    public void setTotal_localteam_scored(String str) {
        this.total_localteam_scored = str;
    }

    public String getTotal_visitorteam_scored() {
        return this.total_visitorteam_scored;
    }

    public void setTotal_visitorteam_scored(String str) {
        this.total_visitorteam_scored = str;
    }

    public String toString() {
        return "Head2Head{total_localteam_won='" + this.total_localteam_won + '\'' + ", total_visitorteam_won='" + this.total_visitorteam_won + '\'' + ", total_draws='" + this.total_draws + '\'' + ", total_localteam_scored='" + this.total_localteam_scored + '\'' + ", total_visitorteam_scored='" + this.total_visitorteam_scored + '\'' + '}';
    }
}
