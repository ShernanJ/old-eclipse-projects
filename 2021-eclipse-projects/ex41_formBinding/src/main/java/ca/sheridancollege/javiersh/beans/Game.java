package ca.sheridancollege.javiersh.beans;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Game {
	
	private Long id;
	private String title;
	private String publisher;
	private String platform;
	private String[] platforms = {"PS4", "PS5", "PC", "Xbox One", "Xbox Series X"};
	private BigDecimal price;
}
