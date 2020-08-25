

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFile {

	private String fileName;
	
	public ReadFromFile(String fileName) {
		this.fileName = fileName;
		
	}
	
	public ArrayList<?> readFile() {
		Scanner fileScanner = null;
		
		try {
//			URL url = getClass().getResource(fileName); // gets the absolute path of the file
//			File inputFile = new File(url.getPath()); // creates a File object with the given path
			File inputFile = new File(fileName);
			fileScanner = new Scanner(inputFile);
			
			
			
			if (fileName.equals(UserUtilities.USERS_FILE)) {
				ArrayList<User> userList = new ArrayList<>();
				
				while (fileScanner.hasNextLine()) {
					String[] userDetails = fileScanner.nextLine().split(",") ;
					User user = new User(Integer.parseInt(userDetails[0].trim()), userDetails[1].trim(),userDetails[2].trim(), 
							Integer.parseInt(userDetails[3].trim()), userDetails[4].trim(),userDetails[5].trim(),userDetails[6].trim());
					userList.add(user); //appends the user and his details as a new line into the array list userList
				} // end of while
				return userList;
				
			}
			else if (fileName.equals(ProductUtilities.PRODUCTS_FILE)) {
				ArrayList<Product> productList = new ArrayList<>();
				
				while (fileScanner.hasNextLine()) {
					String[] productDetails = fileScanner.nextLine().split(",") ;
					Product product = new Product(Integer.parseInt(productDetails[0].trim()), productDetails[1].trim(),productDetails[2].trim(), 
							productDetails[3].trim(), productDetails[4].trim(),productDetails[5].trim(), Integer.parseInt(productDetails[6].trim()),
							Double.parseDouble(productDetails[7].trim()), Double.parseDouble(productDetails[8].trim()), productDetails[9].trim());
					productList.add(product); //appends the user and his details as a new line into the array list userList		
				} // end of while
				return productList;
			} 
			
			
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			fileScanner.close();
			
		} return null;

	} 
	

}
