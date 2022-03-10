package ca.sheridancollege.javiersh.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.javiersh.beans.User;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	public User findUserAccount(String email) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user WHERE email=:email";
		parameters.addValue("email", email);
		ArrayList<User> users = (ArrayList<User>) jdbc.query(query, parameters,
				new BeanPropertyRowMapper<User>(User.class));

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public List<String> getRolesById(Long userId) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT user_role.userId, sec_role.roleName " + "FROM user_role, sec_role "
				+ "WHERE user_role.roleId=sec_role.roleId " + "AND userId=:userId";
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roles.add((String) row.get("roleName"));
		}
		return roles;
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void addUser(String email, String password) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO sec_user" + "(email, encryptedPassword, enabled)"
				+ " values (:email, :encryptedPassword, 1)";
		parameters.addValue("email", email);
		parameters.addValue("encryptedPassword", passwordEncoder.encode(password));
		jdbc.update(query, parameters);
	}

	public void addRole(Long userId, Long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = " INSERT INTO user_role(userId, roleId) " + "VALUES (:userId, :roleId)";
		parameters.addValue("userId", userId);
		parameters.addValue("roleId", roleId);
		jdbc.update(query, parameters);
	}
}
