package KSA.model;

//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import KSA.dbconnection.DbConnection;
import KSA.dto.StockDTO;

public class StockModel {
	Connection connection = DbConnection.getConnection();

	public List<StockDTO> filterDataByMonth(String selectedMonth, int selectedMonthIndex) {

		List<StockDTO> stockList = new ArrayList<>();
		try {
//			String storedProcedureCall = "{call GetProductsByMonth(?)}"; //recommended to use
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			
//Inline Query is provided to give you a better insight
			PreparedStatement pst = connection 
					.prepareStatement("SELECT * FROM products WHERE MONTH(STR_TO_DATE(date, '%d-%m-%Y')) = ?");
			pst.setInt(1, selectedMonthIndex); // Set the parameter value

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StockDTO stockDTO = new StockDTO();
				stockDTO.setSrNo(rs.getInt("sr_no"));
				stockDTO.setPartName(rs.getString("p_name"));
				stockDTO.setQuantity(rs.getDouble("quantity"));
				stockDTO.setUnitPrice(rs.getDouble("price"));
				stockDTO.setTotalValue(rs.getDouble("total_price"));
				stockDTO.setDateString(rs.getString("date"));
				stockList.add(stockDTO);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return stockList;
	}

	public List<StockDTO> showProductData() {
		List<StockDTO> stockList = new ArrayList<>();
		try {
//			String storedProcedureCall = "{call GetAllProducts()}";
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM products");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StockDTO stockDTO = new StockDTO();
				stockDTO.setSrNo(rs.getInt("sr_no"));
				stockDTO.setPartName(rs.getString("p_name"));
				stockDTO.setQuantity(rs.getDouble("quantity"));
				stockDTO.setUnitPrice(rs.getDouble("price"));
				stockDTO.setTotalValue(rs.getDouble("total_price"));
				stockDTO.setDateString(rs.getString("date"));
				stockList.add(stockDTO);
			}
		} catch (SQLException ex) {
			// ex.printStackTrace();
		}
		return stockList;
	}

	public void updateProduct(double newTax, int selectedRow, int srNo, StockDTO stockDTO) {
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a record");
			return;
		}

		double newUnitPrice = stockDTO.getUnitPrice();
		double newQuantity = stockDTO.getQuantity();
		double newTotalPrice = stockDTO.getTotalValue();
		String dateString = stockDTO.getDateString();

		try {
//			String storedProcedureCall = "{call GetProductsQuantityAndPriceByID(?)}";
//          CallableStatement selectPst = connection.prepareCall(storedProcedureCall);
//			String storedProcedureCall = "{call SetProductsQuantityAndPriceByID(?,?,?,?,?)}";
//          CallableStatement updatePst = connection.prepareCall(storedProcedureCall);			
			PreparedStatement selectPst = connection.prepareStatement("SELECT quantity, price, total_price FROM products WHERE sr_no = ?");
			PreparedStatement updatePst = connection.prepareStatement("UPDATE products SET quantity=?, price=?, total_price=?, date=? WHERE sr_no = ?");
			selectPst.setInt(1, srNo);
			ResultSet rs = selectPst.executeQuery();

			double oldQuantity = 0.0;
			double oldTotalPrice = 0.0;

			if (rs.next()) {
				oldQuantity = rs.getDouble("quantity");
				oldTotalPrice = rs.getDouble("total_price");
			}

			oldTotalPrice = (oldQuantity * newUnitPrice);
			oldTotalPrice = oldTotalPrice + (oldTotalPrice * (newTax / 100));
			double totalQuantity = (oldQuantity + newQuantity);
			double totalPrice = (oldTotalPrice + newTotalPrice);

			updatePst.setDouble(1, totalQuantity);
			updatePst.setDouble(2, newUnitPrice);
			updatePst.setDouble(3, totalPrice);
			updatePst.setString(4, dateString);
			updatePst.setInt(5, srNo);

			int affectedRows = updatePst.executeUpdate();

			if (affectedRows > 0) {
				JOptionPane.showMessageDialog(null, "Updated Successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Update Failed");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Update Failed");
		}
	}

	public void deleteProduct(int selectedRow, int srNo, DefaultTableModel model) {
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a Record");
			return;
		}

		try {
//			String storedProcedureCall = "{call DeleteProductsByID(?)}";
//          CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("DELETE FROM products WHERE sr_no = ?");
			pst.setInt(1, srNo);
			int affectedRows = pst.executeUpdate();

			if (affectedRows > 0) {
				model.removeRow(selectedRow);
				JOptionPane.showMessageDialog(null, "Deleted Successfully");
			} else {
				JOptionPane.showMessageDialog(null, "Delete Failed");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
