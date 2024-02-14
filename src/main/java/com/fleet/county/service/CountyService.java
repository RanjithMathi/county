package com.fleet.county.service;

import java.util.List;

import com.fleet.county.entity.County;

public interface CountyService {
	List<County> countySuggestion(String q);
}
