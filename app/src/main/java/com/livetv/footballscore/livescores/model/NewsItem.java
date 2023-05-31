package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsItem implements Serializable {
    private String date;
    private String description;
    private String f96ts;
    private String image;
    private String link;
    private String title;

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getTs() {
        return this.f96ts;
    }

    public void setTs(String str) {
        this.f96ts = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String toString() {
        return "NewsItem{image='" + this.image + '\'' + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", link='" + this.link + '\'' + ", ts='" + this.f96ts + '\'' + ", date='" + this.date + '\'' + '}';
    }
}
