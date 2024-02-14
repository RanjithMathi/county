package com.fleet.county.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.county.entity.County;
import com.fleet.county.service.CountyService;

@RestController
public class CountyController {

	@Autowired
	private CountyService countyService;

	@GetMapping("/suggest")
	public List<County> countySuggestion(@RequestParam(name ="q") String q) {
		return countyService.countySuggestion( q);
	}
	
	
}
