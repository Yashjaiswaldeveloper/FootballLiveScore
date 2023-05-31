package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchCommentry implements Serializable {
    private List<MatchEvent> events;
    private MatchStat stats;

    public List<MatchEvent> getEvents() {
        return this.events;
    }

    public void setEvents(List<MatchEvent> list) {
        this.events = list;
    }

    public MatchStat getStats() {
        return this.stats;
    }

    public void setStats(MatchStat matchStat) {
        this.stats = matchStat;
    }

    public String toString() {
        String str = "";
        String str2 = str;
        for (int i = 0; i < this.events.size(); i++) {
            str2 = str2 + this.events.get(i);
        }
        MatchStat matchStat = this.stats;
        if (matchStat != null) {
            str = matchStat.toString();
        }
        return "MatchCommentry{events=" + str2 + ", stats=" + str + '}';
    }
}
