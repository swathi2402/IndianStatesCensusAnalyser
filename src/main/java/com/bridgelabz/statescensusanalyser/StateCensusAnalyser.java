package com.bridgelabz.statescensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public static int loadDataToIterator(String csvFilePath) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {

			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();

			List<CSVStateCensus> myIterator = csvToBean.parse();
			return myIterator.size();

		} catch (NoSuchFileException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, "No such file exits");
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.TYPE_INCORRECT, "Incorrect delimiter");
		} catch (IOException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.IO_EXCEPTION,
					"IO related exception");
		}

	}

}
