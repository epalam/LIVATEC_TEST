package com.livatec.webshop;

import java.util.Map;

import org.apache.commons.cli.ParseException;

/**
 * Task 1
Your first task is to build a component for calculating a price. The component must be able to take
amount and price as well as a type to determine if freight should be added on top of the price.
For demonstration a sample Java command line could look like this:
java -jar webshop.jar <amount> <price> <type>
Where:
• <amount> is the amount of products
• <price> is the product cost in DKK
• <type> is a product identifier to determine if freight should be added. For testing purposes
this can only be online or book and all calculations of type book needs freight to be added to
the price.
The calculation is as follows:
Total price = amount x price + freight
Freight depends on the amount of products.
• Up to and including 10 items: 50,-
• For each additional 10 items: 25,-
Example:
input: java -jar webshop.jar 23 199.95 book
output: 4698.85 DKK

Task 2
The first task only describes the very basics of the price calculation and does not take local factors
into account such as currency, VAT or local freight costs. To adjust the calculation for these
customer and area specific factors, the second task is to add support for optional price adjustments.
For demonstration a sample Java command line could look like this:
java -jar webshop.jar <amount> <price> <type> [<custom> ...]
Where:
• <amount> is the amount of products
• <price> is the product cost in DKK unless otherwise specified
• <type> is a product identifier to determine if freight should be added. All calculations of
type book should have freight added
• [<custom> ...] Zero or more parameters of the format <name>=<value>
For the test we only assume --vat=<country code>, --input-currency=<currency code>
and/or --output-currency=<currency code> can be supplied.
For customer systems different default values applies. In this example DKK is set to default
currency with 0% VAT

	Area Country codes Type VAT rate
	Scandinavia DK, NO, SE All 25
	Great Britain GB All 20
	Germany DE Online 19
	Germany DE Book 12
	The currency at this specific time is:
	Currency code Rate
	DKK (default) 100
	NOK 73.50
	SEK 70.23
	GBP 891.07
	EUR 743.93
Example:
input: java -jar webshop.jar 12 139.95 book –output-currency=SEK --vat=DK
output: 3122.60 SEK
As --input-currency is not specified we default to DKK.
 * 
 * @author Eugene Palamarchuk
 *
 */
public class Main {
	public static void main(String [] args) {
//		BasePriceComponent component = new PriceComponent();
//		System.out.println(component.calculate(args, 
//				ConfigurationContextFactory.createTestingConfigurationContext()));
		
		
		CommandLineArgumentsReader cmdReader = new ArgumentsReader();
		try {
			PriceComponent component = new PriceComponent();
			Map<String,String> map = cmdReader.readCommandLineArguments(args);
			System.out.println(component.calculate(map, 
			ConfigurationContextFactory.createTestingConfigurationContext()));
			
		} catch (ParseException | CommandLineArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
