package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.Mission;
import com.example.demo.database.DatabaseAccess;

@Controller
public class HomeController {
	
	// Initialize Database access variable.
	private DatabaseAccess database;
	
	public HomeController(DatabaseAccess database) {
		this.database=database;
	}
	
	@GetMapping("/")
	public String goHome(Model model) {
		
		model.addAttribute("agentsList", getAgentsList());
		model.addAttribute("mission", new Mission());
		return "index";
	}
	
	@GetMapping("/addMission")
	public String addMission(Model model) {		
		model.addAttribute("agentsList", getAgentsList());
		model.addAttribute("mission", new Mission());
		return "create_mission";
	}
	
	@PostMapping("/createMission")
	public String createMission(@ModelAttribute Mission mission) {
		int returnValue = database.addMission(mission);
		return "redirect:/";
	}
	
	@GetMapping("/viewMissions")
	public String viewMissions(Model model, @RequestParam String agent) {
		List<Mission> agentMissions = database.getAgentMissions(agent.replace('+', ' '));
		model.addAttribute("agent", agent);
		model.addAttribute("agentMissions", agentMissions);
		
		return "view_missions";
	}
	
	public List<Mission> getAgentsList() {
		List<Mission> agents = database.getAgents();
		return agents;
	}
	
	@GetMapping("/deleteMission/{id}")
	public String deleteMission(@PathVariable long id) {
		int returnValue = database.deleteMission(id);
		System.out.println("Return value for deleteMission is: " + returnValue);
		return "redirect:/";
	}
	
	@GetMapping("/editMission/{id}")
	public String editMission(@PathVariable long id, Model model) {
		Mission mission = database.getMission(id);
		if(mission == null) {
			System.out.println("Mission is null");
			return "index";
		}else {
			model.addAttribute("mission", mission);
			return "edit_mission";
		}
	}
	
	@PostMapping("/updateMission")
	public String updateMission(@ModelAttribute Mission mission) {
		int returnValue = database.updateMission(mission);
		return "redirect:/";
	}
	
}
