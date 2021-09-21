package com.bridgelabz.statescensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public static int loadDataToIterator(String csvFilePath) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {

			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();

			List<CSVStateCensus> myIterator = csvToBean.parse();
			return myIterator.size();
		}
	}

}