package com.cg.placementmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.placementmanagement.model.College;


@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	 
}