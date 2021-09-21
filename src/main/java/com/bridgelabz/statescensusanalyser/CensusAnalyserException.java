package com.bridgelabz.statescensusanalyser;


public class CensusAnalyserException extends RuntimeException {

	enum ExceptionType {
		NO_SUCH_FILE
	}
	ExceptionType type;
	
	public CensusAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
