package com.bridgelabz.statescensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {

	@CsvBindByName(column = "State")
	private String stateName;

	@CsvBindByName(column = "Population", required = true)
	private double population;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "stateName=" + stateName + ", population=" + population;
	}

}
