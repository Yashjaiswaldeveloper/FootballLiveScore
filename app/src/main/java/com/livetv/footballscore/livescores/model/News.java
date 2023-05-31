package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class News implements Serializable {
    List<NewsItem> items;

    public List<NewsItem> getItems() {
        return this.items;
    }

    public void setItems(List<NewsItem> list) {
        this.items = list;
    }
}
