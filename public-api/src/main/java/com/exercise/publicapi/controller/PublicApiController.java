package com.exercise.publicapi.controller;

import com.exercise.publicapi.dto.*;
import com.exercise.publicapi.entity.PublicListing;
import com.exercise.publicapi.entity.PublicUser;
import com.exercise.publicapi.repository.PublicListingRepository;
import com.exercise.publicapi.repository.PublicUserRepository;
import com.exercise.publicapi.service.ListingService;
import com.exercise.publicapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/public-api")
public class PublicApiController {

    @Autowired
    private PublicListingRepository publicListingRepository;

    @Autowired
    private PublicUserRepository publicUserRepository;

    @Autowired
    private ListingService listingService;

    @Autowired
    private UserService userService;

    @GetMapping("/listings")
    public ListingsResponse getListings(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer userId) {

        Page<PublicListing> listingsPage = listingService.getListings(pageNum, pageSize, userId);

        ListingsResponse response = new ListingsResponse();
        response.setResult(true);
        response.setListings(listingsPage.getContent());
        return response;
    }

    @PostMapping("/users")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        PublicUser newUser = new PublicUser();

        newUser.setName(createUserRequest.getName());
        final Long timestampInMicroSecond = nowInEpochMicroSecond();
        newUser.setCreatedAt(timestampInMicroSecond);
        newUser.setUpdatedAt(timestampInMicroSecond);

        PublicUser savedUser = publicUserRepository.save(newUser);

        return new CreateUserResponse(savedUser);
    }

    @PostMapping("/listings")
    public CreateListingResponse createListing(@RequestBody CreateListingRequest createListingRequest) {
        System.out.println("Received POST request to create listing with userId: " + createListingRequest.getUserId());

        PublicListing listing = listingService.createListing(
                createListingRequest.getUserId(),
                createListingRequest.getListingType(),
                createListingRequest.getPrice()
        );

        System.out.println("Listing created with id: " + listing.getId());
        return new CreateListingResponse(listing);
    }

    private Long nowInEpochMicroSecond() {
        return ChronoUnit.MICROS.between(Instant.EPOCH, Instant.now());
    }
}