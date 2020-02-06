package com.nandhu.impl;



public class Logger {

	 public static Logger getInstance() {
	        Logger logger = new Logger();
	        return logger;
	    }
	     
	    public static void debug(Object message) {
	        System.out.println(message);
	    }
}
