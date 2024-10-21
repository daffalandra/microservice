package com.exercise.publicapi.entity;

import jakarta.persistence.*;

@Entity
public class PublicListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String listingType;
    private Integer price;
    private Long createdAt;
    private Long updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private PublicUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PublicUser getUser() {
        return user;
    }

    public void setUser(PublicUser user) {
        this.user = user;
    }
}
