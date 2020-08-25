import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;

public class WriteToFile {
	
	private String fileName;
  
	public static void writeToFile(String fileName, String method){
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter((fileName), true));
			fw = new FileWriter(fileName);
			
			if (fileName.equals(ProductUtilities.PRODUCTS_FILE)){ // updates the stock file
				
				// get all values from user input
				String ID = Admin.IDField.getText().toString();
				String name = Admin.NameField.getText().toString();
				String type = Admin.TypeField.getText().toString();
				String brand = Admin.BrandField.getText().toString();
				String colour = Admin.ColourField.getText().toString();
				String connectivity = Admin.ConnectivityField.getText().toString();
				String quantity = Admin.QuantityField.getText().toString();
				String originalCost = Admin.CostField.getText().toString();
				String retailPrice = Admin.RPriceField.getText().toString();
				String info = Admin.InfoField.getText().toString();
				
				bw.write("\n");
				bw.write(ID + ", " + name + ", " + type + ", " + brand + ", " + 
						colour + ", " + connectivity + ", " + quantity + ", " + 
						originalCost + ", " + retailPrice + ", " + info);
						
			} 
//				else if (method.equals("payment")){
//
//				ArrayList<Product> allProducts = ProductUtilities.readProductsFromFile();
//				String [][] prods = ProductUtilities.convertTo2DArray(allProducts, "customer");
//				String [][] basket = CustomerFrame.basket;
//				
//				for (int i =0; i<basket.length; i++){
//					for (int j=0; j<prods.length; j++){
//						if (prods[i][0] == basket[j][0]){
//							int originalQuantity = Integer.parseInt(prods[i][6]);
//							int purchased = Integer.parseInt(basket[i][3]);
//							int newQuantity = originalQuantity - purchased;
//							prods[i][6] = String.valueOf(newQuantity);
//						}
//					}
//				}
//				for (int k =0; k<basket.length; k++){
//					for (int m =0; m<10; m++){
//						fw.write(prods[k][m]);
//					}
//					fw.write("\n");
//				}
//				
//			}

			
			else if (fileName.equals("ActivityLog.txt")){ // updates the activity log file
				
				String order[][] = Customer.basket;
				
				for (int i=0; i<Customer.basket.length; i++){
					String userID = String.valueOf(Customer.userID);
					String postcode = Main.postcode;
					String barcode = order[i][0];
					String retailPrice = order[i][2];
					String quantity = order[i][3];
					String paymentMethod = method;
					String status = Customer.status;
					LocalDate ldObj = LocalDate.now();
					String date = String.valueOf(ldObj);
					
					if (barcode == null){
						break;
					}
				
				bw.write(userID + ", " + postcode + ", " + barcode + ", " + retailPrice + ", " + 
						paymentMethod + ", " + status + ", " + date);
				bw.write("\n");
				
				}
				if (Customer.status == "cancelled"){
					for (int i = 0; i < order.length; i++){
						for (int j =0; j<4; j++){
							order[i][j] = "";
						}
					}
				}
				
			}
			
		    bw.close();
		      
      
      
    } catch (IOException e) {
    	e.printStackTrace();
    	System.out.println(e.getMessage());
    }
  }
}