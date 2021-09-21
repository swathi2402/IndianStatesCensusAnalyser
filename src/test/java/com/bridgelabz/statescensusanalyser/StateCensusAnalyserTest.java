package com.bridgelabz.statescensusanalyser;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyserTest {

	public static final String CSV_FILE_PATH = "./StateCensus.csv";

	@Test
	public void GivenStateCensusCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
		int count = StateCensusAnalyser.loadDataToIterator(CSV_FILE_PATH);
		Assert.assertEquals(29, count);

	}
}
