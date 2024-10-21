package com.exercise.publicapi.dto;

import com.exercise.publicapi.entity.PublicListing;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CreateListingResponse {
    private ListingDto listing;

    public CreateListingResponse(PublicListing listing) {
        this.listing = new ListingDto(
                listing.getId(),
                listing.getUser().getId(),
                listing.getListingType(),
                listing.getPrice(),
                listing.getCreatedAt(),
                listing.getUpdatedAt()
        );
    }

    public ListingDto getListing() {
        return listing;
    }

    public static class ListingDto {
        private Integer id;
        private Integer userId;
        private String listingType;
        private Integer price;
        private Long createdAt;
        private Long updatedAt;

        public ListingDto(Integer id, Integer userId, String listingType, Integer price, Long createdAt, Long updatedAt) {
            this.id = id;
            this.userId = userId;
            this.listingType = listingType;
            this.price = price;
            final Long timestampInMicroSecond = nowInEpochMicroSecond();
            this.createdAt = timestampInMicroSecond;
            this.updatedAt = timestampInMicroSecond;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getListingType() {
            return listingType;
        }

        public void setListingType(String listingType) {
            this.listingType = listingType;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
        }

        public Long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Long updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
    private static Long nowInEpochMicroSecond() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}

