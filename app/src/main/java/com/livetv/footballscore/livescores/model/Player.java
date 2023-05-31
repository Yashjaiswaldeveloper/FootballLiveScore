package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player implements Serializable {
    private String age;
    private String birthCountry;
    private String birthPlace;
    private String birthdate;
    private String f97id;
    private String firstName;
    private String height;
    private String lastName;
    private String lastUpdated;
    private String name;
    private String nationality;
    private String position;
    private List<Statistic> statistics;
    private List<Statistic> statisticsCups;
    private List<Statistic> statisticsCupsIntl;
    private List<Statistic> statisticsIntl;
    private String team;
    private String teamId;
    private String weight;

    public String getId() {
        return this.f97id;
    }

    public void setId(String str) {
        this.f97id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }

    @JsonProperty("firstname")
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    @JsonProperty("lastname")
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String str) {
        this.team = str;
    }

    @JsonProperty("teamid")
    public String getTeamId() {
        return this.teamId;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String str) {
        this.nationality = str;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String str) {
        this.birthdate = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    @JsonProperty("birthcountry")
    public String getBirthCountry() {
        return this.birthCountry;
    }

    public void setBirthCountry(String str) {
        this.birthCountry = str;
    }

    @JsonProperty("birthplace")
    public String getBirthPlace() {
        return this.birthPlace;
    }

    public void setBirthPlace(String str) {
        this.birthPlace = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public List<Statistic> getStatistics() {
        return this.statistics;
    }

    public void setStatistics(List<Statistic> list) {
        this.statistics = list;
    }

    @JsonProperty("statisticscups")
    public List<Statistic> getStatisticsCups() {
        return this.statisticsCups;
    }

    public void setStatisticsCups(List<Statistic> list) {
        this.statisticsCups = list;
    }

    @JsonProperty("statisticscupsintl")
    public List<Statistic> getStatisticsCupsIntl() {
        return this.statisticsCupsIntl;
    }

    public void setStatisticsCupsIntl(List<Statistic> list) {
        this.statisticsCupsIntl = list;
    }

    @JsonProperty("statisticsintl")
    public List<Statistic> getStatisticsIntl() {
        return this.statisticsIntl;
    }

    public void setStatisticsIntl(List<Statistic> list) {
        this.statisticsIntl = list;
    }

    public String toString() {
        String str = "";
        String str2 = str;
        if (this.statistics != null) {
            for (int i = 0; i < this.statistics.size(); i++) {
                str2 = str2 + this.statistics.get(i).toString();
            }
        }
        String str3 = str;
        if (this.statisticsCups != null) {
            for (int i2 = 0; i2 < this.statisticsCups.size(); i2++) {
                str3 = str3 + this.statisticsCups.get(i2).toString();
            }
        }
        String str4 = str;
        if (this.statisticsIntl != null) {
            for (int i3 = 0; i3 < this.statisticsCupsIntl.size(); i3++) {
                str4 = str4 + this.statisticsCupsIntl.get(i3).toString();
            }
        }
        if (this.statisticsCupsIntl != null) {
            for (int i4 = 0; i4 < this.statisticsIntl.size(); i4++) {
                str = str + this.statisticsIntl.get(i4).toString();
            }
        }
        return "Player{id='" + this.f97id + '\'' + ", name='" + this.name + '\'' + ", lastUpdated='" + this.lastUpdated + '\'' + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", team='" + this.team + '\'' + ", teamId='" + this.teamId + '\'' + ", nationality='" + this.nationality + '\'' + ", birthdate='" + this.birthdate + '\'' + ", age='" + this.age + '\'' + ", birthCountry='" + this.birthCountry + '\'' + ", birthPlace='" + this.birthPlace + '\'' + ", position='" + this.position + '\'' + ", weight='" + this.weight + '\'' + ", height='" + this.height + '\'' + ", statistics=" + str2 + ", statisticsCups=" + str3 + ", statisticsCupsIntl=" + str4 + ", statisticsIntl=" + str + '}';
    }
}
