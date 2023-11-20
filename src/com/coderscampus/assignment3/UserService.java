package com.coderscampus.assignment3;

public class UserService {

	private final String FILENAME = "data.txt";
	private User[] users = new User[4];

	public UserService() {
		FileService fileService = new FileService();
		users = fileService.readUsersFromFile(FILENAME);
	}

	// Method to check if inputEmail && inputPassword are a match to objectsArray[i]
	public User validateUser(String inputEmail, String inputPassword) {
		for (User user : users) {
			if ((user.getUsername()).equalsIgnoreCase(inputEmail) && ((user.getPassword()).equals(inputPassword))) {
				return user;
			}
		}
		return null;
	}
}
