package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryLeague implements Serializable {
    private String country;
    private List<League> leagues;

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public List<League> getLeagues() {
        return this.leagues;
    }

    public void setLeagues(List<League> list) {
        this.leagues = list;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.leagues.size(); i++) {
            str = str + this.leagues.get(i).toString();
        }
        return "CountryLeague{country='" + this.country + '\'' + ", leagues=" + str + '}';
    }
}
