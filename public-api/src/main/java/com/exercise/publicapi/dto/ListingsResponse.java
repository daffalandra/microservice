package com.exercise.publicapi.dto;
import com.exercise.publicapi.entity.PublicListing;

import java.util.List;

public class ListingsResponse {
    private boolean result;
    private List<PublicListing> listings;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<PublicListing> getListings() {
        return listings;
    }

    public void setListings(List<PublicListing> listings) {
        this.listings = listings;
    }
}

