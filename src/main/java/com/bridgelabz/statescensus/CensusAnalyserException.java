package com.bridgelabz.statescensus;


public class CensusAnalyserException extends RuntimeException {

	enum ExceptionType {
		NO_SUCH_FILE, TYPE_INCORRECT, IO_EXCEPTION
	}
	ExceptionType type;
	
	public CensusAnalyserException() {
		
	}
	
	public CensusAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
