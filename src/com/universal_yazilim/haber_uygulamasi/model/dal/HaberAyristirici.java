package com.universal_yazilim.haber_uygulamasi.model.dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.universal_yazilim.city_app.utility.EtiketAd;
import com.universal_yazilim.city_app.utility.Util;
import com.universal_yazilim.haber_uygulamasi.model.entity.Haber;

public class HaberAyristirici 
{
	private Haber suAnkiHaber;
	private List<Haber> haberListesi;
	private String baglantiRSS;

	public HaberAyristirici(String baglantiRSS) 
	{
		this.baglantiRSS = baglantiRSS;
	}
	
	public List<Haber> haberleriCek()
	{
		haberListesi = new ArrayList<Haber>();
		
		try
		{
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
			
			saxParser.parse(baglantiRSS, new HaberXMLHandler());
		}
		
		catch (ParserConfigurationException e)
		{
			Util.showGeneralExceptionInfo(e);
		}
		catch (SAXException e) 
		{
			Util.showGeneralExceptionInfo(e);
		}
		catch (IOException e)
		{
			Util.showGeneralExceptionInfo(e);
		}
		
		return haberListesi;
	}
	
	class HaberXMLHandler extends DefaultHandler
	{
		private boolean isItem;
		private boolean isTitle;
		private boolean isLink;
		private boolean isGuid;
		private boolean isDescription;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException 
		{
			if(qName.equals(EtiketAd.item.toString()))
			{
				isItem = true;
				suAnkiHaber = new Haber();
			}
			else if(qName.equals(EtiketAd.title.toString()))
			{
				isTitle = isItem;
				suAnkiHaber = new Haber();
			}
			else if(qName.equals(EtiketAd.link.toString()))
			{
				isLink = isItem;	
			}
			else if(qName.equals(EtiketAd.guid.toString()))
			{
				isGuid = isItem;
			}
			else if(qName.equals(EtiketAd.description.toString()))
			{
				isDescription = isItem;
			}
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException 
		{
			if(isTitle)
			{
				suAnkiHaber.setBaslik(new String(ch, start, length));
				isTitle = false;
			}
			else if(isLink)
			{
				suAnkiHaber.setBaglanti(new String(ch, start, length));
				isLink = false;
			}
			else if(isGuid)
			{
				suAnkiHaber.setKaynak(new String(ch, start, length));
				isGuid = false;
			}
			else if(isDescription)
			{
				suAnkiHaber.setAciklama(new String(ch, start, length));
				isDescription = false;
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException 
		{
			if(qName.equals(EtiketAd.item.toString()))
			{
				if(suAnkiHaber != null)	haberListesi.add(suAnkiHaber);
			}
		}
	}
}
