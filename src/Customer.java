import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Customer extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Welcome, " + Main.name + "!");
	private JTable table;
	private JTextField productIDField;
	static ArrayList<Product> prodInfo = ProductUtilities.readProductsFromFile();
	static String[][] productInfo = ProductUtilities.convertTo2DArray(prodInfo, "customer");
	static String[][] basket = new String[productInfo.length][4];
	static String paymentMethod;
	static int userID = Main.userID;
	static String postcode = Main.postcode;
	static String barcode1;
	static int barcode;
	static double retailPrice;
	static int quantity;
	int basketIndex;
	double totalAmount;
	static double finalAmount;
	static String status;
	static String message;

	private JTextField quantityField;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Customer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Computer Accessories Shop");
		setBounds(100, 100, 1352, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 11, 154, 33);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 58, 912, 234);
		contentPane.add(scrollPane);

		ArrayList<Product> prodInfo = ProductUtilities.readProductsFromFile();
		String[][] productInfo = ProductUtilities.convertTo2DArray(prodInfo, "customer");
		String[] column = { "Product ID", "Product Name", "Type", "Brand", "Colour", "Connectivity", "Quantity",
				"Retail Price", "Information" };
		table = new JTable(productInfo, column);
		scrollPane.setViewportView(table);

		JButton btnRefresh = new JButton("Refresh Item List");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ArrayList<Product> prodInfo = ProductUtilities.readProductsFromFile();
				String[][] productInfo = ProductUtilities.convertTo2DArray(prodInfo, "admin");
				String[] column = { "Product ID", "Product Name", "Type", "Brand", "Colour", "Connectivity", "Quantity",
						"Original Cost", "Retail Price", "Information" };
				table = new JTable(productInfo, column);
				table.setFont(new Font("Tahoma", Font.PLAIN, 12));
				table.setRowSelectionAllowed(true);
				ListSelectionModel cellSelectionModel = table.getSelectionModel();
				cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
			}
		});

		JInternalFrame internalFrame = new JInternalFrame("Add Item To Basket");
		internalFrame.setBounds(10, 343, 914, 190);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JLabel lblRefreshBasketTo = new JLabel("Refresh Basket to see applied changes.");
		lblRefreshBasketTo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRefreshBasketTo.setBounds(555, 116, 203, 23);
		internalFrame.getContentPane().add(lblRefreshBasketTo);

		JLabel lblEnterTheProduct = new JLabel(
				"Enter the Product ID and quantity of the product you wish to add to your basket.");
		lblEnterTheProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEnterTheProduct.setBounds(10, 11, 602, 14);
		internalFrame.getContentPane().add(lblEnterTheProduct);

		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setBounds(144, 52, 80, 30);
		internalFrame.getContentPane().add(lblProductId);
		lblProductId.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnAddToBasket = new JButton("Add To Basket");
		btnAddToBasket.setBounds(234, 115, 149, 23);
		internalFrame.getContentPane().add(btnAddToBasket);
		btnAddToBasket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Product> prodInfo = ProductUtilities.readProductsFromFile();
				String[][] productInfo = ProductUtilities.convertTo2DArray(prodInfo, "customer");
				try {
					quantity = Integer.parseInt(quantityField.getText().toString());
					barcode = Integer.parseInt(productIDField.getText().toString());
					barcode1 = productIDField.getText().toString();

					for (int i = 0; i < productInfo.length; i++) {
						if (productInfo[i][0].equals(barcode1)) {
							if (quantity > Integer.parseInt(productInfo[i][6])) {
								message = "Please enter valid values.";
								new PopupMessage().setVisible(true);
								break;
							} else {
								for (int j = 0; j < basket.length; j++) {
									if (barcode1.equals(basket[j][0])) {
										String previousQuant = basket[j][3];
										int prevQ = Integer.parseInt(previousQuant);
										int newQuantity = prevQ + quantity;
										if (newQuantity > Integer.parseInt(productInfo[i][6])) {
											new PopupMessage().setVisible(true);
											break;
										} else {
											basket[j][3] = String.valueOf(newQuantity);
											double itemPrice = Double.parseDouble(basket[j][2]);
											totalAmount += (itemPrice) * quantity;
											new PopupMessage().setVisible(true);
											break;
										}
									} else if (j == basket.length - 1) {
										basket[basketIndex][0] = productInfo[i][0];
										basket[basketIndex][1] = productInfo[i][1];
										basket[basketIndex][2] = productInfo[i][7];
										double itemPrice = Double.parseDouble(basket[basketIndex][2]);
										totalAmount += (itemPrice) * quantity;
										basket[basketIndex][3] = String.valueOf(quantity);
										basketIndex++;
										message = "Item added successfully.";
										new PopupMessage().setVisible(true);
										break;
									}
								}
							}
							break;
						}
					}

				} catch (NumberFormatException e2) {
					message = "Please enter valid values.";
					new PopupMessage().setVisible(true);
				}

			}
		});

		btnAddToBasket.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(144, 67, 63, 54);
		internalFrame.getContentPane().add(lblQuantity);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblIdAndQuantity = new JLabel("ID and Quantity should be integer values.");
		lblIdAndQuantity.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdAndQuantity.setBounds(555, 36, 233, 30);
		internalFrame.getContentPane().add(lblIdAndQuantity);

		JLabel lblotherwiseTheProduct = new JLabel("The product will not be added to the basket if otherwise.");
		lblotherwiseTheProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblotherwiseTheProduct.setBounds(504, 93, 356, 23);
		internalFrame.getContentPane().add(lblotherwiseTheProduct);

		productIDField = new JTextField();
		productIDField.setBounds(237, 52, 146, 20);
		internalFrame.getContentPane().add(productIDField);
		productIDField.setColumns(10);

		quantityField = new JTextField();
		quantityField.setBounds(238, 79, 86, 20);
		internalFrame.getContentPane().add(quantityField);
		quantityField.setColumns(10);

		JLabel lblInstructions = new JLabel("Instructions:");
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInstructions.setBounds(601, 21, 165, 14);
		internalFrame.getContentPane().add(lblInstructions);

		JLabel lblTheDesiredQuantity = new JLabel("The desired quantity should not be more than the one in stock.");
		lblTheDesiredQuantity.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTheDesiredQuantity.setBounds(491, 67, 382, 23);
		internalFrame.getContentPane().add(lblTheDesiredQuantity);
		internalFrame.setVisible(true);

		JInternalFrame internalFrame_1 = new JInternalFrame("Basket");
		internalFrame_1.setBounds(961, 58, 365, 234);
		contentPane.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 349, 204);
		internalFrame_1.getContentPane().add(scrollPane_1);

		String[] column1 = { "Product ID", "Type", "Cost", "Quantity" };
		table_1 = new JTable(basket, column1);
		table_1.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(table_1);
		internalFrame_1.setVisible(true);
		btnRefresh.setBounds(12, 297, 175, 23);
		contentPane.add(btnRefresh);

		JButton btnRefreshBasket = new JButton("Refresh Basket");
		btnRefreshBasket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_1 = new JTable(basket, column1);
				table_1.setFillsViewportHeight(true);
				scrollPane_1.setViewportView(table_1);
				internalFrame_1.setVisible(true);

			}
		});
		btnRefreshBasket.setBounds(961, 320, 154, 23);
		contentPane.add(btnRefreshBasket);

		JButton btnCancelOrder = new JButton("Cancel Order");
		btnCancelOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				status = "cancelled";
				String method = "no payment";
				WriteToFile.writeToFile("ActivityLog.txt", method);
				basketIndex = 0;
				message = "Order has been cancelled.";
				new PopupMessage().setVisible(true);

			}
		});
		btnCancelOrder.setBounds(1172, 385, 154, 23);
		contentPane.add(btnCancelOrder);

		JButton btnNewButton_1 = new JButton("Pay via Credit Card");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				status = "purchased";
				finalAmount = totalAmount;
				new CreditCardFrame().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1172, 320, 154, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Pay via PayPal");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				status = "purchased";
				finalAmount = totalAmount;
				new PayPal().setVisible(true);
			}
		});
		btnNewButton.setBounds(1172, 351, 154, 23);
		contentPane.add(btnNewButton);

	}
}