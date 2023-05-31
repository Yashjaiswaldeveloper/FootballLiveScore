package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic implements Serializable {
    private String appearences;
    private String goals;
    private String league;
    private String leagueId;
    private String lineups;
    private String minutes;
    private String name;
    private String redCards;
    private String season;
    private String substituteIn;
    private String substituteOut;
    private String substitutesOnBench;
    private String teamId;
    private String yellowCards;
    private String yellowRed;

    public String getName() {
        return this.name;
    }

    @JsonProperty("teamid")
    public String getTeamId() {
        return this.teamId;
    }

    public String getLeague() {
        return this.league;
    }

    @JsonProperty("leagueid")
    public String getLeagueId() {
        return this.leagueId;
    }

    public String getSeason() {
        return this.season;
    }

    public String getMinutes() {
        return this.minutes;
    }

    public String getAppearences() {
        return this.appearences;
    }

    public String getLineups() {
        return this.lineups;
    }

    @JsonProperty("substitute_in")
    public String getSubstituteIn() {
        return this.substituteIn;
    }

    @JsonProperty("substitute_out")
    public String getSubstituteOut() {
        return this.substituteOut;
    }

    @JsonProperty("substitutes_on_bench")
    public String getSubstitutesOnBench() {
        return this.substitutesOnBench;
    }

    public String getGoals() {
        return this.goals;
    }

    @JsonProperty("yellowcards")
    public String getYellowCards() {
        return this.yellowCards;
    }

    @JsonProperty("yellowred")
    public String getYellowRed() {
        return this.yellowRed;
    }

    @JsonProperty("redcards")
    public String getRedCards() {
        return this.redCards;
    }

    public String toString() {
        return "Statistic{name='" + this.name + '\'' + ", teamId='" + this.teamId + '\'' + ", league='" + this.league + '\'' + ", leagueId='" + this.leagueId + '\'' + ", season='" + this.season + '\'' + ", minutes='" + this.minutes + '\'' + ", appearences='" + this.appearences + '\'' + ", lineups='" + this.lineups + '\'' + ", substituteIn='" + this.substituteIn + '\'' + ", substituteOut='" + this.substituteOut + '\'' + ", substitutesOnBench='" + this.substitutesOnBench + '\'' + ", goals='" + this.goals + '\'' + ", yellowCards='" + this.yellowCards + '\'' + ", yellowRed='" + this.yellowRed + '\'' + ", redCards='" + this.redCards + '\'' + '}';
    }
}
