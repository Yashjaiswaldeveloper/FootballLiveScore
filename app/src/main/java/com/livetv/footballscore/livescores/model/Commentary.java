package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commentary implements Serializable {
    private List<LiveTicker> liveticker;
    private Substitutions substitutions;
    private MatchLineup teams;

    public List<LiveTicker> getLiveticker() {
        return this.liveticker;
    }

    public void setLiveticker(List<LiveTicker> list) {
        this.liveticker = list;
    }

    public Substitutions getSubstitutions() {
        return this.substitutions;
    }

    public void setSubstitutions(Substitutions substitutions2) {
        this.substitutions = substitutions2;
    }

    public MatchLineup getTeams() {
        return this.teams;
    }

    public void setTeams(MatchLineup matchLineup) {
        this.teams = matchLineup;
    }

    public String toString() {
        String str;
        String str2 = "";
        if (this.liveticker != null) {
            str = str2;
            for (int i = 0; i < this.liveticker.size(); i++) {
                str = str + this.liveticker.get(i).toString();
            }
        } else {
            str = str2;
        }
        Substitutions substitutions2 = this.substitutions;
        if (substitutions2 != null) {
            str2 = substitutions2.toString();
        }
        return "Commentary{liveticker=" + str + ", substitutions=" + str2 + '}';
    }
}
