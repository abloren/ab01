package model;

import java.util.LinkedHashMap;

public class Customer {
	protected String phoneNumber;
	protected int payTotal;
	public LinkedHashMap<Menu, Integer> hashCus = new LinkedHashMap<Menu, Integer>();
	
	public Customer() {
		super();
	}

	public Customer(String phoneNumber, int payTotal) {
		super();
		this.phoneNumber = phoneNumber;
		this.payTotal = payTotal;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}
	
	@Override
	public boolean equals(Object obj) {
		Customer m = (Customer)obj;
		if(phoneNumber.equalsIgnoreCase(m.getPhoneNumber()))
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return phoneNumber.hashCode();
	}
}
