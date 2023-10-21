package KSA.dto;

public class StockDTO {

	private int srNo;
	private String partName;
	private String dateString;
	private double quantity;
	private double unitPrice;
	private double totalValue;
	
	public StockDTO() {}
	
	public StockDTO(int srNo, String partName, String dateString, double quantity, double unitPrice,
			double totalValue) {
		super();
		this.srNo = srNo;
		this.partName = partName;
		this.dateString = dateString;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalValue = totalValue;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
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

	
}
