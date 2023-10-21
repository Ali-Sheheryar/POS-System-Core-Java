package KSA.dto;

public class InvoiceDTO {

	private int invNo;
	private String dateString;
	private String custName;
	private String MS;
	private String partName;
	private String description;
	private double quantity;
	private double unitPrice;
	private double totalValue;
	private double discount;
	private double netInvoice;
	private double taxVAT;
	private double totalInv;
	private String paid;
	private double realStockF;

	private String setPaid;
	private int selectedRow;
	private int invNoSelected;
	private String checkpaid;

	public InvoiceDTO() {}
	
	public InvoiceDTO(int invNo, String dateString, String custName, String MS, String partName, String description,
			double quantity, double unitPrice, double totalValue, double discount, double netInvoice, double taxVAT,
			double totalInv, String paid, String setPaid, int selectedRow, int invNoSelected, String checkpaid,
			double realStockF) {
		super();
		this.invNo = invNo;
		this.dateString = dateString;
		this.custName = custName;
		this.MS = MS;
		this.partName = partName;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalValue = totalValue;
		this.discount = discount;
		this.netInvoice = netInvoice;
		this.taxVAT = taxVAT;
		this.totalInv = totalInv;
		this.paid = paid;
		this.realStockF = realStockF;
		
		this.setPaid = setPaid;
		this.selectedRow = selectedRow;
		this.invNoSelected = invNoSelected;
		this.checkpaid = checkpaid;
	}
	
	public InvoiceDTO(int invNo, String dateString, String custName, String MS, String partName, String description,
			double quantity, double unitPrice, double totalValue, double discount, double netInvoice, double taxVAT,
			double totalInv, String paid, double realStockF) {
		super();
		this.invNo = invNo;
		this.dateString = dateString;
		this.custName = custName;
		this.MS = MS;
		this.partName = partName;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalValue = totalValue;
		this.discount = discount;
		this.netInvoice = netInvoice;
		this.taxVAT = taxVAT;
		this.totalInv = totalInv;
		this.paid = paid;
		this.realStockF = realStockF;
	}
	
	public InvoiceDTO(int invNo, String dateString, String custName, String MS, String partName,
			double quantity, double unitPrice, double totalValue, double discount, double netInvoice, double taxVAT,
			double totalInv, String paid) {
		super();
		this.invNo = invNo;
		this.dateString = dateString;
		this.custName = custName;
		this.MS = MS;
		this.partName = partName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalValue = totalValue;
		this.discount = discount;
		this.netInvoice = netInvoice;
		this.taxVAT = taxVAT;
		this.totalInv = totalInv;
		this.paid = paid;		
	}

	public int getInvNo() {
		return invNo;
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMS() {
		return MS;
	}

	public void setMS(String mS) {
		this.MS = mS;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getquantity() {
		return quantity;
	}

	public void setquantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getNetInvoice() {
		return netInvoice;
	}

	public void setNetInvoice(double netInvoice) {
		this.netInvoice = netInvoice;
	}

	public double getTaxVAT() {
		return taxVAT;
	}

	public void setTaxVAT(double taxVAT) {
		this.taxVAT = taxVAT;
	}

	public double getTotalInv() {
		return totalInv;
	}

	public void setTotalInv(double totalInv) {
		this.totalInv = totalInv;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getSetPaid() {
		return setPaid;
	}

	public void setSetPaid(String setPaid) {
		this.setPaid = setPaid;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getInvNoSelected() {
		return invNoSelected;
	}

	public void setInvNoSelected(int invNoSelected) {
		this.invNoSelected = invNoSelected;
	}

	public String getCheckpaid() {
		return checkpaid;
	}

	public void setCheckpaid(String checkpaid) {
		this.checkpaid = checkpaid;
	}

	public double getRealStockF() {
		return realStockF;
	}

	public void setRealStockF(double realStockF) {
		this.realStockF = realStockF;
	}

}
