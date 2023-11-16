package com.coderscampus.assignment3;
import java.util.Scanner;

public class UserLoginApplication {

	public String collectUserInput() {
		try (Scanner scanner = new Scanner(System.in)) {
			UserService collectInput = new UserService();

			System.out.println("Enter your Email:");
			String inputEmail = scanner.nextLine();
			System.out.println("Enter your Password");
			String inputPassword = scanner.nextLine();
			collectInput.validateUser(inputEmail, inputPassword);

			int loginCounter = 1;
			while (loginCounter < 5) {
				if (collectInput.validateUser(inputEmail, inputPassword) != null) {
					User user = collectInput.validateUser(inputEmail, inputPassword);
					return "Welcome " + user.getName();
				} else if (collectInput.validateUser(inputEmail, inputPassword) == null) {
					loginCounter++;
					System.out.println("Invalid login, please try again");
					System.out.println("Enter your Email:");
					inputEmail = scanner.nextLine();
					System.out.println("Enter your Password");
					inputPassword = scanner.nextLine();
				}
			}
			scanner.close();
		}
		return "Too many failed login attempts, you are now locked out.";
	}
	
	public static void main(String[] args) {
		UserLoginApplication loginApplication = new UserLoginApplication();
		System.out.println(loginApplication.collectUserInput());
	}

}
