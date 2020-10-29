package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JLabel user_label, password_label, message, phone_label;
	JTextField userName_text, phone_text;
	JPasswordField password_text;
	JButton submit, cancel;
	MenuView bill;

	public SignUp(JFrame jFrame, boolean modal) {
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		bill = (MenuView) jFrame;
		addControl();
		addEvent();
	}

	private void addControl() {
		// User Label
		user_label = new JLabel();
		user_label.setText("User Name :");
		userName_text = new JTextField();

		// Password
		password_label = new JLabel();
		password_label.setText("Password :");
		password_text = new JPasswordField();
		
		// phone number
		phone_label = new JLabel();
		phone_label.setText("Phone number :");
		phone_text = new JTextField();
		
		// Submit

		submit = new JButton("SUBMIT");

		panel = new JPanel(new GridLayout(4, 1));

		panel.add(user_label);
		panel.add(userName_text);
		panel.add(password_label);
		panel.add(password_text);
		panel.add(phone_label);
		panel.add(phone_text);

		message = new JLabel();
		panel.add(message);
		panel.add(submit);

		getContentPane().add(panel, BorderLayout.CENTER);
		setTitle("Please Login Here !");
		setSize(269, 183);
		setVisible(true);
	}

	private void addEvent() {
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userName_text.getText();
				@SuppressWarnings("deprecation")
				String password = password_text.getText();
				if (userName.trim().equals("admin") && password.trim().equals("admin")) {
					message.setText(" Hello " + userName + "");
				} else {
					message.setText(" Invalid user.. ");
				}

			}
		});
	}
}
