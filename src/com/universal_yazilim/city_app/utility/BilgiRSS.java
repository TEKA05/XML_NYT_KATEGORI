package com.universal_yazilim.city_app.utility;

public enum BilgiRSS 
{
	ANA_BAGLANTI("https://rss.nytimes.com/services/xml/rss/nyt/"),
	
	UZANTI(".xml");
	
	//KATEGORI_BILIM("Science");
	
	private String deger;

	private BilgiRSS(String deger) {
		this.deger = deger;
	}

	public String getDeger() {
		return deger;
	}
}
