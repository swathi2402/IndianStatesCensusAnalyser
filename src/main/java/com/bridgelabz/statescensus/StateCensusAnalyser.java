package com.bridgelabz.statescensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

	public static int loadDataToIterator(String csvFilePath, Object myclass) throws CensusAnalyserException {
		try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {

			CsvToBeanBuilder<Object> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType((Class) myclass);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<Object> csvToBean = csvToBeanBuilder.build();

			List<Object> myIterator = csvToBean.parse();
			return myIterator.size();

		} catch (NoSuchFileException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.NO_SUCH_FILE, "No such file exits");
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.TYPE_INCORRECT,
					"Incorrect delimiter or Incorrect file extention or Incorrect header");
		} catch (IOException e) {
			throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.IO_EXCEPTION,
					"IO related exception");
		}

	}

}
