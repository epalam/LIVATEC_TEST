package com.livatec.webshop;

import java.util.Map;

/**
 * Describes functions of price component
 * @author Eugene Palamarchuk
 *
 */
public interface BasePriceComponent {
	String calculate(Map<String,String> map, ConfigurationContext context) throws CommandLineArgumentException;
}
