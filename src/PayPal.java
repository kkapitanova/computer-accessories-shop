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

public class PayPal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	double totalAmount = Customer.finalAmount;
	static String method;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayPal frame = new PayPal();
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
	public PayPal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPaypalEmail = new JLabel("PayPal Email: ");
		lblPaypalEmail.setBounds(33, 119, 135, 14);
		contentPane.add(lblPaypalEmail);

		textField = new JTextField();
		textField.setBounds(140, 116, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("Total Amount:     " + totalAmount);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(32, 80, 185, 14);
		contentPane.add(label);

		JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				method = "PayPal";
				WriteToFile.writeToFile("ActivityLog.txt", method);
				Customer.paymentMethod = method;
				Customer.message = ("Amount Paid via PayPal: " + totalAmount);
				new PopupMessage().setVisible(true);
			}
		});
		btnPayNow.setBounds(186, 163, 89, 23);
		contentPane.add(btnPayNow);
	}

}
