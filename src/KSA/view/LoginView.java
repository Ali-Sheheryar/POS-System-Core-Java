package KSA.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import KSA.controller.LoginController;
import KSA.dto.UserDTO;

public class LoginView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7621372519923079874L;
	private JFormattedTextField txtUsername = new JFormattedTextField();
	private JPasswordField txtPassword = new JPasswordField();
	private LoginController loginController = new LoginController();
	private boolean b;

	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java-WorkSpace\\KSA\\src\\icon\\iconWindow.jpg"));
		setTitle("YOUR SHOP");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		JPanel panel_main = new JPanel();
		panel_main.setBackground(new Color(255, 255, 255));
		panel_main.setBounds(0, 0, 688, 712);
		getContentPane().add(panel_main);
		panel_main.setLayout(null);

		JLabel lblMain1 = new JLabel("YOUR");
		lblMain1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain1.setForeground(new Color(0, 204, 102));
		lblMain1.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblMain1.setBounds(123, 86, 442, 355);
		panel_main.add(lblMain1);

		JLabel lblMain2 = new JLabel("SHOP");
		lblMain2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain2.setForeground(new Color(0, 204, 102));
		lblMain2.setFont(new Font("Times New Roman", Font.BOLD, 99));
		lblMain2.setBounds(123, 226, 442, 355);
		panel_main.add(lblMain2);

		JPanel panel_login = new JPanel();
		panel_login.setBackground(new Color(0, 204, 102));
		panel_login.setBounds(678, 0, 688, 712);
		getContentPane().add(panel_login);
		panel_login.setLayout(null);

		JLabel lbllogin = new JLabel("Login Here");
		lbllogin.setVerticalAlignment(SwingConstants.TOP);
		lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogin.setForeground(Color.WHITE);
		lbllogin.setFont(new Font("Segoe UI", Font.PLAIN, 32));
		lbllogin.setBounds(146, 226, 391, 42);
		panel_login.add(lbllogin);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setVerticalAlignment(SwingConstants.TOP);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblUsername.setBounds(174, 282, 130, 18);
		panel_login.add(lblUsername);

		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtUsername.setBounds(174, 311, 336, 28);
		panel_login.add(txtUsername);

		JLabel lblUsername_1 = new JLabel("___________________________________________________________________");
		lblUsername_1.setVerticalAlignment(SwingConstants.TOP);
		lblUsername_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1.setForeground(Color.WHITE);
		lblUsername_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblUsername_1.setBounds(174, 333, 336, 18);
		panel_login.add(lblUsername_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setVerticalAlignment(SwingConstants.TOP);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPassword.setBounds(174, 358, 130, 18);
		panel_login.add(lblPassword);

		JLabel lblUsername_1_2 = new JLabel("___________________________________________________________________");
		lblUsername_1_2.setVerticalAlignment(SwingConstants.TOP);
		lblUsername_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername_1_2.setForeground(Color.WHITE);
		lblUsername_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblUsername_1_2.setBounds(174, 409, 336, 18);
		panel_login.add(lblUsername_1_2);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDTO userDTO = new UserDTO();
				userDTO.setUsername(getUsername());
				userDTO.setPassword(getPassword());
				if (loginController.isValidInput(userDTO)) {
					boolean isAuthenticated = loginController.authenticateUser(userDTO);

					if (isAuthenticated) {
						showLoginResult(true);
					} else {
						showLoginResult(false);
					}
				}
			}
		});
		btnLogin.setForeground(new Color(0, 204, 102));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(174, 454, 177, 42);
		panel_login.add(btnLogin);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setBounds(174, 387, 336, 28);
		panel_login.add(txtPassword);

		JLabel lbl = new JLabel("");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setIcon(new ImageIcon("E:\\Java SWING\\LoginForm\\src\\icon\\icons8_user_20px_1.png"));
		lbl.setBounds(520, 311, 30, 28);
		panel_login.add(lbl);

		JLabel lbl_1 = new JLabel("");
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1.setIcon(new ImageIcon("E:\\Java SWING\\LoginForm\\src\\icon\\icons8_invisible_20px_1.png"));
		lbl_1.setBounds(520, 387, 30, 28);
		panel_login.add(lbl_1);

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnReset.setForeground(new Color(0, 204, 102));
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setBackground(Color.WHITE);
		btnReset.setBounds(353, 454, 157, 42);
		panel_login.add(btnReset);
	}

	public String getUsername() {
		return txtUsername.getText();
	}

	public String getPassword() {
		return new String(txtPassword.getPassword());
	}

	public void showLoginResult(boolean success) {
		if (success) {
			HomeView home = new HomeView();
			LoginView.this.setVisible(false);
			home.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "Login Failed. Please check your credentials.");
		}
	}

	public void clearFields() {
		txtUsername.setText("");
		txtPassword.setText("");
	}

	public boolean getflag() {
		return b;
	}
}
