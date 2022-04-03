package com.livatec.webshop;

import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Implementation of price component that does both simple and advanced calculation
 * @author Eugene Palamarchuk
 *
 */
public class PriceComponent implements BasePriceComponent{
	@Override
	public String calculate(Map<String,String> map, ConfigurationContext context) throws CommandLineArgumentException {

		List<VatRate> listVatRates = context.getVATRateList();
    	Map<String,CurrencyRate> currencyRateMap = context.getCurrencyRateMap();
 
    	final String type = map.get("type");
		int amount        = Integer.valueOf(map.get("amount"));
		float price       = Float.valueOf(map.get("price"));
        String output_currency_code = map.get("output-currency");
        String input_currency_code  = map.get("input-currency");
        String vat_value = map.get("vat_code");

    	boolean isTypeExist = listVatRates.stream().filter(v -> v.getType().equalsIgnoreCase(type)).findFirst().isPresent();
		if (!isTypeExist) throw new CommandLineArgumentException("Unsupported type: " + type);
        
        CurrencyRate defaultRate = null;
        if (input_currency_code != null) {
            defaultRate = currencyRateMap.get(input_currency_code);
            if (defaultRate == null) throw new CommandLineArgumentException("Unsupported input currency code: " + input_currency_code);
        } else {
            defaultRate = currencyRateMap.get("DKK");
        	
        }

        CurrencyRate currentRate = currencyRateMap.get(output_currency_code);
        

        
    	float total = amount * price;

    	float freight = 50;
    	amount -= 10;
    	int n = amount/10;
    	freight += 25*n;
    	if (amount%10 > 0) freight += 25;

    	if (type.equalsIgnoreCase("book")) total += freight; //ADD FRREIGHT FOR THOSE BELONGS TO BOOK TYPE

    	/*
    	 * Return total of simple price calculation
    	 */
        if (vat_value == null && output_currency_code == null) {
        	return String.format("%.2f", total) + " DKK"; 
        }


        if (currentRate == null) throw new CommandLineArgumentException("Unsupported output currency code: " + output_currency_code);
        
        VatRate vatRate = listVatRates.stream().filter(v -> vat_value.equalsIgnoreCase(v.getCountryCode()) && type.equalsIgnoreCase(v.getType()))
				.findAny().orElse(null);
    	if (vatRate == null) throw new CommandLineArgumentException("Unsupported country code: " + vat_value);

        float vat_amount = 0;
    	if (vatRate.getVatRate() > 0) {
    		vat_amount = total*vatRate.getVatRate()/100;
        	total += vat_amount;
    		total = total*defaultRate.getRate()/currentRate.getRate();
    		return String.format("%.2f", total) + " " + currentRate.getCurrencyCode();
    	}

		return null;
	}
}
