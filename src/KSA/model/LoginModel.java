package KSA.model; // Replace com.yourpackage with your actual package name

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import KSA.dbconnection.DbConnection;
import KSA.dto.UserDTO;

public class LoginModel {

	Connection connection = DbConnection.getConnection();

	public boolean authenticateUser(UserDTO userDTO) {
		boolean authenticateUser = false;
		try {
//			String storedProcedureCall = "{call GetUserByCredentials(?, ?)}"; //recommended to use
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			
//Inline Query is provided to give you a better insight
			PreparedStatement pst = connection
					.prepareStatement("SELECT email, pass FROM user WHERE email = ? AND pass = ?");
			pst.setString(1, userDTO.getUsername());
			pst.setString(2, userDTO.getPassword());
			ResultSet rs = pst.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
			return authenticateUser;
		}
	}

}
