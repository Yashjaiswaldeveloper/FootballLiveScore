package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedAppStart implements Serializable {
    private List<CountryAppStart> countries;

    public List<CountryAppStart> getCountries() {
        return this.countries;
    }

    public void setCountries(List<CountryAppStart> list) {
        this.countries = list;
    }
}
