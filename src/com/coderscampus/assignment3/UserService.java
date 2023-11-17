package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	// Method to set all properties of a User
	public User setProperties(String[] inputArray) {
		User user = new User();
		user.setUsername(inputArray[0]);
		user.setPassword(inputArray[1]);
		user.setName(inputArray[2]);
		return user;
	}

	// Method to filter a given String fileName into User[]

	public User[] fileToUserArray(String fileName) {
		BufferedReader fileReader = null;
		UserService user = new UserService();
		String[] userStringArray = new String[3];
		User[] userInfoArray = new User[4];

		try {
			fileReader = new BufferedReader(new FileReader(fileName));

			String fileLine;
			int i = 0;
			while ((fileLine = fileReader.readLine()) != null) {
				userStringArray = fileLine.split(",");
				userInfoArray[i] = user.setProperties(userStringArray);
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("IO Exception while closing fileReader");
				e.printStackTrace();
			}
		}
		return userInfoArray;
	}

	// Method to check if inputEmail && inputPassword are a match to objectsArray[i]

	public User validateUser(String inputEmail, String inputPassword) {
		UserService userService = new UserService();
		User[] objectsArray = userService.fileToUserArray("data.txt");

		for (User user : objectsArray) {
			if ((user.getUsername()).equalsIgnoreCase(inputEmail)
					&& ((user.getPassword()).equals(inputPassword))) {
				return user;
			}
		}
		return null;
	}
}
