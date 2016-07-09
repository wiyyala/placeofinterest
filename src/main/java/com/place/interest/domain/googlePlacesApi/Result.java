package com.place.interest.domain.googlePlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties
public class Result {

    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private List<Photo> photos;
    private String place_id;
    private String reference;
    private String scope;
    private List<String> types;
    private String vicinity;

    private String formatted_address;
    private String formatted_phone_number;
    private String international_phone_number;
    private String url;
    private String website;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getFormatted_phone_number() {
        return formatted_phone_number;
    }

    public void setFormatted_phone_number(String formatted_phone_number) {
        this.formatted_phone_number = formatted_phone_number;
    }

    public String getInternational_phone_number() {
        return international_phone_number;
    }

    public void setInternational_phone_number(String international_phone_number) {
        this.international_phone_number = international_phone_number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(geometry, result.geometry) &&
                Objects.equals(icon, result.icon) &&
                Objects.equals(id, result.id) &&
                Objects.equals(name, result.name) &&
                Objects.equals(photos, result.photos) &&
                Objects.equals(place_id, result.place_id) &&
                Objects.equals(reference, result.reference) &&
                Objects.equals(scope, result.scope) &&
                Objects.equals(types, result.types) &&
                Objects.equals(vicinity, result.vicinity) &&
                Objects.equals(formatted_address, result.formatted_address) &&
                Objects.equals(formatted_phone_number, result.formatted_phone_number) &&
                Objects.equals(international_phone_number, result.international_phone_number) &&
                Objects.equals(url, result.url) &&
                Objects.equals(website, result.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geometry, icon, id, name, photos, place_id, reference, scope, types, vicinity, formatted_address, formatted_phone_number, international_phone_number, url, website);
    }

    @Override
    public String toString() {
        return "Result{" +
                "geometry=" + geometry +
                ", icon='" + icon + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", photos=" + photos +
                ", place_id='" + place_id + '\'' +
                ", reference='" + reference + '\'' +
                ", scope='" + scope + '\'' +
                ", types=" + types +
                ", vicinity='" + vicinity + '\'' +
                ", formatted_address='" + formatted_address + '\'' +
                ", formatted_phone_number='" + formatted_phone_number + '\'' +
                ", international_phone_number='" + international_phone_number + '\'' +
                ", url='" + url + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
