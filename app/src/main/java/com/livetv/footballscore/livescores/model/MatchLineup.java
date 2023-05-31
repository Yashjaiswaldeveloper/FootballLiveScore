package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchLineup implements Serializable {
    private List<MatchLineupPlayer> localteam;
    private List<MatchLineupPlayer> visitorteam;

    public List<MatchLineupPlayer> getLocalteam() {
        return this.localteam;
    }

    public void setLocalteam(List<MatchLineupPlayer> list) {
        this.localteam = list;
    }

    public List<MatchLineupPlayer> getVisitorteam() {
        return this.visitorteam;
    }

    public void setVisitorteam(List<MatchLineupPlayer> list) {
        this.visitorteam = list;
    }

    public String toString() {
        String str = "";
        String str2 = str;
        if (this.localteam != null) {
            for (int i = 0; i < this.localteam.size(); i++) {
                str2 = str2 + this.localteam.get(i);
            }
        }
        if (this.visitorteam != null) {
            for (int i2 = 0; i2 < this.visitorteam.size(); i2++) {
                str = str + this.visitorteam.get(i2);
            }
        }
        return "MatchLineup{localteam=" + str2 + ", visitorteam=" + str + '}';
    }
}
