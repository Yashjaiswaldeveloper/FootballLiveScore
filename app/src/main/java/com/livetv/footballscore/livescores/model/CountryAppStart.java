package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryAppStart implements Serializable {
    private String country;
    private List<LeagueAppStart> leagues;

    public List<LeagueAppStart> getLeagues() {
        return this.leagues;
    }

    public void setLeagues(List<LeagueAppStart> list) {
        this.leagues = list;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }
}
