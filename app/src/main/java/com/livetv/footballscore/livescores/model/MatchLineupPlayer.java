package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchLineupPlayer implements Serializable {
    private String booking;
    private String f93id;
    private String name;
    private String number;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getId() {
        return this.f93id;
    }

    public void setId(String str) {
        this.f93id = str;
    }

    public String getBooking() {
        return this.booking;
    }

    public void setBooking(String str) {
        this.booking = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String toString() {
        return "MatchLineupPlayer{name='" + this.name + '\'' + ", id='" + this.f93id + '\'' + ", booking='" + this.booking + '\'' + ", number='" + this.number + '\'' + '}';
    }
}
