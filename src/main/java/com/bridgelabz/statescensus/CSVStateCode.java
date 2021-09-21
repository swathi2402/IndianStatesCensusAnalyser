package com.bridgelabz.statescensus;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCode {
	@CsvBindByName(column = "StateName")
	private String stateName;

	@CsvBindByName(column = "StateCode", required = true)
	private String code;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
