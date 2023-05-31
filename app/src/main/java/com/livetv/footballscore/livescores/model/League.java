package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League implements Serializable {
    private String f90hi;
    private String key;
    private String league;
    private List<MatchSummary> matches;

    public String getLeague() {
        return this.league;
    }

    public void setLeague(String str) {
        this.league = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getHi() {
        return this.f90hi;
    }

    public void setHi(String str) {
        this.f90hi = str;
    }

    public List<MatchSummary> getMatches() {
        return this.matches;
    }

    public void setMatches(List<MatchSummary> list) {
        this.matches = list;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < this.matches.size(); i++) {
            str = str + this.matches.get(i).toString();
        }
        return "League{league='" + this.league + '\'' + ", key='" + this.key + '\'' + ", hi='" + this.f90hi + '\'' + ", matches=" + str + '}';
    }
}
