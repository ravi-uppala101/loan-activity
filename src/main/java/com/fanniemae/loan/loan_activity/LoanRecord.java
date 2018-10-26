package com.fanniemae.loan.loan_activity;

public class LoanRecord {
	private String make;
	private String manufacturer;
	private String id;

	public LoanRecord() {
		super();
	}

	public LoanRecord(String make, String manufacturer, String id) {
		super();
		this.make = make;
		this.manufacturer = manufacturer;
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoanRecord [make=" + make + ", manufacturer=" + manufacturer + ", id=" + id + "]";
	}
}
