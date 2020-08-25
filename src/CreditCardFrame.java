import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreditCardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCardNum;
	private JTextField txxSecurityCode;

	double totalAmount = Customer.finalAmount;
	static String method;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditCardFrame frame = new CreditCardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreditCardFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number:");
		lblCreditCardNumber.setBounds(34, 96, 146, 21);
		contentPane.add(lblCreditCardNumber);
		
		txtCardNum = new JTextField();
		txtCardNum.setText("xxxx-xxxx-xxxx-xxxx");
		txtCardNum.setBounds(152, 96, 272, 20);
		contentPane.add(txtCardNum);
		txtCardNum.setColumns(10);
		
		JLabel lblSecurityCode = new JLabel("Security Code:");
		lblSecurityCode.setBounds(34, 138, 112, 14);
		contentPane.add(lblSecurityCode);
		
		txxSecurityCode = new JTextField();
		txxSecurityCode.setText("xxx");
		txxSecurityCode.setBounds(152, 135, 96, 20);
		contentPane.add(txxSecurityCode);
		txxSecurityCode.setColumns(10);
		
		
		
		JLabel lblTotal = new JLabel("Total Amount:        " + totalAmount);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(32, 59, 230, 14);
		contentPane.add(lblTotal);
		
		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				method = "Credit Card";
				WriteToFile.writeToFile("ActivityLog.txt", method);
				Customer.paymentMethod = method;
				Customer.message = ("Amount Paid via Credit Card: " + totalAmount);
				new PopupMessage().setVisible(true);;
			}
		});
		btnPayNow.setBounds(152, 175, 89, 23);
		contentPane.add(btnPayNow);
	}
}
