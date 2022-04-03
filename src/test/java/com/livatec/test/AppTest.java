package com.livatec.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

import com.livatec.webshop.ArgumentsReader;
import com.livatec.webshop.BasePriceComponent;
import com.livatec.webshop.CommandLineArgumentException;
import com.livatec.webshop.CommandLineArgumentsReader;
import com.livatec.webshop.ConfigurationContext;
import com.livatec.webshop.ConfigurationContextFactory;
import com.livatec.webshop.PriceComponent;

public class AppTest {
	@Test
	public void simpleCalculation() throws ParseException, CommandLineArgumentException {
		String input = "23 199.95 book";
		String [] args = input.split(" ");
		ConfigurationContext context = ConfigurationContextFactory.createTestingConfigurationContext();
		CommandLineArgumentsReader cmdReader = new ArgumentsReader();
		Map<String,String> map = cmdReader.readCommandLineArguments(args);
		BasePriceComponent c = new PriceComponent();
		assertEquals("4698.85 DKK", c.calculate(map, context));
	}
	@Test
	public void simpleCalculationWithNoFreightAdded() throws ParseException, CommandLineArgumentException {
		String input = "23 199.95 online";
		String [] args = input.split(" ");
		ConfigurationContext context = ConfigurationContextFactory.createTestingConfigurationContext();
		CommandLineArgumentsReader cmdReader = new ArgumentsReader();
		Map<String,String> map = cmdReader.readCommandLineArguments(args);
		BasePriceComponent c = new PriceComponent();
		assertEquals("4598.85 DKK", c.calculate(map, context));
	}
	@Test
	public void advancedCalculations() throws CommandLineArgumentException, ParseException {
		String input = "12 139.95 book --output-currency=SEK --vat=DK";
		String [] args = input.split(" ");
		ConfigurationContext context = ConfigurationContextFactory.createTestingConfigurationContext();
		CommandLineArgumentsReader cmdReader = new ArgumentsReader();
		Map<String,String> map = cmdReader.readCommandLineArguments(args);
		BasePriceComponent c = new PriceComponent();
		assertEquals("3122.60 SEK", c.calculate(map, context));
	}

	@Test
	public void advancedCalculationWithInputCurrencySpecified() throws ParseException, CommandLineArgumentException {
		String input = "12 139.95 book --output-currency=SEK --input-currency=DKK --vat=DK";
		String [] args = input.split(" ");
		ConfigurationContext context = ConfigurationContextFactory.createTestingConfigurationContext();
		CommandLineArgumentsReader cmdReader = new ArgumentsReader();
		Map<String,String> map = cmdReader.readCommandLineArguments(args);
		BasePriceComponent c = new PriceComponent();
		assertEquals("3122.60 SEK", c.calculate(map, context));
	}
	@Test
	public void riseCommandLineArgumentsExceptio() {
		Exception e = assertThrows(CommandLineArgumentException.class, () -> {
			String input = "23.1 199.95 online";
			String [] args = input.split(" ");
			CommandLineArgumentsReader cmdReader = new ArgumentsReader();
			cmdReader.readCommandLineArguments(args);
		});
		
		String expectedMsg = "First argument appears not to be the valid amount of products!";
		assertTrue(e.getMessage().contains(expectedMsg));
	}

}
