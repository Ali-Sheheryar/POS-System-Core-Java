package KSA.controller;

import java.util.List;

import KSA.dto.InvoiceDTO;
import KSA.dto.StockDTO;
import KSA.model.HomeModel;

public class HomeController {

	private HomeModel homeModel = new HomeModel();

	public double showUnitPrice(StockDTO stockDTO) {
		return homeModel.showUnitPrice(stockDTO);
	}

	public int autoIncrInvoiceNo() {
		return homeModel.autoIncrInvoiceNo();
	}

	public double validateProductQuantity(StockDTO stockDTO) {
		return homeModel.validateProductQuantity(stockDTO);
	}

	public double validateProductPrice(StockDTO stockDTO) {
		return homeModel.validateProductPrice(stockDTO);
	}

	public List<String> getProductsName() {
		return homeModel.getProductsName();
	}

	public void insertProduct(List<InvoiceDTO> invoiceList, String rdPaidUnpaid) {
		homeModel.insertProduct(invoiceList, rdPaidUnpaid);
	}

	public List<InvoiceDTO> addToCart(List<InvoiceDTO> invoiceList, InvoiceDTO invoiceDTO) {
		return homeModel.addToCart(invoiceList, invoiceDTO);
	}

//	public void updateProduct(String partName, double tempQuant, double taxVAT) {
//		homeModel.updateProduct(partName, tempQuant, taxVAT);
//	}

}
