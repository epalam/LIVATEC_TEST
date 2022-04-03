package com.livatec.webshop;
/**
 * Currency rate
 * @author Eugene Palamarchuk
 *
 */
public class CurrencyRate {

	private String currencyCode;
	private float rate;
	
	public CurrencyRate(String currencyCode, float rate) {
		this.setCurrencyCode(currencyCode);
		this.setRate(rate);
	}

	/**
	 * Currency code
	 * @return {@link String}
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Sets currency code
	 * @param currencyCode {@link String}
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Currency rate
	 * @return float
	 */
	public float getRate() {
		return rate;
	}

	/**
	 * Sets currency rate
	 * @param rate float
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
}
