import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Admin extends JFrame {

	
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Welcome, " + Main.name + "!");
	private JTable table;
	static JTextField IDField;
	static JTextField NameField;
	static JTextField TypeField;
	static JTextField BrandField;
	static JTextField ColourField;
	static JTextField ConnectivityField;
	static JTextField InfoField;
	static JTextField QuantityField;
	static JTextField CostField;
	static JTextField RPriceField;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Admin() {
		setTitle("Computer Accessories Shop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1007, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Add Product");
		internalFrame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		internalFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		internalFrame.setClosable(true);
		internalFrame.setBounds(12, 335, 912, 330);
		contentPane.add(internalFrame);
		internalFrame.show();
		internalFrame.getContentPane().setLayout(null);

		JLabel lblPleaseFillOut = new JLabel("Please fill out all boxes before submitting.");
		lblPleaseFillOut.setBounds(607, 103, 312, 14);
		internalFrame.getContentPane().add(lblPleaseFillOut);

		IDField = new JTextField();
		IDField.setBounds(32, 54, 86, 20);
		internalFrame.getContentPane().add(IDField);
		IDField.setColumns(10);

		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductId.setBounds(44, 29, 74, 14);
		internalFrame.getContentPane().add(lblProductId);

		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(32, 127, 86, 20);
		internalFrame.getContentPane().add(NameField);

		TypeField = new JTextField();
		TypeField.setColumns(10);
		TypeField.setBounds(32, 197, 86, 20);
		internalFrame.getContentPane().add(TypeField);

		BrandField = new JTextField();
		BrandField.setColumns(10);
		BrandField.setBounds(178, 54, 86, 20);
		internalFrame.getContentPane().add(BrandField);

		ColourField = new JTextField();
		ColourField.setColumns(10);
		ColourField.setBounds(178, 127, 86, 20);
		internalFrame.getContentPane().add(ColourField);

		ConnectivityField = new JTextField();
		ConnectivityField.setColumns(10);
		ConnectivityField.setBounds(178, 197, 86, 20);
		internalFrame.getContentPane().add(ConnectivityField);

		InfoField = new JTextField();
		InfoField.setColumns(10);
		InfoField.setBounds(450, 127, 86, 20);
		internalFrame.getContentPane().add(InfoField);

		QuantityField = new JTextField();
		QuantityField.setColumns(10);
		QuantityField.setBounds(316, 54, 86, 20);
		internalFrame.getContentPane().add(QuantityField);

		CostField = new JTextField();
		CostField.setColumns(10);
		CostField.setBounds(316, 127, 86, 20);
		internalFrame.getContentPane().add(CostField);

		RPriceField = new JTextField();
		RPriceField.setColumns(10);
		RPriceField.setBounds(316, 197, 86, 20);
		internalFrame.getContentPane().add(RPriceField);

		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblType.setBounds(59, 172, 46, 14);
		internalFrame.getContentPane().add(lblType);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(59, 102, 46, 14);
		internalFrame.getContentPane().add(lblName);

		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrand.setBounds(198, 29, 46, 14);
		internalFrame.getContentPane().add(lblBrand);

		JLabel lblColour = new JLabel("Colour:");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblColour.setBounds(198, 102, 46, 14);
		internalFrame.getContentPane().add(lblColour);

		JLabel lblConnectivity = new JLabel("Connectivity:");
		lblConnectivity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConnectivity.setBounds(190, 172, 86, 14);
		internalFrame.getContentPane().add(lblConnectivity);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(327, 29, 86, 14);
		internalFrame.getContentPane().add(lblQuantity);

		JLabel lblOriginalCost = new JLabel("Original Cost:");
		lblOriginalCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOriginalCost.setBounds(328, 102, 74, 14);
		internalFrame.getContentPane().add(lblOriginalCost);

		JLabel lblRetailPrice = new JLabel("Retail Price:");
		lblRetailPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRetailPrice.setBounds(333, 172, 69, 14);
		internalFrame.getContentPane().add(lblRetailPrice);

		JLabel lblAdditionalInformation = new JLabel("Additional ");
		lblAdditionalInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdditionalInformation.setBounds(462, 78, 68, 35);
		internalFrame.getContentPane().add(lblAdditionalInformation);

		JLabel lblInformation = new JLabel("Information:");
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInformation.setBounds(462, 102, 104, 14);
		internalFrame.getContentPane().add(lblInformation);

		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int ID = Integer.parseInt(IDField.getText().toString());
					int quantity = Integer.parseInt(QuantityField.getText().toString());
					double originalCost = Double.parseDouble(CostField.getText().toString());
					double retailPrice = Double.parseDouble(RPriceField.getText().toString());
					WriteToFile.writeToFile("Stock.txt", "");
					Customer.message = "Product added successfully.";
					new PopupMessage().setVisible(true);
				} catch (Exception e2) {
					Customer.message = "Please enter valid values.";
					new PopupMessage().setVisible(true);
				}
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddProduct.setBounds(144, 249, 152, 23);
		internalFrame.getContentPane().add(btnAddProduct);

		JLabel lblInstructions = new JLabel("Instructions:");
		lblInstructions.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInstructions.setBounds(679, 67, 104, 14);
		internalFrame.getContentPane().add(lblInstructions);

		JLabel lblIntegerValuesShould = new JLabel("Integer values should be entered for ID and Quantity.");
		lblIntegerValuesShould.setBounds(586, 126, 317, 23);
		internalFrame.getContentPane().add(lblIntegerValuesShould);

		JLabel lblNumericValuesShould = new JLabel("Numeric values should be entered for Cost and Price.");
		lblNumericValuesShould.setBounds(586, 147, 333, 14);
		internalFrame.getContentPane().add(lblNumericValuesShould);

		JLabel lblIncorrectInformationWill = new JLabel("Incorrect submission will not result in any change.");
		lblIncorrectInformationWill.setBounds(586, 186, 297, 14);
		internalFrame.getContentPane().add(lblIncorrectInformationWill);

		JLabel lblRefreshToSee = new JLabel("Refresh to see applied changes.");
		lblRefreshToSee.setBounds(625, 200, 258, 14);
		internalFrame.getContentPane().add(lblRefreshToSee);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 11, 154, 33);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(12, 55, 920, 200);
		contentPane.add(scrollPane);

		ArrayList<Product> prodInfo = ProductUtilities.readProductsFromFile();
		String[][] productInfo = ProductUtilities.convertTo2DArray(prodInfo, "admin");
		String[] column = { "Product ID", "Product Name", "Type", "Brand", "Colour", "Connectivity", "Quantity",
				"Original Cost", "Retail Price", "Information" };
		table = new JTable(productInfo, column);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowSelectionAllowed(true);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btnRefresh.setBounds(12, 266, 89, 23);
		contentPane.add(btnRefresh);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
