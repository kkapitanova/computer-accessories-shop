

import java.util.ArrayList;

public class UserUtilities {
	
	public static final String USERS_FILE = "UserAccounts.txt";
	
	public static ArrayList<User> readUsersFromFile() {
		ArrayList<User> userList;
		// Create an object from ReadingFromFile class
		ReadFromFile rff = new ReadFromFile(USERS_FILE);
		// Call readFile method which reads the file and add data to userList array
		userList = (ArrayList<User>) rff.readFile();
		
		return userList;
	}
	
	public static void authorizeUser(User user) {
		
		if (user.getRole().equals("admin")) {
			new Admin().setVisible(true);
		}
		else {
			new Customer().setVisible(true);
		}
	
}
}

