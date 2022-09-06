package com.mydemo.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;

public class Logger {
	


	
	  /**
	  *
	  */
	  

	      // The name of this Logger will be "org.apache.logging.Parent"
	      protected static final Logger parentLogger = (Logger) LogManager.getLogger();

	      private Logger logger = parentLogger;

	      protected Logger getLogger() {
	          return logger;
	      }

	      protected void setLogger(Logger logger) {
	          this.logger = logger;
	      }


	      public void log(Marker marker) {
	          //logger.log("Tracing");
	      }
	  }


