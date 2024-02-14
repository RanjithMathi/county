package com.fleet.county.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleet.county.entity.County;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {

	public List<County> findByNameContainingIgnoreCase(String name);

	public List<County> findByStateContainingIgnoreCase(String state);

}
