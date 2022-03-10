package com.example.demo.database;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Mission;

@Repository
public class DatabaseAccess {
	
	//Initialize Java Database Connectivity
	private NamedParameterJdbcTemplate jdbc;

	public DatabaseAccess(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	public List<Mission> getMissions(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM missions";
		
		BeanPropertyRowMapper<Mission> missionMapper = new BeanPropertyRowMapper<Mission>(Mission.class);
		
		List<Mission> missions = jdbc.query(query, namedParameters, missionMapper);
		
		return missions;
	}
	
	public int addMission(Mission mission) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query = "INSERT INTO missions (agent, title, gadget1, gadget2) VALUES (:agent, :title, :gadget1, :gadget2)";
		
		namedParameters
		.addValue("agent", mission.getAgent())
		.addValue("title", mission.getTitle())
		.addValue("gadget1", mission.getGadget1())
		.addValue("gadget2", mission.getGadget2());
		
		int returnValue = jdbc.update(query, namedParameters);
		
		return returnValue;
	}
	
	public List<Mission> getAgents(){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT DISTINCT agent FROM missions";
		
		BeanPropertyRowMapper<Mission> agentMapper = new BeanPropertyRowMapper<Mission>(Mission.class);
		
		List<Mission> agents = jdbc.query(query, namedParameters, agentMapper);
		
		return agents;
	}
	
	public List<Mission> getAgentMissions(String agent){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM missions WHERE agent = '"+ agent + "'";
		
		BeanPropertyRowMapper<Mission> missionMapper = new BeanPropertyRowMapper<Mission>(Mission.class);
		
		List<Mission> agentMissions = jdbc.query(query, namedParameters, missionMapper);
		
		return agentMissions;
	}
	
	public int deleteMission(long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "DELETE FROM missions WHERE id = :id";
		namedParameters
			.addValue("id", id);
		
		
		return jdbc.update(query, namedParameters);
	}
	
	public int updateMission(Mission mission) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "UPDATE missions SET title=:title, gadget1=:gadget1, gadget2=:gadget2 WHERE id=:id";
		namedParameters
			.addValue("title", mission.getTitle())
			.addValue("gadget1", mission.getGadget1())
			.addValue("gadget2", mission.getGadget2())
			.addValue("id", mission.getId());
		return jdbc.update(query, namedParameters);
	}
	
	public Mission getMission(long id) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM missions WHERE id = :id";
		namedParameters.addValue("id", id);
		BeanPropertyRowMapper<Mission> missionMapper = new BeanPropertyRowMapper<Mission>(Mission.class);
		List<Mission> missions = jdbc.query(query, namedParameters, missionMapper);
		if(missions.isEmpty()) {
			return null;
		}else {
			return missions.get(0);
		}
	}
	
}
