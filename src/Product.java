

public class Product {
	
	int barcode;
	String name;
	String type;
	String brand;
	String colour;
	String connectivity;
	int quantity;
	double originalCost;
	double retailPrice;
	String additionalInfo;
	
	public Product(int barcode, String name, String type, String brand, String colour, String connectivity, int quantity,
			double originalCost, double retailPrice, String additionalInfo) {
		this.barcode = barcode;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.quantity = quantity;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
		this.additionalInfo = additionalInfo;
	}

	public int getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public String getColour() {
		return colour;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getOriginalCost() {
		return originalCost;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

}
