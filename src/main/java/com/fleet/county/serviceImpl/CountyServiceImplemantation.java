package com.fleet.county.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.county.entity.County;
import com.fleet.county.repository.CountyRepository;
import com.fleet.county.service.CountyService;

@Service
public class CountyServiceImplemantation implements CountyService {

	@Autowired
	private CountyRepository countyRepository;

	@Override
	public List<County> countySuggestion(String q) {
		List<County> nameWiseList = new ArrayList<>();
		List<County> stateWiseList = new ArrayList<>();
		String name = null;
		String state = null;
		if (q.contains(",")) {
			name = q.split(",")[0].trim();
			state = q.split(",")[1].trim();
		} else {
			if (q.length() > 2) {
				name = q;
			} else {
				state = q;
			}

		}
		if (null != name) {
			nameWiseList = countyRepository.findByNameContainingIgnoreCase(name);
		}
		if (state != null) {
			stateWiseList = countyRepository.findByStateContainingIgnoreCase(state);
		}

		Set<County> uniqueSet = new LinkedHashSet<>(nameWiseList);
		uniqueSet.addAll(stateWiseList);
		List<County> finalResult = new ArrayList<>(uniqueSet);
		return finalResult;

	}

}
