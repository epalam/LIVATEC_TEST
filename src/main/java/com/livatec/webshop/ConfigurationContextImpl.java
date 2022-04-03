package com.livatec.webshop;

import java.util.List;
import java.util.Map;
/**
 * 
 * Configuration context 
 * @author Eugene Palamarchuk
 *
 */
public class ConfigurationContextImpl extends ConfigurationContext{

	private List<VatRate> vatRateList;
	private Map<String,CurrencyRate>currencyRateMap;
	public ConfigurationContextImpl(List<VatRate> vatRateList, Map<String,CurrencyRate>currencyRateMap) {
		this.vatRateList = vatRateList;
		this.currencyRateMap = currencyRateMap;
	}
	
	@Override
	public List<VatRate> getVATRateList() {
		return vatRateList;
	}

	@Override
	public Map<String, CurrencyRate> getCurrencyRateMap() {
		return currencyRateMap;
	}

}
