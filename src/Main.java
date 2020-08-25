

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
		
	private static ArrayList<User> users;

	static String name;
	static int userID;
	static String postcode;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		users = UserUtilities.readUsersFromFile();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Computer Accessories Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
				
		
		JButton btnNewButton = new JButton(users.get(0).getSurname());
		btnNewButton.setBounds(43, 27, 109, 68);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userID = users.get(0).getId();
				name = users.get(0).getSurname();
				postcode = users.get(0).getPostcode();
				UserUtilities.authorizeUser(users.get(0));
				
				
			}

		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnUser = new JButton(users.get(1).getSurname());
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userID = users.get(1).getId();
				name = users.get(1).getSurname();
				postcode = users.get(1).getPostcode();
				UserUtilities.authorizeUser(users.get(1));;
				
			}

		});
		btnUser.setBounds(43, 107, 110, 68);
		contentPane.add(btnUser);
		
		JButton btnUser_1 = new JButton(users.get(2).getSurname());
		btnUser_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userID = users.get(2).getId();
				name = users.get(2).getSurname();
				postcode = users.get(2).getPostcode();
				UserUtilities.authorizeUser(users.get(2));
				
				
			}
		});
		btnUser_1.setBounds(43, 187, 110, 68);
		contentPane.add(btnUser_1);
		
		JButton btnUser_2 = new JButton(users.get(3).getSurname());
		btnUser_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userID = users.get(3).getId();
				name = users.get(3).getSurname();
				postcode = users.get(3).getPostcode();
				UserUtilities.authorizeUser(users.get(3));
				
				
			}

		});
		btnUser_2.setBounds(43, 267, 109, 66);
		contentPane.add(btnUser_2);
		
		JLabel lblPleaseSelectYour = new JLabel("Please select your account to log in.");
		lblPleaseSelectYour.setBounds(207, 144, 304, 68);
		contentPane.add(lblPleaseSelectYour);
	}
}
