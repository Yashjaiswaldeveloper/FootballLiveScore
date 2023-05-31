package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchSubstitutionPlayer implements Serializable, Comparable<MatchSubstitutionPlayer> {
    private String f94on;
    private String minute;
    private String off;
    private String off_id;
    private String on_id;

    public String getOff() {
        return this.off;
    }

    public void setOff(String str) {
        this.off = str;
    }

    public String getOn() {
        return this.f94on;
    }

    public void setOn(String str) {
        this.f94on = str;
    }

    public String getOn_id() {
        return this.on_id;
    }

    public void setOn_id(String str) {
        this.on_id = str;
    }

    public String getOff_id() {
        return this.off_id;
    }

    public void setOff_id(String str) {
        this.off_id = str;
    }

    public String getMinute() {
        return this.minute;
    }

    public void setMinute(String str) {
        this.minute = str;
    }

    public String toString() {
        return "MatchSubstitutionPlayer{off='" + this.off + '\'' + ", on='" + this.f94on + '\'' + ", on_id='" + this.on_id + '\'' + ", off_id='" + this.off_id + '\'' + ", minute='" + this.minute + '\'' + '}';
    }

    public int compareTo(MatchSubstitutionPlayer matchSubstitutionPlayer) {
        if (Integer.parseInt(this.minute) > Integer.parseInt(matchSubstitutionPlayer.getMinute())) {
            return 1;
        }
        return Integer.parseInt(this.minute) < Integer.parseInt(matchSubstitutionPlayer.getMinute()) ? -1 : 0;
    }
}
