package ca.sheridancollege.javiersh.beans;

import lombok.Data;

@Data
public class Song {
	private long id;
	private String title;
	private String artist;
	private String genre;
	
	private final String[] genres = {"Spoken Word", "Electronic", "Country", "Classical", "Indie"};
	
}
