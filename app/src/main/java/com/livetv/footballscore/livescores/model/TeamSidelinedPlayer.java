package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSidelinedPlayer implements Serializable {
    private String description;
    private String enddate;
    private String f99id;
    private String name;
    private String startdate;

    public String getId() {
        return this.f99id;
    }

    public void setId(String str) {
        this.f99id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String str) {
        this.startdate = str;
    }

    public String getEnddate() {
        return this.enddate;
    }

    public void setEnddate(String str) {
        this.enddate = str;
    }

    public String toString() {
        return "TeamSidelinedPlayer{id='" + this.f99id + '\'' + ", name='" + this.name + '\'' + ", description='" + this.description + '\'' + ", startdate='" + this.startdate + '\'' + ", enddate='" + this.enddate + '\'' + '}';
    }
}
