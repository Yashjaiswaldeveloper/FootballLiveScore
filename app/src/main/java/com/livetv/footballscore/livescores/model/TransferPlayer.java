package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferPlayer implements Serializable {
    private String age;
    private String date;
    private String f101id;
    private String f102to;
    private String from;
    private String name;
    private String position;
    private String teamid;
    private String type;

    public String getId() {
        return this.f101id;
    }

    public void setId(String str) {
        this.f101id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public String getTo() {
        return this.f102to;
    }

    public void setTo(String str) {
        this.f102to = str;
    }

    public String getTeamid() {
        return this.teamid;
    }

    public void setTeamid(String str) {
        this.teamid = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "TransferPlayer{id='" + this.f101id + '\'' + ", name='" + this.name + '\'' + ", date='" + this.date + '\'' + ", age='" + this.age + '\'' + ", position='" + this.position + '\'' + ", from='" + this.from + '\'' + ", teamid='" + this.teamid + '\'' + ", type='" + this.type + '\'' + '}';
    }
}
