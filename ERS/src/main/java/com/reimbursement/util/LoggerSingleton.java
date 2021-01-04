package com.reimbursement.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerSingleton {
	
	private static Logger ersLogger = LogManager.getLogger("ers");
	
	public static Logger getLogger() {
		return ersLogger;
	}

}

