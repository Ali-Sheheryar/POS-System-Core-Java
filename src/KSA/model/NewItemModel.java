package KSA.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import KSA.dbconnection.DbConnection;
import KSA.dto.StockDTO;

public class NewItemModel {
	Connection connection = DbConnection.getConnection();

	public void insertProduct(StockDTO stockDTO, String dateString) {

		double partQuantity = stockDTO.getQuantity();
		double price = stockDTO.getUnitPrice();
		double totalPrice = stockDTO.getTotalValue();
		if (isValidInput(partQuantity, price, totalPrice)) {
			try {
//				String storedProcedureCall = "{call PostProducts(?, ?, ?, ?, ?, ?)}"; //recommended to use
//	            CallableStatement pst = connection.prepareCall(storedProcedureCall);
				
//Inline Query is provided to give you a better insight
				PreparedStatement pst = connection.prepareStatement(
						"INSERT INTO products (sr_no, p_name, quantity, price, total_price, date) VALUES (?, ?, ?, ?, ?, ?)");
				pst.setInt(1, stockDTO.getSrNo());
				pst.setString(2, stockDTO.getPartName());
				pst.setDouble(3, stockDTO.getQuantity());
				pst.setDouble(4, stockDTO.getUnitPrice());
				pst.setDouble(5, stockDTO.getTotalValue());
				pst.setString(6, dateString);
				pst.executeUpdate();
			} catch (SQLException e) {
				handleSQLException(e);
			}
		}
	}

	public boolean isValidInput(double partQuantity, double price, double totalPrice) {
		try {

			if (partQuantity <= 0 || price <= 0 || totalPrice <= 0) {
				throw new IllegalArgumentException("Numeric fields cannot be zero or negative.");
			}
		} catch (IllegalArgumentException e) {
			handleValidationException("Invalid numeric input. Please enter valid numbers.");
			return false;
		}
		return true;
	}

	public int autoIncrProductNo() {
		int invNo = 0;
		try {
//			String storedProcedureCall = "{call GetMaxSrNoProduct()}"; 
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT MAX(sr_no) FROM products");
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				invNo = rs.getInt(1);
				if (invNo == 0) {
					invNo = 1;
				} else {
					invNo++;
				}
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}
		return invNo;
	}

	public boolean validateProduct(StockDTO stockDTO) {
		try {
//			String storedProcedureCall = "{call GetProductsByName(?)}";
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM products WHERE p_name = ?");
			pst.setString(1, stockDTO.getPartName());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Product already exist.");
				return true;
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}
		return false;
	}

	private void handleValidationException(String message) {
		System.out.println("Validation Error: " + message);
	}

	public String calculateTotal(double partQuantity, double price, double taxVAT) {
		try {
			double totalPrice = (partQuantity * price);
			totalPrice = (totalPrice + (totalPrice * (taxVAT / 100)));
			return String.format("%.2f", totalPrice);
		} catch (NumberFormatException e) {
			handleValidationException("Invalid numeric input. Please enter valid numbers.");
			return "";
		}
	}

	private void handleSQLException(SQLException e) {
		e.printStackTrace();
	}

}
