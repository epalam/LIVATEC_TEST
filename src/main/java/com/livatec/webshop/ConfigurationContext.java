package com.livatec.webshop;

import java.util.List;
import java.util.Map;
/**
 * Configuration context is supposed to provide all the details
 * about referrenced data such as VAT rates, currency rates
 * @author Eugene Palamarchuk
 *
 */
public abstract class ConfigurationContext {
	public abstract List<VatRate> getVATRateList();
	public abstract Map<String,CurrencyRate> getCurrencyRateMap();
}
