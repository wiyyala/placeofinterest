package com.place.interest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TempleData {

    private List<Temple> temples;

    public List<Temple> getTemples() {
        if(temples == null){
            temples = new ArrayList();
        }
        return temples;
    }

    public void setTemples(List<Temple> temples) {
        this.temples = temples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempleData that = (TempleData) o;
        return Objects.equals(temples, that.temples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temples);
    }

    @Override
    public String toString() {
        return "TempleData{" +
                "temples=" + temples +
                '}';
    }
}
