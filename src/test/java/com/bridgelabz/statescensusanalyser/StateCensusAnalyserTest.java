package com.bridgelabz.statescensusanalyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

	public static final String CSV_FILE_PATH = "./StateCensus.csv";
	public static final String NO_FILE = "./StateCensu.csv";
	public static final String WRONG_FILE = "./State.csv";

	@Test
	public void GivenStateCensusCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {

		int count = StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH);
		Assert.assertEquals(29, count);

	}

	@Test
	public void GivenStateCensusCsvFile_IfInCorrect_ShouldThrowException() {
		try {
			StateCensusAnalyser.loadDataToIterator(NO_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void GivenStateCensusCSVFile_WithDelimiterIncorrect_ReturnsCensusAnalyserException() throws IOException {
		try {
			StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
}
