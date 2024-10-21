package com.exercise.publicapi.repository;
import com.exercise.publicapi.entity.PublicListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PublicListingRepository extends JpaRepository<PublicListing, Integer> {
    Page<PublicListing> findByUserId(Integer userId, Pageable pageable);
}
