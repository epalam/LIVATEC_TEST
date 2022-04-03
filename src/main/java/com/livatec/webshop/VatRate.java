package com.livatec.webshop;
/**
 * Country specific VAT Rate  
 * @author Eugene Palamarchuk
 *
 */
public class VatRate {
	private String countryCode;
	private String area;
	private String type;
	private float vatRate;
	
	public VatRate(String countryCode, String area, String type, float vatRate) {
		this.countryCode = countryCode;
		this.setArea(area);
		this.type = type;
		this.vatRate = vatRate;
	}
	/**
	 * Contry code
	 * @return {@link String}
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * Sets country code
	 * @param countryCode {@link String}
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * VAT for type for goods
	 * @return {@link String}
	 */
	public String getType() {
		return type;
	}
	/**
	 * Sets VAT type for goods 
	 * @param type {@link String}
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * VAT rate
	 * @return float
	 */
	public float getVatRate() {
		return vatRate;
	}
	/**
	 * Sets VAT rate
	 * @param vatRate
	 */
	public void setVatRate(float vatRate) {
		this.vatRate = vatRate;
	}
	/**
	 * Area name
	 * @return {@link String}
	 */
	public String getArea() {
		return area;
	}
	/**
	 * Sets area name
	 * @param area {@link String}
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
}
