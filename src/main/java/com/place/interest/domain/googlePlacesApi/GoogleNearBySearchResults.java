package com.place.interest.domain.googlePlacesApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties
public class GoogleNearBySearchResults {

    private List<String> html_attributions;
    private List<Result> results;

    public List<String> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<String> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoogleNearBySearchResults that = (GoogleNearBySearchResults) o;
        return Objects.equals(html_attributions, that.html_attributions) &&
                Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(html_attributions, results);
    }

    @Override
    public String toString() {
        return "GoogleNearBySearchResults{" +
                "html_attributions=" + html_attributions +
                ", results=" + results +
                '}';
    }
}
