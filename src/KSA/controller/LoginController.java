package KSA.controller;

import javax.swing.JOptionPane;

import KSA.dto.UserDTO;
import KSA.model.LoginModel;

public class LoginController {
	private LoginModel loginModel = new LoginModel();

	public boolean isValidInput(UserDTO userDTO) {
		if (userDTO.getUsername().isEmpty() || userDTO.getPassword().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username and Password are required fields.");
			return false;
		}
		return true;
	}

	public boolean authenticateUser(UserDTO userDTO) { // validate here instead of model and controllers
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username and Password are required fields.");
			return false;
		}
		return loginModel.authenticateUser(userDTO);
	}
}
