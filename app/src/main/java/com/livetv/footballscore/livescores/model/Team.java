package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team implements Serializable {
    private String coach;
    private String coachId;
    private String country;
    private String f98id;
    private List<MatchSummary> fixtures;
    private String founded;
    private String lastUpdated;
    private List<TeamLeague> leagues;
    private String shape;
    private List<String> shapeFixtures;
    private List<TeamSidelinedPlayer> sidelined;
    private List<TeamSquadPlayer> squad;
    private String teamName;
    private Transfers transfers;
    private String venue;
    private String venueAddress;
    private String venueCapacity;
    private String venueCity;
    private String venueId;
    private String venueSurface;

    @JsonProperty("id_gs")
    public String getId() {
        return this.f98id;
    }

    public void setId(String str) {
        this.f98id = str;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }

    @JsonProperty("teamname")
    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String str) {
        this.teamName = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getVenue() {
        return this.venue;
    }

    public void setVenue(String str) {
        this.venue = str;
    }

    @JsonProperty("venueid")
    public String getVenueId() {
        return this.venueId;
    }

    public void setVenueId(String str) {
        this.venueId = str;
    }

    @JsonProperty("venuesurface")
    public String getVenueSurface() {
        return this.venueSurface;
    }

    public void setVenueSurface(String str) {
        this.venueSurface = str;
    }

    @JsonProperty("venuecapacity")
    public String getVenueCapacity() {
        return this.venueCapacity;
    }

    public void setVenueCapacity(String str) {
        this.venueCapacity = str;
    }

    @JsonProperty("venueaddress")
    public String getVenueAddress() {
        return this.venueAddress;
    }

    public void setVenueAddress(String str) {
        this.venueAddress = str;
    }

    public String getFounded() {
        return this.founded;
    }

    public void setFounded(String str) {
        this.founded = str;
    }

    public String getCoach() {
        return this.coach;
    }

    public void setCoach(String str) {
        this.coach = str;
    }

    @JsonProperty("coachid")
    public String getCoachId() {
        return this.coachId;
    }

    public void setCoachId(String str) {
        this.coachId = str;
    }

    public List<TeamSquadPlayer> getSquad() {
        return this.squad;
    }

    public void setSquad(List<TeamSquadPlayer> list) {
        this.squad = list;
    }

    public Transfers getTransfers() {
        return this.transfers;
    }

    public void setTransfers(Transfers transfers2) {
        this.transfers = transfers2;
    }

    @JsonProperty("venuecity")
    public String getVenueCity() {
        return this.venueCity;
    }

    public void setVenueCity(String str) {
        this.venueCity = str;
    }

    public List<TeamSidelinedPlayer> getSidelined() {
        return this.sidelined;
    }

    public void setSidelined(List<TeamSidelinedPlayer> list) {
        this.sidelined = list;
    }

    public List<MatchSummary> getFixtures() {
        return this.fixtures;
    }

    public void setFixtures(List<MatchSummary> list) {
        this.fixtures = list;
    }

    public List<TeamLeague> getLeagues() {
        return this.leagues;
    }

    public void setLeagues(List<TeamLeague> list) {
        this.leagues = list;
    }

    public String getShape() {
        return this.shape;
    }

    public void setShape(String str) {
        this.shape = str;
    }

    @JsonProperty("shape_fixtures")
    public List<String> getShapeFixtures() {
        return this.shapeFixtures;
    }

    public void setShapeFixtures(List<String> list) {
        this.shapeFixtures = list;
    }

    public String toString() {
        String str = "";
        String str2 = str;
        for (int i = 0; i < this.squad.size(); i++) {
            str2 = str2 + this.squad.get(i).toString();
        }
        String str3 = str;
        for (int i2 = 0; i2 < this.sidelined.size(); i2++) {
            str3 = str3 + this.sidelined.get(i2).toString();
        }
        String str4 = str;
        for (int i3 = 0; i3 < this.fixtures.size(); i3++) {
            str4 = str4 + this.fixtures.get(i3).toString();
        }
        String str5 = str;
        for (int i4 = 0; i4 < this.leagues.size(); i4++) {
            str5 = str5 + this.leagues.get(i4).toString();
        }
        for (int i5 = 0; i5 < this.shapeFixtures.size(); i5++) {
            str = str + this.shapeFixtures.get(i5);
        }
        return "Team{id='" + this.f98id + '\'' + ", lastUpdated='" + this.lastUpdated + '\'' + ", teamName='" + this.teamName + '\'' + ", country='" + this.country + '\'' + ", venue='" + this.venue + '\'' + ", venueId='" + this.venueId + '\'' + ", venueSurface='" + this.venueSurface + '\'' + ", venueCapacity='" + this.venueCapacity + '\'' + ", venueAddress='" + this.venueAddress + '\'' + ", founded='" + this.founded + '\'' + ", coach='" + this.coach + '\'' + ", coachId='" + this.coachId + '\'' + ", squad=" + str2 + ", transfers=" + this.transfers.toString() + ", venueCity='" + this.venueCity + '\'' + ", sidelined=" + str3 + ", fixtures=" + str4 + ", leagues=" + str5 + ", shape='" + this.shape + '\'' + ", shapeFixtures=" + str + '}';
    }
}
