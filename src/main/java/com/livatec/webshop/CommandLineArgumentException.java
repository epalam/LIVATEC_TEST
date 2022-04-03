package com.livatec.webshop;
/**
 * Exception to handle command line arguments
 * 
 * @author Eugene Palamarchuk
 *
 */
public class CommandLineArgumentException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandLineArgumentException(String msg) {
		super(msg);
	}
}
