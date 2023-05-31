package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Substitutions implements Serializable {
    private List<MatchSubstitutionPlayer> localteam;
    private List<MatchSubstitutionPlayer> visitorteam;

    public List<MatchSubstitutionPlayer> getLocalteam() {
        return this.localteam;
    }

    public void setLocalteam(List<MatchSubstitutionPlayer> list) {
        this.localteam = list;
    }

    public List<MatchSubstitutionPlayer> getVisitorteam() {
        return this.visitorteam;
    }

    public void setVisitorteam(List<MatchSubstitutionPlayer> list) {
        this.visitorteam = list;
    }

    public String toString() {
        String str;
        String str2 = "";
        if (this.localteam == null || this.visitorteam == null) {
            str = str2;
        } else {
            String str3 = str2;
            for (int i = 0; i < this.localteam.size(); i++) {
                str3 = str3 + this.localteam.get(i).toString();
            }
            for (int i2 = 0; i2 < this.visitorteam.size(); i2++) {
                str2 = str2 + this.visitorteam.get(i2).toString();
            }
            str = str2;
            str2 = str3;
        }
        return "Substitutions{localteam=" + str2 + ", visitorteam=" + str + '}';
    }
}
