package com.livatec.webshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Designed to constract the configuration context 
 * 
 * @author Eugene Palamarchuk
 *
 */
public class ConfigurationContextFactory {

	public static ConfigurationContext createTestingConfigurationContext() {
		List<VatRate> vatRateList = new ArrayList<>();
		Map<String,CurrencyRate>currencyRateMap = new HashMap<>();

		vatRateList.add(new VatRate("DK", "Scandinavia", "Online", 25));
		vatRateList.add(new VatRate("DK", "Scandinavia", "Book", 25));
		vatRateList.add(new VatRate("NO", "Scandinavia", "Online", 25));
		vatRateList.add(new VatRate("NO", "Scandinavia", "Book", 25));
		vatRateList.add(new VatRate("SE", "Scandinavia", "Online", 25));
		vatRateList.add(new VatRate("SE", "Scandinavia", "Book", 25));
		vatRateList.add(new VatRate("GB", "Great Britain", "Online", 20));
		vatRateList.add(new VatRate("GB", "Great Britain", "Book", 20));
		vatRateList.add(new VatRate("DE", "Germany", "Online", 19));
		vatRateList.add(new VatRate("DE", "Germany", "Book", 12));

		currencyRateMap.put("DKK", new CurrencyRate("DKK",100.0f));
		currencyRateMap.put("NOK", new CurrencyRate("NOK",73.50f));
		currencyRateMap.put("SEK", new CurrencyRate("SEK",70.23f));
		currencyRateMap.put("GBP", new CurrencyRate("GBP",891.07f));
		currencyRateMap.put("EUR", new CurrencyRate("EUR",743.93f));
		
		
		return new ConfigurationContextImpl(vatRateList, currencyRateMap); 
	}
}
