package com.place.interest.domain.googlePlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties
public class Photo {

    private Integer height;
    private List<String> html_attributions;
    private String photo_reference;
    private Integer width;


    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(height, photo.height) &&
                Objects.equals(html_attributions, photo.html_attributions) &&
                Objects.equals(photo_reference, photo.photo_reference) &&
                Objects.equals(width, photo.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, html_attributions, photo_reference, width);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "height=" + height +
                ", html_attributions=" + html_attributions +
                ", photo_reference='" + photo_reference + '\'' +
                ", width=" + width +
                '}';
    }
}
