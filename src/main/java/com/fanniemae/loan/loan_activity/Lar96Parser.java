package com.fanniemae.loan.loan_activity;

import java.math.BigInteger;
import java.util.Map;

public class Lar96Parser {
	
	private Map<Integer, String> actionCodeMap;
	
	public Lar96Parser(Map<Integer, String> actionCodeMap) {
		this.actionCodeMap = actionCodeMap;
	}
	
	public Lar96Record parse(String line) {
		Lar96Record lar96Record = new Lar96Record();
		
		lar96Record.setLenderNumber(line.substring(0, 9));
		lar96Record.setInvestor(line.substring(9, 10));
		lar96Record.setRecordIdentifier(Integer.parseInt(line.substring(10, 12)));
		lar96Record.setSourceCode(line.substring(12, 13));
		lar96Record.setFannieMaeLoanNumber(new BigInteger(line.substring(13,23)));
		lar96Record.setLpiDate(line.substring(23, 27));
		lar96Record.setUpb(line.substring(27, 38));
		lar96Record.setInterest(line.substring(38, 49));
		lar96Record.setPrincipal(line.substring(49, 60));
		lar96Record.setActionCode(Integer.parseInt(line.substring(60, 62)));
		lar96Record.setActionDate(Integer.parseInt(line.substring(62, 68)));
		lar96Record.setOtherFees(line.substring(68, 76));
		lar96Record.setDescription(actionCodeMap.get(lar96Record.getActionCode()));
		
		return lar96Record;
	}

}
