package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDetails implements Serializable {
    private String coachLocal;
    private String coachLocalId;
    private String coachVisitor;
    private String coachVisitorId;
    private MatchCommentry commentaries;
    private String countryOfLeague;
    private String date;
    private List<MatchEvent> events;
    private String f91id;
    private String halfTime;
    private String leagueId;
    private String leagueKey;
    private String leagueName;
    private MatchLineup lineups;
    private String localTeam;
    private String localTeamId;
    private String localTeamPastMatches;
    private List<MatchSummary> localTeamPastMatchesList;
    private TeamStanding localTeamStanding;
    private String scoreLine;
    private String season;
    private Head2Head stats;
    private String status;
    private String time;
    private String venue;
    private String venueId;
    private String visitorTeam;
    private String visitorTeamId;
    private String visitorTeamPastMatches;
    private List<MatchSummary> visitorTeamPastMatchesList;
    private TeamStanding visitorTeamStanding;

    public String getId() {
        return this.f91id;
    }

    public void setId(String str) {
        this.f91id = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public List<MatchEvent> getEvents() {
        return this.events;
    }

    public void setEvents(List<MatchEvent> list) {
        this.events = list;
    }

    @JsonProperty("gs_localteamid")
    public String getLocalTeamId() {
        return this.localTeamId;
    }

    public void setLocalTeamId(String str) {
        this.localTeamId = str;
    }

    @JsonProperty("gs_visitorteamid")
    public String getVisitorTeamId() {
        return this.visitorTeamId;
    }

    public void setVisitorTeamId(String str) {
        this.visitorTeamId = str;
    }

    @JsonProperty("scoretime")
    public String getScoreLine() {
        return this.scoreLine;
    }

    public void setScoreLine(String str) {
        this.scoreLine = str;
    }

    public MatchLineup getLineups() {
        return this.lineups;
    }

    public void setLineups(MatchLineup matchLineup) {
        this.lineups = matchLineup;
    }

    @JsonProperty("localteam")
    public String getLocalTeam() {
        return this.localTeam;
    }

    public void setLocalTeam(String str) {
        this.localTeam = str;
    }

    @JsonProperty("visitorteam")
    public String getVisitorTeam() {
        return this.visitorTeam;
    }

    public void setVisitorTeam(String str) {
        this.visitorTeam = str;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String str) {
        this.venue = str;
    }

    @JsonProperty("leagueid")
    public String getLeagueId() {
        return this.leagueId;
    }

    public void setLeagueId(String str) {
        this.leagueId = str;
    }

    @JsonProperty("venueid")
    public String getVenueId() {
        return this.venueId;
    }

    public void setVenueId(String str) {
        this.venueId = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    @JsonProperty("leaguename")
    public String getLeagueName() {
        return this.leagueName;
    }

    public void setLeagueName(String str) {
        this.leagueName = str;
    }

    @JsonProperty("filegroup")
    public String getCountryOfLeague() {
        return this.countryOfLeague;
    }

    public void setCountryOfLeague(String str) {
        this.countryOfLeague = str;
    }

    public String getSeason() {
        return this.season;
    }

    public void setSeason(String str) {
        this.season = str;
    }

    public String getLeagueKey() {
        return this.leagueKey;
    }

    public void setLeagueKey(String str) {
        this.leagueKey = str;
    }

    @JsonProperty("localteamshape")
    public String getLocalTeamPastMatches() {
        return this.localTeamPastMatches;
    }

    public void setLocalTeamPastMatches(String str) {
        this.localTeamPastMatches = str;
    }

    @JsonProperty("visitorteamshape")
    public String getVisitorTeamPastMatches() {
        return this.visitorTeamPastMatches;
    }

    public void setVisitorTeamPastMatches(String str) {
        this.visitorTeamPastMatches = str;
    }

    @JsonProperty("localteamshapefixtures")
    public List<MatchSummary> getLocalTeamPastMatchesList() {
        return this.localTeamPastMatchesList;
    }

    public void setLocalTeamPastMatchesList(List<MatchSummary> list) {
        this.localTeamPastMatchesList = list;
    }

    @JsonProperty("visitorteamshapefixtures")
    public List<MatchSummary> getVisitorTeamPastMatchesList() {
        return this.visitorTeamPastMatchesList;
    }

    public void setVisitorTeamPastMatchesList(List<MatchSummary> list) {
        this.visitorTeamPastMatchesList = list;
    }

    public MatchCommentry getCommentaries() {
        return this.commentaries;
    }

    public void setCommentaries(MatchCommentry matchCommentry) {
        this.commentaries = matchCommentry;
    }

    public String getCoachLocal() {
        return this.coachLocal;
    }

    public void setCoachLocal(String str) {
        this.coachLocal = str;
    }

    public String getCoachVisitor() {
        return this.coachVisitor;
    }

    public void setCoachVisitor(String str) {
        this.coachVisitor = str;
    }

    public String getCoachLocalId() {
        return this.coachLocalId;
    }

    public void setCoachLocalId(String str) {
        this.coachLocalId = str;
    }

    public String getCoachVisitorId() {
        return this.coachVisitorId;
    }

    public void setCoachVisitorId(String str) {
        this.coachVisitorId = str;
    }

    @JsonProperty("ht")
    public String getHalfTime() {
        return this.halfTime;
    }

    public void setHalfTime(String str) {
        this.halfTime = str;
    }

    @JsonProperty("localteamStanding")
    public TeamStanding getLocalTeamStanding() {
        return this.localTeamStanding;
    }

    public void setLocalTeamStanding(TeamStanding teamStanding) {
        this.localTeamStanding = teamStanding;
    }

    @JsonProperty("visitorteamStanding")
    public TeamStanding getVisitorTeamStanding() {
        return this.visitorTeamStanding;
    }

    public void setVisitorTeamStanding(TeamStanding teamStanding) {
        this.visitorTeamStanding = teamStanding;
    }

    public Head2Head getStats() {
        return this.stats;
    }

    public void setStats(Head2Head head2Head) {
        this.stats = head2Head;
    }

    public String toString() {
        String str;
        String str2 = "";
        String str3 = str2;
        for (int i = 0; i < this.events.size(); i++) {
            str3 = str3 + this.events.get(i).toString();
        }
        String str4 = str2;
        if (this.localTeamPastMatchesList != null) {
            for (int i2 = 0; i2 < this.localTeamPastMatchesList.size(); i2++) {
                str4 = str4 + this.localTeamPastMatchesList.get(i2).toString();
            }
        }
        if (this.visitorTeamPastMatchesList != null) {
            str = str2;
            for (int i3 = 0; i3 < this.visitorTeamPastMatchesList.size(); i3++) {
                str = str + this.visitorTeamPastMatchesList.get(i3).toString();
            }
        } else {
            str = str2;
        }
        MatchLineup matchLineup = this.lineups;
        String matchLineup2 = matchLineup != null ? matchLineup.toString() : str2;
        MatchCommentry matchCommentry = this.commentaries;
        String matchCommentry2 = matchCommentry != null ? matchCommentry.toString() : str2;
        Head2Head head2Head = this.stats;
        String head2Head2 = head2Head != null ? head2Head.toString() : str2;
        TeamStanding teamStanding = this.localTeamStanding;
        String teamStanding2 = teamStanding != null ? teamStanding.toString() : str2;
        TeamStanding teamStanding3 = this.visitorTeamStanding;
        if (teamStanding3 != null) {
            str2 = teamStanding3.toString();
        }
        return "MatchDetails{status='" + this.status + '\'' + ", events=" + str3 + ", localTeamId='" + this.localTeamId + '\'' + ", visitorTeamId='" + this.visitorTeamId + '\'' + ", scoreLine='" + this.scoreLine + '\'' + ", lineups=" + matchLineup2 + ", localTeam='" + this.localTeam + '\'' + ", visitorTeam='" + this.visitorTeam + '\'' + ", venue='" + this.venue + '\'' + ", leagueId='" + this.leagueId + '\'' + ", venueId='" + this.venueId + '\'' + ", date='" + this.date + '\'' + ", time='" + this.time + '\'' + ", leagueName='" + this.leagueName + '\'' + ", countryOfLeague='" + this.countryOfLeague + '\'' + ", season='" + this.season + '\'' + ", leagueKey='" + this.leagueKey + '\'' + ", localTeamPastMatches='" + this.localTeamPastMatches + '\'' + ", visitorTeamPastMatches='" + this.visitorTeamPastMatches + '\'' + ", localTeamPastMatchesList=" + str4 + ", visitorTeamPastMatchesList=" + str + ", commentaries=" + matchCommentry2 + ", coachLocal='" + this.coachLocal + '\'' + ", coachVisitor='" + this.coachVisitor + '\'' + ", coachLocalId='" + this.coachLocalId + '\'' + ", coachVisitorId='" + this.coachVisitorId + '\'' + ", halfTime='" + this.halfTime + '\'' + ", localTeamStanding=" + teamStanding2 + ", visitorTeamStanding=" + str2 + ", head2Head=" + head2Head2 + '}';
    }
}
