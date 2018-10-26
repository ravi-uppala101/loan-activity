package com.fanniemae.loan.loan_activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanDataPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoanDataPublisher.class);

	private Sender sender;
	private String topic;
	private Lar96Parser lar96Parser;

	public LoanDataPublisher(Sender sender, String topic) {
		this.sender = sender;
		this.topic = topic;
		lar96Parser = new Lar96Parser(buildActionCodeMap());
		publish("/app/data/input/LAR96_Sample.txt");
		
	}

	public void publish(String fileName) {
		System.out.println("reading file = ################################################"+fileName);
		LOGGER.info("Publishing data to topic = {} started..", topic);
		// Get file from resources folder
		File file = new File(fileName); 
		BufferedReader br = null;
		try {
			int count = 0;
			for(int i = 0; i < 10; i++) {
			  br = new BufferedReader(new FileReader(file)); 
			  String line; 
			  while ((line = br.readLine()) != null) {
				  count++;
				  if(count % 5000 == 0) {
					  LOGGER.info("Number of Records published to topic = {} are = {}", topic,count);
				  }
					Lar96Record lar96Record = lar96Parser.parse(line);

				  lar96Record.setLpiDateBefore(isLPIDateBefore(lar96Record.getLpiDate()));
					//System.out.println(lar96Record);
					sender.send(topic, lar96Record.getFannieMaeLoanNumber()+"", lar96Record);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			  } 
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		LOGGER.info("Publishing data to topic = {} ended..", topic);
	}
	
	private Map<Integer, String> buildActionCodeMap() {
		Map<Integer, String> actionCodeMap = new ConcurrentHashMap<>();
		
//		00 – Payment, Curtailment or No Payment
//		60 – Payoff
//		65 – Repurchase
//		70 – Liquidation - Charge Off
//		71 - Liquidation -  Third party Sale
//		72 – Liquidation - Foreclosure
		
		actionCodeMap.put(00, "Payment, Curtailment or No Payment");
		actionCodeMap.put(60, "Payoff");
		actionCodeMap.put(65, "Repurchase");
		actionCodeMap.put(70, "Liquidation - Charge Off");
		actionCodeMap.put(71, "Liquidation -  Third party Sale");
		actionCodeMap.put(72, "Liquidation - Foreclosure");
		
		return actionCodeMap;
		
	}


	public  boolean isLPIDateBefore(String dateInput) {
		String newDate = new StringBuilder(dateInput.substring(0,2)).append("/").append(dateInput.substring(2)).toString();
		LocalDate today = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());

		YearMonth ym = YearMonth.parse(newDate, DateTimeFormatter.ofPattern("MM/yy"));
		LocalDate dateParsed = ym.atEndOfMonth();

		return dateParsed.isBefore(today);
	}
}
