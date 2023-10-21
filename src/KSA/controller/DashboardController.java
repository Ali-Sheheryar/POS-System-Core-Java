package KSA.controller;

import java.util.List;

import KSA.dto.InvoiceDTO;
import KSA.model.DashboardModel;

public class DashboardController {
	
	public DashboardController() {
		return;
	}

	private DashboardModel dashboardModel = new DashboardModel();

	public List<String> getProductsName() {
		return dashboardModel.getProductsName();
	}

	public void setPaid(int selectedRow, int invNo) {
		dashboardModel.setPaid(selectedRow, invNo);
	}

	public void invDelete(int selectedRow, int invNo) {
		dashboardModel.invDelete(selectedRow, invNo);
	}

	public List<InvoiceDTO> showInvoiceData(InvoiceDTO invoiceDTO) {
		return dashboardModel.showInvoiceData(invoiceDTO);
	}

	public List<InvoiceDTO> showCustomerData(InvoiceDTO invoiceDTO, String customer) {
		return dashboardModel.showCustomerData(invoiceDTO, customer);
	}

	public List<InvoiceDTO> showProductData(InvoiceDTO invoiceDTO, String partName) {
		return dashboardModel.showProductData(invoiceDTO, partName);
	}

	public InvoiceDTO print(int invNoSelected) {
		return dashboardModel.print(invNoSelected);
	}

	public List<InvoiceDTO> filterDataByMonth(InvoiceDTO invoiceDTO, String fromDate, String toDate) {
		return dashboardModel.filterDataByMonth(invoiceDTO, fromDate, toDate);
	}
}
