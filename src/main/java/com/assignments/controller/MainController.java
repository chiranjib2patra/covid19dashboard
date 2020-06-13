package com.assignments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.assignments.model.LocationStats;
import com.assignments.service.DataService;

@Controller
public class MainController {

	@Autowired
	DataService dataService;

	@GetMapping("/")
	public String home(Model model) {
		List<LocationStats> allStats = dataService.getAllStats();
		int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStatus", dataService.getAllStats());
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("locationStats", allStats);
		model.addAttribute("totalReportedCases", totalReportedCases);
		model.addAttribute("totalNewCases", totalNewCases);
		System.out.println(totalNewCases);
		return "home";
	}
}
