package com.bridgelabz.statescensusanalyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

	public static final String CSV_FILE_PATH = "./StateCensus.csv";
	public static final String NO_PATH = "./StateCensu.csv";

	@Test
	public void GivenStateCensusCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {

		int count = StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH);
		Assert.assertEquals(29, count);

	}
	
	@Test
    public void GivenStateCensusCsvFile_IfInCorrect_ShouldThrowException() {
        try {
        	StateCensusAnalyser.loadDataToIterator(NO_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, e.type);
            System.out.println(e.getMessage());
        }
    }
}
