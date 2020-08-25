import java.util.ArrayList;

public class ProductUtilities {

	public static final String PRODUCTS_FILE = "Stock.txt";
	
	public static ArrayList<Product> readProductsFromFile() {
		ArrayList<Product> productList;
		// Create an object from ReadingFromFile class
		ReadFromFile rff = new ReadFromFile(PRODUCTS_FILE);
		// Call readFile method which reads the file and add data to userList array
		productList = (ArrayList<Product>) rff.readFile();		
		return productList;
	}
	
	public static String[][] convertTo2DArray(ArrayList <Product> productList, String userType){
		
		String [][] prodInfo = new String [productList.size()][10];
		
		if (userType.equals("customer")){
			for (int i=0; i<productList.size(); i++) {
				prodInfo[i][0] = String.valueOf(productList.get(i).getBarcode());
				prodInfo[i][1] = productList.get(i).getName();
				prodInfo[i][2] = productList.get(i).getType();
				prodInfo[i][3] = productList.get(i).getBrand();
				prodInfo[i][4] = productList.get(i).getColour();
				prodInfo[i][5] = productList.get(i).getConnectivity();
				prodInfo[i][6] = String.valueOf(productList.get(i).getQuantity());
				prodInfo[i][7] = String.valueOf(productList.get(i).getRetailPrice());
				prodInfo[i][8] = productList.get(i).getAdditionalInfo();
			
			}
		} else {
			for (int i=0; i<productList.size(); i++) {
				prodInfo[i][0] = String.valueOf(productList.get(i).getBarcode());
				prodInfo[i][1] = productList.get(i).getName();
				prodInfo[i][2] = productList.get(i).getType();
				prodInfo[i][3] = productList.get(i).getBrand();
				prodInfo[i][4] = productList.get(i).getColour();
				prodInfo[i][5] = productList.get(i).getConnectivity();
				prodInfo[i][6] = String.valueOf(productList.get(i).getQuantity());
				prodInfo[i][7] = String.valueOf(productList.get(i).getOriginalCost());
				prodInfo[i][8] = String.valueOf(productList.get(i).getRetailPrice());
				prodInfo[i][9] = productList.get(i).getAdditionalInfo();

		} 
	} return prodInfo;
		
	}
}