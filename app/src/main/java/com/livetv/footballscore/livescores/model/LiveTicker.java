package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveTicker implements Serializable {
    private String comment;
    private String important;
    private String isgoal;
    private String minute;

    public String getImportant() {
        return this.important;
    }

    public void setImportant(String str) {
        this.important = str;
    }

    public String getIsgoal() {
        return this.isgoal;
    }

    public void setIsgoal(String str) {
        this.isgoal = str;
    }

    public String getMinute() {
        return this.minute;
    }

    public void setMinute(String str) {
        this.minute = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String toString() {
        return "LiveTicker{important='" + this.important + '\'' + ", isgoal='" + this.isgoal + '\'' + ", minute='" + this.minute + '\'' + ", comment='" + this.comment + '\'' + '}';
    }
}
