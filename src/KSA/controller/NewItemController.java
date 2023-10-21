package KSA.controller;

import javax.swing.JOptionPane;

import KSA.dto.StockDTO;
import KSA.model.NewItemModel;
import KSA.view.NewItemView;

public class NewItemController {
	private NewItemModel itemModel = new NewItemModel();

	public void insertProduct(StockDTO stockDTO, String dateString) {
		itemModel.insertProduct(stockDTO, dateString);
	}

	@SuppressWarnings("null")
	public String calculateTotal(double partQuantity, double price, double taxVAT) {
		NewItemView newItem = null;
		if (partQuantity == 0 || partQuantity < 0) {
			JOptionPane.showMessageDialog(null, "Quantity cannot be ZERO");
			newItem.setTxtPartQuantity("");
		}

		if (price == 0 || price < 0) {
			JOptionPane.showMessageDialog(null, "Price cannot be ZERO");
			newItem.setTxtUnitPrice("");
		}

		if (taxVAT == 0 || taxVAT < 0) {
			JOptionPane.showMessageDialog(null, "Tax cannot be ZERO");
			newItem.setTxtVAT("");
		}
		return itemModel.calculateTotal(partQuantity, price, taxVAT);
	}

	public int autoIncrProductNo() {
		return itemModel.autoIncrProductNo();
	}

	public boolean validateProduct(StockDTO stockDTO) {
		return itemModel.validateProduct(stockDTO);
	}
}
