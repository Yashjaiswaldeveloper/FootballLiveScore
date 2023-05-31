package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchSummary implements Serializable {
    private String date;
    private String f95id;
    private String fileGroup;
    private String leagueId;
    private String leagueKey;
    private String leagueName;
    private String localCoach;
    private String localCoachId;
    private String localTeam;
    private String localTeamId;
    private String localTeamOrg;
    private String scoreTime;
    private String season;
    private String stageId;
    private String stageName;
    private String stageRound;
    private String status;
    private String time;
    private String visitorCoach;
    private String visitorCoachId;
    private String visitorTeam;
    private String visitorTeamId;
    private String visitorTeamOrg;

    public String getId() {
        return this.f95id;
    }

    public void setId(String str) {
        this.f95id = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    @JsonProperty("gs_visitorteamid")
    public String getVisitorTeamId() {
        return this.visitorTeamId;
    }

    public void setVisitorTeamId(String str) {
        this.visitorTeamId = str;
    }

    @JsonProperty("gs_localteamid")
    public String getLocalTeamId() {
        return this.localTeamId;
    }

    public void setLocalTeamId(String str) {
        this.localTeamId = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    @JsonProperty("scoretime")
    public String getScoreTime() {
        return this.scoreTime;
    }

    public void setScoreTime(String str) {
        this.scoreTime = str;
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

    @JsonProperty("leagueid")
    public String getLeagueId() {
        return this.leagueId;
    }

    public void setLeagueId(String str) {
        this.leagueId = str;
    }

    @JsonProperty("leaguename")
    public String getLeagueName() {
        return this.leagueName;
    }

    public void setLeagueName(String str) {
        this.leagueName = str;
    }

    @JsonProperty("filegroup")
    public String getFileGroup() {
        return this.fileGroup;
    }

    public void setFileGroup(String str) {
        this.fileGroup = str;
    }

    public String getStageId() {
        return this.stageId;
    }

    public void setStageId(String str) {
        this.stageId = str;
    }

    public String getStageRound() {
        return this.stageRound;
    }

    public void setStageRound(String str) {
        this.stageRound = str;
    }

    public String getStageName() {
        return this.stageName;
    }

    public void setStageName(String str) {
        this.stageName = str;
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

    @JsonProperty("coachLocal")
    public String getLocalCoach() {
        return this.localCoach;
    }

    public void setLocalCoach(String str) {
        this.localCoach = str;
    }

    @JsonProperty("coachLocalId")
    public String getLocalCoachId() {
        return this.localCoachId;
    }

    public void setLocalCoachId(String str) {
        this.localCoachId = str;
    }

    @JsonProperty("coachVisitor")
    public String getVisitorCoach() {
        return this.visitorCoach;
    }

    public void setVisitorCoach(String str) {
        this.visitorCoach = str;
    }

    @JsonProperty("coachVisitorId")
    public String getVisitorCoachId() {
        return this.visitorCoachId;
    }

    public void setVisitorCoachId(String str) {
        this.visitorCoachId = str;
    }

    @JsonProperty("localteam_org")
    public String getLocalTeamOrg() {
        return this.localTeamOrg;
    }

    public void setLocalTeamOrg(String str) {
        this.localTeamOrg = str;
    }

    @JsonProperty("visitorteam_org")
    public String getVisitorTeamOrg() {
        return this.visitorTeamOrg;
    }

    public void setVisitorTeamOrg(String str) {
        this.visitorTeamOrg = str;
    }

    public String toString() {
        return "MatchSummary{id='" + this.f95id + '\'' + ", time='" + this.time + '\'' + ", status='" + this.status + '\'' + ", visitorTeamId='" + this.visitorTeamId + '\'' + ", localTeamId='" + this.localTeamId + '\'' + ", date='" + this.date + '\'' + ", scoreTime='" + this.scoreTime + '\'' + ", localTeam='" + this.localTeam + '\'' + ", visitorTeam='" + this.visitorTeam + '\'' + ", leagueId='" + this.leagueId + '\'' + ", leagueName='" + this.leagueName + '\'' + ", fileGroup='" + this.fileGroup + '\'' + ", stageId='" + this.stageId + '\'' + ", stageRound='" + this.stageRound + '\'' + ", stageName='" + this.stageName + '\'' + ", season='" + this.season + '\'' + ", leagueKey='" + this.leagueKey + '\'' + ", localCoach='" + this.localCoach + '\'' + ", localCoachId='" + this.localCoachId + '\'' + ", visitorCoach='" + this.visitorCoach + '\'' + ", visitorCoachId='" + this.visitorCoachId + '\'' + ", localTeamOrg='" + this.localTeamOrg + '\'' + ", visitorTeamOrg='" + this.visitorTeamOrg + '\'' + '}';
    }
}
