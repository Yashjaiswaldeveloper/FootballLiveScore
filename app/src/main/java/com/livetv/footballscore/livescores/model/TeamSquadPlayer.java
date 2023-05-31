package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSquadPlayer implements Serializable {
    private String age;
    private String appearences;
    private String f100id;
    private String goals;
    private String injured;
    private String lineups;
    private String minutes;
    private String name;
    private String number;
    private String position;
    private String redCards;
    private String substituteIn;
    private String substituteOut;
    private String substitutesOnBench;
    private String yellowCards;
    private String yellowRed;

    public String getId() {
        return this.f100id;
    }

    public void setId(String str) {
        this.f100id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public String getInjured() {
        return this.injured;
    }

    public void setInjured(String str) {
        this.injured = str;
    }

    public String getMinutes() {
        return this.minutes;
    }

    public void setMinutes(String str) {
        this.minutes = str;
    }

    public String getAppearences() {
        return this.appearences;
    }

    public void setAppearences(String str) {
        this.appearences = str;
    }

    public String getLineups() {
        return this.lineups;
    }

    public void setLineups(String str) {
        this.lineups = str;
    }

    @JsonProperty("substitute_in")
    public String getSubstituteIn() {
        return this.substituteIn;
    }

    public void setSubstituteIn(String str) {
        this.substituteIn = str;
    }

    @JsonProperty("substitute_out")
    public String getSubstituteOut() {
        return this.substituteOut;
    }

    public void setSubstituteOut(String str) {
        this.substituteOut = str;
    }

    @JsonProperty("substitutes_on_bench")
    public String getSubstitutesOnBench() {
        return this.substitutesOnBench;
    }

    public void setSubstitutesOnBench(String str) {
        this.substitutesOnBench = str;
    }

    public String getGoals() {
        return this.goals;
    }

    public void setGoals(String str) {
        this.goals = str;
    }

    @JsonProperty("yellowcards")
    public String getYellowCards() {
        return this.yellowCards;
    }

    public void setYellowCards(String str) {
        this.yellowCards = str;
    }

    @JsonProperty("yellowred")
    public String getYellowRed() {
        return this.yellowRed;
    }

    public void setYellowRed(String str) {
        this.yellowRed = str;
    }

    @JsonProperty("redcards")
    public String getRedCards() {
        return this.redCards;
    }

    public void setRedCards(String str) {
        this.redCards = str;
    }

    public String toString() {
        return "TeamSquadPlayer{id='" + this.f100id + '\'' + ", name='" + this.name + '\'' + ", number='" + this.number + '\'' + ", age='" + this.age + '\'' + ", position='" + this.position + '\'' + ", injured='" + this.injured + '\'' + ", minutes='" + this.minutes + '\'' + ", appearences='" + this.appearences + '\'' + ", lineups='" + this.lineups + '\'' + ", substituteIn='" + this.substituteIn + '\'' + ", substituteOut='" + this.substituteOut + '\'' + ", substitutesOnBench='" + this.substitutesOnBench + '\'' + ", goals='" + this.goals + '\'' + ", yellowCards='" + this.yellowCards + '\'' + ", yellowRed='" + this.yellowRed + '\'' + ", redCards='" + this.redCards + '\'' + '}';
    }
}
