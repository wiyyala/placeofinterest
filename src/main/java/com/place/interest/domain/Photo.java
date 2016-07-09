package com.place.interest.domain;

import java.util.List;
import java.util.Objects;

public class Photo {
    private Integer height;
    private Integer width;
    private String reference;
    private List<String> htmlAttributions;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<String> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(height, photo.height) &&
                Objects.equals(width, photo.width) &&
                Objects.equals(reference, photo.reference) &&
                Objects.equals(htmlAttributions, photo.htmlAttributions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, reference, htmlAttributions);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "height=" + height +
                ", width=" + width +
                ", reference='" + reference + '\'' +
                ", htmlAttributions=" + htmlAttributions +
                '}';
    }
}
