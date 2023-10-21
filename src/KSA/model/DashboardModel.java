package KSA.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import KSA.dbconnection.DbConnection;
import KSA.dto.InvoiceDTO;

public class DashboardModel {

	public DashboardModel() {
	}

	Connection connection = DbConnection.getConnection();

	public List<String> getProductsName() {
		List<String> productsName = new ArrayList<String>();

		try {
//			String storedProcedureCall = "{call GetProductsName(?)}"; //recommended to use
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			
//Inline Query is provided to give you a better insight
			PreparedStatement pst = connection.prepareStatement("SELECT p_name FROM products");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String productName = rs.getString("p_name");
				productsName.add(productName);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Log the exception or handle it as needed
		}

		return productsName;
	}

	public void invDelete(int selectedRow, int invNo) {
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Delete Error");
			return;
		}

		try {
//			String storedProcedureCall = "{call GetInvoiceFieldsByInvNo(?)}"; 
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			String selectQuery = "SELECT partName, quantity, formated_real_stock FROM invoices WHERE invNo = ?";
			PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
			ResultSet rs = selectStatement.executeQuery();
			selectStatement.setInt(1, invNo);
			if (rs.next()) {
				String productUpdate = rs.getString("partName");
				double quantityUpdate = rs.getDouble("quantity");
				double stockUpdate = rs.getDouble("formated_real_stock");

//				String storedProcedureCall = "{call DeleteInvoiceByInvNo(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				String deleteQuery = "DELETE FROM invoices WHERE invNo = ?";

				PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
				deleteStatement.setInt(1, invNo);
				deleteStatement.executeUpdate();

//				String storedProcedureCall = "{call GetProductsFieldsByName(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				String selectProductQuery = "SELECT sr_no, quantity, total_price FROM products WHERE p_name = ?";
				PreparedStatement selectProductStatement = connection.prepareStatement(selectProductQuery);
				selectProductStatement.setString(1, productUpdate);
				ResultSet productRS = selectProductStatement.executeQuery();
				if (productRS.next()) {
					int srNo = productRS.getInt("sr_no");
					double oldQuantity = productRS.getDouble("quantity");
					double oldTotalPrice = productRS.getDouble("total_price");

					// Update the 'products' table
					double totalQuantity = oldQuantity + quantityUpdate;
					double totalStock = oldTotalPrice + stockUpdate;
//					String storedProcedureCall = "{call PostProductsBySrNo(?,?,?)}"; 
//		  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
					String updateQuery = "UPDATE products SET quantity = ?, total_price = ? WHERE sr_no = ?";
					PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
					updateStatement.setDouble(1, totalQuantity);
					updateStatement.setDouble(2, totalStock);
					updateStatement.setInt(3, srNo);
					updateStatement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setPaid(int selectedRow, int invNo) {
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a Record");
			return;
		}
		String paid = "paid";
		try {
//			String storedProcedureCall = "{call PostInvoiceByInvNo(?, ?)}"; 
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			String query = "UPDATE invoices SET paid = ? WHERE invNo = ?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, paid);
			pst.setInt(2, invNo);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<InvoiceDTO> showInvoiceData(InvoiceDTO invoiceDTO) {
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		String checkpaid = invoiceDTO.getCheckpaid();

		try {
			String query;
			if (checkpaid != null && !checkpaid.isEmpty()) {
				query = "SELECT * FROM invoices WHERE paid = ?";
//				String storedProcedureCall = "{call GetPaidInvoices(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			} else {
				query = "SELECT * FROM invoices";
//				String storedProcedureCall = "{call GetAllInvoices()}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			}

			
			PreparedStatement pst = connection.prepareStatement(query);
			if (checkpaid != null && !checkpaid.isEmpty()) {
				pst.setString(1, checkpaid);
			}
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				InvoiceDTO invoiceDTO1 = new InvoiceDTO();
				invoiceDTO1.setInvNo(rs.getInt("invNo"));
				invoiceDTO1.setDateString(rs.getString("invDate"));
				invoiceDTO1.setCustName(rs.getString("custName"));
				invoiceDTO1.setMS(rs.getString("ms"));
				invoiceDTO1.setPartName(rs.getString("partName"));
				invoiceDTO1.setDescription(rs.getString("descrpt"));
				invoiceDTO1.setquantity(rs.getDouble("quantity"));
				invoiceDTO1.setUnitPrice(rs.getDouble("unitPrice"));
				invoiceDTO1.setTotalValue(rs.getDouble("totalValue"));
				invoiceDTO1.setDiscount(rs.getDouble("discount"));
				invoiceDTO1.setNetInvoice(rs.getDouble("netInvoice"));
				invoiceDTO1.setTaxVAT(rs.getDouble("vatTax"));
				invoiceDTO1.setTotalInv(rs.getDouble("totalInv"));
				invoiceDTO1.setPaid(rs.getString("paid"));
				invoiceDTO1.setRealStockF(rs.getDouble("formated_real_stock"));
				invoiceList.add(invoiceDTO1); // Add the current InvoiceDTO to the list
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return invoiceList; // Return the list of InvoiceDTO objects
	}

	public List<InvoiceDTO> showCustomerData(InvoiceDTO invoiceDTO, String customer) {
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		String checkpaid = invoiceDTO.getCheckpaid();

		try {
			String query;
			if (checkpaid != null && !checkpaid.isEmpty()) {
				query = "SELECT * FROM invoices WHERE paid = ? AND custName LIKE ?";
//				String storedProcedureCall = "{call GetPaidInvoicesByCustomerName(?, ?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			} else {
				query = "SELECT * FROM invoices WHERE custName LIKE ?";
//				String storedProcedureCall = "{call GetInvoicesByCustomerName(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			}
			PreparedStatement pst = connection.prepareStatement(query);
			if (checkpaid != null && !checkpaid.isEmpty()) {
				pst.setString(1, checkpaid);
				pst.setString(2, "%" + customer + "%");
			} else {
				pst.setString(1, "%" + customer + "%");
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				InvoiceDTO invoiceDTO1 = new InvoiceDTO();
				invoiceDTO1.setInvNo(rs.getInt("invNo"));
				invoiceDTO1.setDateString(rs.getString("invDate"));
				invoiceDTO1.setCustName(rs.getString("custName"));
				invoiceDTO1.setMS(rs.getString("ms"));
				invoiceDTO1.setPartName(rs.getString("partName"));
				invoiceDTO1.setDescription(rs.getString("descrpt"));
				invoiceDTO1.setquantity(rs.getDouble("quantity"));
				invoiceDTO1.setUnitPrice(rs.getDouble("unitPrice"));
				invoiceDTO1.setTotalValue(rs.getDouble("totalValue"));
				invoiceDTO1.setDiscount(rs.getDouble("discount"));
				invoiceDTO1.setNetInvoice(rs.getDouble("netInvoice"));
				invoiceDTO1.setTaxVAT(rs.getDouble("vatTax"));
				invoiceDTO1.setTotalInv(rs.getDouble("totalInv"));
				invoiceDTO1.setPaid(rs.getString("paid"));
				invoiceDTO1.setRealStockF(rs.getDouble("formated_real_stock"));
				invoiceList.add(invoiceDTO1); // Add the current InvoiceDTO to the list
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return invoiceList;
	}

	public List<InvoiceDTO> showProductData(InvoiceDTO invoiceDTO, String partName) {
		List<InvoiceDTO> invoiceList = new ArrayList<>();
		String checkpaid = invoiceDTO.getCheckpaid();

		try {
			String query;
			if (checkpaid != null && !checkpaid.isEmpty()) {
				query = "SELECT * FROM invoices WHERE paid = ? AND partName LIKE ?";
//				String storedProcedureCall = "{call GetPaidInvoicesByProductName(?, ?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			} else {
				query = "SELECT * FROM invoices WHERE partName LIKE ?";
//				String storedProcedureCall = "{call GetInvoicesByProductName(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			}

			PreparedStatement pst = connection.prepareStatement(query);

			if (checkpaid != null && !checkpaid.isEmpty()) {
				pst.setString(1, checkpaid);
				pst.setString(2, "%" + partName + "%");
			} else {
				pst.setString(1, "%" + partName + "%");
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				InvoiceDTO invoiceDTO1 = new InvoiceDTO();
				invoiceDTO1.setInvNo(rs.getInt("invNo"));
				invoiceDTO1.setDateString(rs.getString("invDate"));
				invoiceDTO1.setCustName(rs.getString("custName"));
				invoiceDTO1.setMS(rs.getString("ms"));
				invoiceDTO1.setPartName(rs.getString("partName"));
				invoiceDTO1.setDescription(rs.getString("descrpt"));
				invoiceDTO1.setquantity(rs.getDouble("quantity"));
				invoiceDTO1.setUnitPrice(rs.getDouble("unitPrice"));
				invoiceDTO1.setTotalValue(rs.getDouble("totalValue"));
				invoiceDTO1.setDiscount(rs.getDouble("discount"));
				invoiceDTO1.setNetInvoice(rs.getDouble("netInvoice"));
				invoiceDTO1.setTaxVAT(rs.getDouble("vatTax"));
				invoiceDTO1.setTotalInv(rs.getDouble("totalInv"));
				invoiceDTO1.setPaid(rs.getString("paid"));
				invoiceDTO1.setRealStockF(rs.getDouble("formated_real_stock"));
				invoiceList.add(invoiceDTO1); // Add the current InvoiceDTO to the list
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return invoiceList;
	}

	public InvoiceDTO print(int invNoSelected) {
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		if (invNoSelected > 0) {
			try {
//				String storedProcedureCall = "{call GetInvoicesByInvNo(?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				String query = "SELECT * FROM invoices WHERE invNo = ?";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setInt(1, invNoSelected);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					invoiceDTO.setInvNo(rs.getInt("invNo"));
					invoiceDTO.setDateString(rs.getString("invDate"));
					invoiceDTO.setCustName(rs.getString("custName"));
					invoiceDTO.setMS(rs.getString("ms"));
					invoiceDTO.setPartName(rs.getString("partName"));
					invoiceDTO.setquantity(rs.getDouble("quantity"));
					invoiceDTO.setUnitPrice(rs.getDouble("unitPrice"));
					invoiceDTO.setTotalValue(rs.getDouble("totalValue"));
					invoiceDTO.setDiscount(rs.getDouble("discount"));
					invoiceDTO.setNetInvoice(rs.getDouble("netInvoice"));
					invoiceDTO.setTaxVAT(rs.getDouble("vatTax"));
					invoiceDTO.setTotalInv(rs.getDouble("totalInv"));
					invoiceDTO.setPaid(rs.getString("paid"));
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return invoiceDTO;
	}

	public List<InvoiceDTO> filterDataByMonth(InvoiceDTO invoiceDTO, String fromDate, String toDate) {
		String checkpaid = invoiceDTO.getCheckpaid();
		List<InvoiceDTO> invoiceList = new ArrayList<>();

		try {
			String query;
			if (checkpaid != null && !checkpaid.isEmpty()) {
//				String storedProcedureCall = "{call GetPaidInvoicesByToAndFromDate(?, ?, ?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				query = "SELECT * FROM invoices WHERE STR_TO_DATE(invDate, '%m-%Y') BETWEEN STR_TO_DATE(?, '%m-%Y') AND STR_TO_DATE(?, '%m-%Y') AND paid = ?";
			} else {
//				String storedProcedureCall = "{call GetInvoicesByToAndFromDate(?, ?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				query = "SELECT * FROM invoices WHERE STR_TO_DATE(invDate, '%m-%Y') BETWEEN STR_TO_DATE(?, '%m-%Y') AND STR_TO_DATE(?, '%m-%Y')";
			}
			PreparedStatement pst = connection.prepareStatement(query);

			if (checkpaid != null && !checkpaid.isEmpty()) {

				pst.setString(1, fromDate); // Set the FromDate parameter
				pst.setString(2, toDate); // Set the ToDate parameter
				pst.setString(3, checkpaid); // Set the paid parameter value
			} else {
				pst.setString(1, fromDate); // Set the FromDate parameter
				pst.setString(2, toDate); // Set the ToDate parameter
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				InvoiceDTO invoiceDTO1 = new InvoiceDTO();
				invoiceDTO1.setInvNo(rs.getInt("invNo"));
				invoiceDTO1.setDateString(rs.getString("invDate"));
				invoiceDTO1.setCustName(rs.getString("custName"));
				invoiceDTO1.setMS(rs.getString("ms"));
				invoiceDTO1.setPartName(rs.getString("partName"));
				invoiceDTO1.setDescription(rs.getString("descrpt"));
				invoiceDTO1.setquantity(rs.getDouble("quantity"));
				invoiceDTO1.setUnitPrice(rs.getDouble("unitPrice"));
				invoiceDTO1.setTotalValue(rs.getDouble("totalValue"));
				invoiceDTO1.setDiscount(rs.getDouble("discount"));
				invoiceDTO1.setNetInvoice(rs.getDouble("netInvoice"));
				invoiceDTO1.setTaxVAT(rs.getDouble("vatTax"));
				invoiceDTO1.setTotalInv(rs.getDouble("totalInv"));
				invoiceDTO1.setPaid(rs.getString("paid"));
				invoiceDTO1.setRealStockF(rs.getDouble("formated_real_stock"));
				invoiceList.add(invoiceDTO1); // Add the current InvoiceDTO to the list
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return invoiceList;
	}

}
