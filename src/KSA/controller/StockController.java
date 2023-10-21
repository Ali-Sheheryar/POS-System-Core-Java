package KSA.controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import KSA.dto.StockDTO;
import KSA.model.StockModel;

public class StockController {

	private StockModel stockModel = new StockModel();

//	public String calculateTotalPrice(String partQuantity, String price, String taxVAT) {
//		return stockModel.calculateTotalPrice(partQuantity, price, taxVAT);
//	}

	public List<StockDTO> filterDataByMonth(String selectedMonth, int selectedMonthIndex) {
		return stockModel.filterDataByMonth(selectedMonth, selectedMonthIndex);
	}

	public List<StockDTO> showProductData() {
		return stockModel.showProductData();
	}

	public void updateProduct(double newTax,int selectedRow, int srNo, StockDTO stockDTO) {
		stockModel.updateProduct(newTax, selectedRow, srNo, stockDTO);
	}

	public void deleteProduct(int selectedRow, int srNo, DefaultTableModel model) {
		stockModel.deleteProduct(selectedRow, srNo, model);
	}
}
