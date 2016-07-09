package com.place.interest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Temple {

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String placeId;
    private String address;
    private String phoneNumber;
    private String internationlPhoneNumber;
    private List<Photo> photos;
    private String mapsUrl;
    private String website;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInternationlPhoneNumber() {
        return internationlPhoneNumber;
    }

    public void setInternationlPhoneNumber(String internationlPhoneNumber) {
        this.internationlPhoneNumber = internationlPhoneNumber;
    }

    public List<Photo> getPhotos() {
        if(photos == null){
            photos = new ArrayList();
        }
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getMapsUrl() {
        return mapsUrl;
    }

    public void setMapsUrl(String mapsUrl) {
        this.mapsUrl = mapsUrl;
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
        Temple temple = (Temple) o;
        return Objects.equals(name, temple.name) &&
                Objects.equals(latitude, temple.latitude) &&
                Objects.equals(longitude, temple.longitude) &&
                Objects.equals(placeId, temple.placeId) &&
                Objects.equals(address, temple.address) &&
                Objects.equals(phoneNumber, temple.phoneNumber) &&
                Objects.equals(internationlPhoneNumber, temple.internationlPhoneNumber) &&
                Objects.equals(photos, temple.photos) &&
                Objects.equals(mapsUrl, temple.mapsUrl) &&
                Objects.equals(website, temple.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude, placeId, address, phoneNumber, internationlPhoneNumber, photos, mapsUrl, website);
    }

    @Override
    public String toString() {
        return "Temple{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", placeId='" + placeId + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", internationlPhoneNumber='" + internationlPhoneNumber + '\'' +
                ", photos=" + photos +
                ", mapsUrl='" + mapsUrl + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
