package com.fanniemae.loan.loan_activity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Lar96Record implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lenderNumber;
	private String investor;
	private int recordIdentifier;
	private String sourceCode;
	private BigInteger fannieMaeLoanNumber;
	private String lpiDate;
	private String upb;
	private String interest;
	private String principal;
	private Integer actionCode;
	private Integer actionDate;
	private String otherFees;
	private String description;

	public boolean isLpiDateBefore() {
		return lpiDateBefore;
	}

	public void setLpiDateBefore(boolean lpiDateBefore) {
		this.lpiDateBefore = lpiDateBefore;
	}

	private boolean lpiDateBefore;

	public String getLenderNumber() {
		return lenderNumber;
	}

	public void setLenderNumber(String lenderNumber) {
		this.lenderNumber = lenderNumber;
	}

	public String getInvestor() {
		return investor;
	}

	public void setInvestor(String investor) {
		this.investor = investor;
	}

	public int getRecordIdentifier() {
		return recordIdentifier;
	}

	public void setRecordIdentifier(int recordIdentifier) {
		this.recordIdentifier = recordIdentifier;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public BigInteger getFannieMaeLoanNumber() {
		return fannieMaeLoanNumber;
	}

	public void setFannieMaeLoanNumber(BigInteger fannieMaeLoanNumber) {
		this.fannieMaeLoanNumber = fannieMaeLoanNumber;
	}

	public String getLpiDate() {
		return lpiDate;
	}

	public void setLpiDate(String lpiDate) {
		this.lpiDate = lpiDate;
	}

	public String getUpb() {
		return upb;
	}

	public void setUpb(String upb) {
		this.upb = upb;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Integer getActionCode() {
		return actionCode;
	}

	public void setActionCode(Integer actionCode) {
		this.actionCode = actionCode;
	}

	public Integer getActionDate() {
		return actionDate;
	}

	public void setActionDate(Integer actionDate) {
		this.actionDate = actionDate;
	}

	public String getOtherFees() {
		return otherFees;
	}

	public void setOtherFees(String otherFees) {
		this.otherFees = otherFees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
