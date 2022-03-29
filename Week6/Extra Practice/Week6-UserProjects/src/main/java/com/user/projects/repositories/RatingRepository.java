package com.user.projects.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.projects.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    
    
}