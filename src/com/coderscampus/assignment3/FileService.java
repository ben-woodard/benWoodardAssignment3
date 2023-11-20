package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public User[] readUsersFromFile(String fileName) {
		BufferedReader fileReader = null;
		String[] userStringArray = new String[3];
		User[] userInfoArray = new User[4];

		try {
			fileReader = new BufferedReader(new FileReader(fileName));

			String fileLine;
			int i = 0;
			while ((fileLine = fileReader.readLine()) != null) {
				userStringArray = fileLine.split(",");
				userInfoArray[i] = new User(userStringArray);
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
}
