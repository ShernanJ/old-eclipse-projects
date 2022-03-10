package ca.sheridancollege.javiersh.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.javiersh.beans.Note;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	/**
	 * the insertNote method.
	 * 
	 * When this method is called, the user input entered will be inserted into
	 * the database.
	 * 
	 * @param note
	 */
	public void insertNote(Note note) {

		// Used for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Specify the query
		String query = "INSERT INTO note(subject, content, dateWritten, timeWritten) VALUES (:subject, :content, :dateWritten, :timeWritten) ";

		// Specify the name
		namedParameters.addValue("subject", note.getSubject());
		namedParameters.addValue("content", note.getContent());
		namedParameters.addValue("dateWritten", note.getDateWritten());
		namedParameters.addValue("timeWritten", note.getTimeWritten());

		// Insert the row to the DB and check the return value
		int rowsAffected = jdbc.update(query, namedParameters);

		// Check if any rows were updated.
		if (rowsAffected > 0) {
			System.out.println("Inserted Note into the database");
		}
	}

	/**
	 * The getAllNotesList method.
	 * 
	 * When this method is called, acquires a list of all the notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getAllNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	// Cannot figure out how to dynamically get all data, therefore hard coded a
	// bit.

	/**
	 * The getGeneralNotesList method.
	 * 
	 * When this method is called, acquires a list of all the General notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getGeneralNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'General'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getGroceryNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Grocery notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getGroceryNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'Grocery'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getSchoolNotesList method.
	 * 
	 * When this method is called, acquires a list of all the School notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getSchoolNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'School'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getWorkNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Work notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getWorkNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'Work'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getChoresNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Chores notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getChoresNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'Chores'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getGameNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Game notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getGameNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'Game'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}

	/**
	 * The getHobbyNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Hobby notes in the database.
	 * 
	 * 
	 * @return
	 */
	public List<Note> getHobbyNotesList() {

		// To use for Parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Get all students from the DB
		String query = "SELECT * FROM note WHERE subject = 'Hobby'";

		// Return the list of All Notes.
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
	}
	
	/**
	 * The getOtherNotesList method.
	 * 
	 * When this method is called, acquires a list of all the Other notes in the database.
	 * 
	 * 
	 * @return
	 */
		public List<Note> getOtherNotesList() {

			// To use for Parameters
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();

			// Get all students from the DB
			String query = "SELECT * FROM note WHERE subject = 'Other'";

			// Return the list of All Notes.
			return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Note>(Note.class));
		}
		
		/**
		 * The deleteContent method.
		 * 
		 * When this method is called, deletes content from a certain subject.
		 * 
		 * 
		 * @return
		 */
		public void deleteContent(String subject, int id) {
			// To use for Parameters.
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			
			//Specify the query.
			String query = "DELETE FROM note WHERE subject = :subject AND id = :id";
			
			// Specify the name
			namedParameters.addValue("subject", subject);
			namedParameters.addValue("id", id);


			// Insert the row to the DB and check the return value
			int rowsAffected = jdbc.update(query, namedParameters);

			// Check if any rows were updated.
			if (rowsAffected > 0) {
				System.out.println("Inserted Note into the database");
			}
			
		}

}
