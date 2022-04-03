package com.livatec.webshop;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ArgumentsReader implements CommandLineArgumentsReader{

	@Override
	public Map<String, String> readCommandLineArguments(String[] args)
			throws ParseException, CommandLineArgumentException {
		Map<String,String> argMap = new HashMap<>();
		
		Options options = new Options();
		
		Option output_currency_option = new Option("o", "output-currency", true, "Output currency code");
		output_currency_option.setRequired(false);
		options.addOption(output_currency_option);

		Option vat_code_option = new Option("v", "vat", true, "Country code");
		vat_code_option.setRequired(false);
		options.addOption(vat_code_option);

		Option input_currency_option = new Option("i", "input-currency", true, "Input currency code");
		input_currency_option.setRequired(false);
		options.addOption(input_currency_option);

		CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        String amount = null;
        String price = null;
        String type = null;
    	
        cmd = parser.parse(options, args);

    	if (cmd.getArgList().size() < 3) throw new CommandLineArgumentException("Wrong number of arguments");

    	if (cmd.getArgList().get(0).matches("[0-9]+")) {
    		amount = cmd.getArgList().get(0);
    	} else {
    		throw new CommandLineArgumentException("First argument appears not to be the valid amount of products!");
    	}

    	if (cmd.getArgList().get(1).matches("[0-9]+|[0-9]+.[0-9]{1,2}")) {
    		price = cmd.getArgList().get(1);
    	} else {
    		throw new CommandLineArgumentException("Second argument appears not to be the valid product price!");
    	}

    	type = cmd.getArgList().get(2);

    	String output_currency_code = cmd.getOptionValue("output-currency");
        String input_currency_code = cmd.getOptionValue("input-currency");
        String vat_code = cmd.getOptionValue("vat");

    	argMap.put("amount", amount);
    	argMap.put("price", price);
    	argMap.put("type", type);
    	if (output_currency_code != null) argMap.put("output-currency", output_currency_code);
    	if (input_currency_code != null) argMap.put("input-currency", input_currency_code);
    	if (vat_code != null) argMap.put("vat_code", vat_code);
    	
		return argMap;
	}

}
