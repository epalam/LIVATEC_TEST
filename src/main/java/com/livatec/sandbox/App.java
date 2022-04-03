package com.livatec.sandbox;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

    	int amount = 12;
    	float price = 139.95f;
    	
    	float vat = 25f;
    	float dkk = 100f;
    	float sek = 70.23f;

    	float total = amount * price;

    	float freight = 50;
    	amount -= 10;
    	int n = amount/10;
    	freight += 25*n;
    	if (amount%10 > 0) freight += 25;
    	
    	total += freight;
    	float vat_value = 0;
    	if (vat > 0) {
        	vat_value = total*vat/100;
        	total += vat_value;
    		total = total*dkk/sek;
    	}
    	System.out.println(total + "\t" + freight + "\t" + vat_value);
    
    }
}
