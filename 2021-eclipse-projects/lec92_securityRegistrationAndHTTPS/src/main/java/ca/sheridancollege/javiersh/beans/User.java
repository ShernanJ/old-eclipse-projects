package ca.sheridancollege.javiersh.beans;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NonNull
public class User {
	
	private long userId;
	private String email;
	private String encryptedPassword;
	private boolean enabled;
}
