package com.livatec.webshop;

import java.util.Map;

import org.apache.commons.cli.ParseException;

public interface CommandLineArgumentsReader {
	Map<String, String> readCommandLineArguments(String [] args) throws ParseException, CommandLineArgumentException;
}
