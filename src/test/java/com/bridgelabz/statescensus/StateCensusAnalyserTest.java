package com.bridgelabz.statescensus;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.statescensus.CensusAnalyserException;
import com.bridgelabz.statescensus.StateCensusAnalyser;

public class StateCensusAnalyserTest {

	public static final String CSV_FILE_PATH = "./StateCensus.csv";
	public static final String CSV_STATECODE_PATH = "./StateCode.csv";
	public static final String NO_FILE = "./State.csv";
	public static final String WRONG_FILE = "./State.json";

	@Test
	public void GivenStateCensusCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {

		int count = StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH, CSVStateCensus.class);
		Assert.assertEquals(29, count);

	}

	@Test
	public void GivenStateCensusCsvFile_IfInCorrect_ShouldThrowException() {
		try {
			StateCensusAnalyser.loadDataToIterator(NO_FILE, CSVStateCensus.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCensusCSVFile_TypeIncorrect_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(WRONG_FILE, CSVStateCensus.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void GivenStateCensusCSVFile_WithDelimiterIncorrect_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH, CSVStateCensus.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCensusCSVFile_IncorrectHeader_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH, CSVStateCensus.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCodeCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {

		int count = StateCensusAnalyser.loadDataToIterator(CSV_STATECODE_PATH, CSVStateCode.class);
		Assert.assertEquals(37, count);

	}
	
	@Test
	public void GivenStateCodeCsvFile_IfInCorrect_ShouldThrowException() {
		try {
			StateCensusAnalyser.loadDataToIterator(NO_FILE, CSVStateCode.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCodeCSVFile_TypeIncorrect_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(WRONG_FILE, CSVStateCode.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCodeCSVFile_WithDelimiterIncorrect_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(CSV_STATECODE_PATH, CSVStateCode.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void GivenStateCodeCSVFile_IncorrectHeader_ReturnsCensusAnalyserException() {
		try {
			StateCensusAnalyser.loadDataToIterator(CSV_STATECODE_PATH, CSVStateCode.class);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, e.type);
			System.out.println(e.getMessage());
		}
	}
}
