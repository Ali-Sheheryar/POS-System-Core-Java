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
import KSA.dto.StockDTO;
import KSA.view.HomeView;

public class HomeModel {

	private HomeView homeView;
	Connection connection = DbConnection.getConnection();

	public double showUnitPrice(StockDTO stockDTO) {
		double unitPrice = 0.0;
		try {
//			String storedProcedureCall = "{call GetProductPriceByName(?)}"; //recommended to use
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			
//Inline Query is provided to give you a better insight
			PreparedStatement pst = connection.prepareStatement("SELECT price FROM products WHERE p_name = ?");
			pst.setString(1, stockDTO.getPartName());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				unitPrice = rs.getDouble("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unitPrice;
	}

	public double validateProductQuantity(StockDTO stockDTO) {
		double availQuantity = 0.0;

		try {
//			String storedProcedureCall = "{call GetProductQuantityByName(?)}";
//			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT quantity FROM products WHERE p_name = ?");
			pst.setString(1, stockDTO.getPartName());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				availQuantity = rs.getDouble("quantity");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return availQuantity;
	}

	public double validateProductPrice(StockDTO stockDTO) {
		double availPrice = 0.0;

		try {
//			String storedProcedureCall = "{call GetProductPriceByName(?)}";
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT price FROM products WHERE p_name = ?");
			pst.setString(1, stockDTO.getPartName());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				availPrice = rs.getDouble("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return availPrice;
	}

	public List<String> getProductsName() {
		List<String> productsName = new ArrayList<String>();

		try {
//			String storedProcedureCall = "{call GetProductByName()}"; //recommended to use
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
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

	public int autoIncrInvoiceNo() {
		int invNo = 0;
		try {
//			String storedProcedureCall = "{call GetMaxInvNoInvoice()}"; //recommended to use
//			CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection.prepareStatement("SELECT MAX(invNo) FROM invoices");
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
			e.printStackTrace();
		}
		return invNo;
	}

	public List<InvoiceDTO> addToCart(List<InvoiceDTO> invoiceList, InvoiceDTO invoiceDTO) {
		try {
			invoiceList.add(invoiceDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		homeView.resetTxtBottom();
		return invoiceList;
	}

	public void insertProduct(List<InvoiceDTO> invoiceList, String rdPaidUnpaid) {
		try {
			
			// Iterate through the list and insert each object into the database
			for (InvoiceDTO dto : invoiceList) {
//				String storedProcedureCall = "{call PostInvoices(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; 
//	  			CallableStatement pst = connection.prepareCall(storedProcedureCall);
				PreparedStatement pst = connection.prepareStatement(
						"INSERT INTO invoices (invNo, invDate, custName, ms, partName, description, quantity, unitPrice, totalValue, discount, netInvoice, vatTax, totalInv, paid, formated_real_stock) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				pst.setInt(1, dto.getInvNo());
				pst.setString(2, dto.getDateString());
				pst.setString(3, dto.getCustName());
				pst.setString(4, dto.getMS());
				pst.setString(5, dto.getPartName());
				pst.setString(6, dto.getDescription());
				pst.setDouble(7, dto.getquantity());
				pst.setDouble(8, dto.getUnitPrice());
				pst.setDouble(9, dto.getTotalValue());
				pst.setDouble(10, dto.getDiscount());
				pst.setDouble(11, dto.getNetInvoice());
				pst.setDouble(12, dto.getTaxVAT());
				pst.setDouble(13, dto.getTotalInv());
				pst.setString(14, rdPaidUnpaid);
				pst.setDouble(15, dto.getRealStockF());
				pst.executeUpdate();
				updateProduct(dto.getPartName(), dto.getquantity(), dto.getTaxVAT());
			}
			JOptionPane.showMessageDialog(null, "Invoice Generated");
			homeView.printInvoice();
			homeView.resetTxtTop();
			homeView.resetTxtBottom();
			autoIncrInvoiceNo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
	}

	public void updateProduct(String partName, double tempQuant, double taxVAT) {
		try {
//			String storedProcedureCall = "{call GetProductPriceAndQuantityByName(?)}"; 
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement pst = connection
					.prepareStatement("SELECT quantity, price, total_price FROM products WHERE p_name = ?");
			pst.setString(1, partName);
			ResultSet rs = pst.executeQuery();

			double realQuantity = 0.0;
			double realUnitPrice = 0.0;
			double realTotalPrice = 0.0;

			if (rs.next()) {
				realQuantity = rs.getDouble("quantity");
				realUnitPrice = rs.getDouble("price");
				realTotalPrice = rs.getDouble("total_price");
			}

			double stockTotalPrice1 = tempQuant * realUnitPrice;
			double stockTotalPrice2 = stockTotalPrice1;
			double stockTotalPrice3 = stockTotalPrice2 + (stockTotalPrice1 * (taxVAT / 100));
			double netTotalQuantity = realQuantity - tempQuant;
			double netTotalPrice = realTotalPrice - stockTotalPrice3;

//			String storedProcedureCall = "{call PostProductPriceAndQuantityByName(?, ?, ?)}"; 
//  		CallableStatement pst = connection.prepareCall(storedProcedureCall);
			PreparedStatement updatePst = connection
					.prepareStatement("UPDATE products SET quantity = ?, total_price = ? WHERE p_name = ?");
			updatePst.setDouble(1, netTotalQuantity);
			updatePst.setDouble(2, netTotalPrice);
			updatePst.setString(3, partName);
			updatePst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}