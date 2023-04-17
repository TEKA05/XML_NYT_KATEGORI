package com.universal_yazilim.haber_uygulamasi.model.entity;

public class Haber 
{
	private String baslik;
	private String aciklama;
	private String baglanti;
	private String kaynak;
	
	public String getBaslik() {
		return baslik;
	}
	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}
	public String getAciklama() {
		return aciklama;
	}
	
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	public String getBaglanti() {
		return baglanti;
	}
	
	public void setBaglanti(String baglanti) {
		this.baglanti = baglanti;
	}
	
	public String getKaynak() {
		return kaynak;
	}
	
	public void setKaynak(String kaynak) {
		this.kaynak = kaynak;
	}
	@Override
	public String toString() {
		return "Haber [baslik=" + baslik + ", aciklama=" + aciklama + ", baglanti=" + baglanti + ", kaynak=" + kaynak
				+ "]\n";
	}	
}
