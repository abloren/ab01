package model;

public class Bill extends Customer {
	private String bankId;
	public Bill() {
		super();
	}
	public Bill(String phoneNumber, String bankId, int payTotal) {
		super();
		this.phoneNumber = phoneNumber;
		this.bankId = bankId;
		this.payTotal = payTotal;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public int getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}
}
