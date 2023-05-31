package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointTable implements Serializable {
    private String filegroup;
    private List<PointTableGroup> groups;
    private String leaguename;

    public String getFilegroup() {
        return this.filegroup;
    }

    public void setFilegroup(String str) {
        this.filegroup = str;
    }

    public String getLeaguename() {
        return this.leaguename;
    }

    public void setLeaguename(String str) {
        this.leaguename = str;
    }

    public List<PointTableGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(List<PointTableGroup> list) {
        this.groups = list;
    }
}
