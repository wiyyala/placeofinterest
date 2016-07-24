package com.place.interest.domain.googlePlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties
public class Prediction {

    private String description;
    private String id;
    private String place_id;
    private String reference;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(place_id, that.place_id) &&
                Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, id, place_id, reference);
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", place_id='" + place_id + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
