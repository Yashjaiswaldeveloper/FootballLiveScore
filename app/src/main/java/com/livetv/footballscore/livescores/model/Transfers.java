package com.livetv.footballscore.livescores.model;

import java.io.Serializable;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transfers implements Serializable {
    private List<TransferPlayer> f103in;
    private List<TransferPlayer> out;

    public List<TransferPlayer> getIn() {
        return this.f103in;
    }

    public void setIn(List<TransferPlayer> list) {
        this.f103in = list;
    }

    public List<TransferPlayer> getOut() {
        return this.out;
    }

    public void setOut(List<TransferPlayer> list) {
        this.out = list;
    }

    public String toString() {
        String str = "";
        String str2 = str;
        for (int i = 0; i < this.f103in.size(); i++) {
            str2 = str2 + this.f103in.get(i).toString();
        }
        for (int i2 = 0; i2 < this.out.size(); i2++) {
            str = str + this.out.get(i2).toString();
        }
        return "Transfers{in=" + str2 + ", out=" + str + '}';
    }
}
