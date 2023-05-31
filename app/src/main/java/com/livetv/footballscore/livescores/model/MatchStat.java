package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchStat implements Serializable {
    private MatchTeamStat localTeamStat;
    private MatchTeamStat visitorTeamStat;

    @JsonProperty("localteam")
    public MatchTeamStat getLocalTeamStat() {
        return this.localTeamStat;
    }

    public void setLocalTeamStat(MatchTeamStat matchTeamStat) {
        this.localTeamStat = matchTeamStat;
    }

    @JsonProperty("visitorteam")
    public MatchTeamStat getVisitorTeamStat() {
        return this.visitorTeamStat;
    }

    public void setVisitorTeamStat(MatchTeamStat matchTeamStat) {
        this.visitorTeamStat = matchTeamStat;
    }

    public String toString() {
        return "MatchStat{localTeamStat=" + this.localTeamStat.toString() + ", visitorTeamStat=" + this.visitorTeamStat.toString() + '}';
    }
}
