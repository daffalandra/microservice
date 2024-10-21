package com.exercise.publicapi.service;

import com.exercise.publicapi.entity.PublicListing;
import com.exercise.publicapi.entity.PublicUser;
import com.exercise.publicapi.repository.PublicListingRepository;
import com.exercise.publicapi.repository.PublicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class ListingService {

    @Autowired
    private PublicListingRepository listingRepository;

    @Autowired
    private PublicUserRepository userRepository;

    public PublicListing createListing(Integer userId, String listingType, Integer price) {
        PublicUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        PublicListing listing = new PublicListing();
        listing.setUser(user);
        listing.setListingType(listingType);
        listing.setPrice(price);
        final Long timestampInMicroSecond = nowInEpochMicroSecond();
        listing.setCreatedAt(timestampInMicroSecond);
        listing.setUpdatedAt(timestampInMicroSecond);

        return listingRepository.save(listing);
    }

    public Page<PublicListing> getListings(Integer pageNum, Integer pageSize, Integer userId) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);

        if (userId != null) {
            return listingRepository.findByUserId(userId, pageRequest);
        }

        return listingRepository.findAll(pageRequest);
    }

    private Long nowInEpochMicroSecond() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}

