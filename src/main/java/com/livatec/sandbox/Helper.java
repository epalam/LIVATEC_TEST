package com.livatec.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.livatec.webshop.CurrencyRate;
import com.livatec.webshop.VatRate;

public class Helper {

	public static void main(String[] args) {
		List<VatRate> list = new ArrayList<>();
		
		list.add(new VatRate("DK", "Scandinavia", "All", 25));
		list.add(new VatRate("NO", "Scandinavia", "All", 25));
		list.add(new VatRate("SE", "Scandinavia", "All", 25));
		list.add(new VatRate("GB", "Great Britain", "All", 20));
		list.add(new VatRate("DE", "Germany", "Online", 19));
		list.add(new VatRate("DE", "Germany", "Book", 12));
		
		
		VatRate vatRate = list.stream().filter(v -> "DE".equalsIgnoreCase(v.getCountryCode()) && "Book".equalsIgnoreCase(v.getType()))
				.findAny().orElse(null);
		List<String> validTypes = list.stream().map(VatRate::getType).collect(Collectors.toList());
		boolean isExist = list.stream().filter(v -> v.getType().equalsIgnoreCase("book")).findFirst().isPresent();
		System.out.println(vatRate.getType() + "\t" + isExist);

//		XStream xstream = new XStream(new DomDriver());
//		BufferedWriter out = new BufferedWriter(new FileWriter(path + "\\drd_config.xml"));
//        out.write(xstream.toXML(list));
//        out.close();
	
		List<CurrencyRate> listOfRates = new ArrayList<>();
		listOfRates.add(new CurrencyRate("DKK",100.0f));
		listOfRates.add(new CurrencyRate("NOK",73.50f));
		listOfRates.add(new CurrencyRate("SEK",70.23f));
		listOfRates.add(new CurrencyRate("GBP",891.07f));
		listOfRates.add(new CurrencyRate("EUR",743.93f));
		
		
		
		String input = "12 139.95 book –output-currency=SEK --vat=DK";
		String [] a = input.split(" ");
		for (String s : a) {
			System.out.println(s);
		}

	}
}
