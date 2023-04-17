package com.universal_yazilim.haber_uygulamasi.program;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.universal_yazilim.city_app.utility.BilgiRSS;
import com.universal_yazilim.city_app.utility.Kategori;
import com.universal_yazilim.city_app.utility.Util;
import com.universal_yazilim.haber_uygulamasi.model.dal.HaberAyristirici;
import com.universal_yazilim.haber_uygulamasi.model.entity.Haber;

import javax.swing.*;

public class Main
{

	public static void main(String[] args) 
	{
		JFrame f = new JFrame("Incelemek Istediginiz NYT Kategorisini Seciniz");
		JButton btn = new JButton();
		btn.setText("SCIENCE");
		btn.setBounds(180,0,100,30);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kategoriad = String.valueOf(Kategori.SCIENCE);

				String baglantiBilim = BilgiRSS.ANA_BAGLANTI.getDeger()
					+ kategoriad
						+ BilgiRSS.UZANTI.getDeger();

				HaberAyristirici haberAyristirici1 = new HaberAyristirici(baglantiBilim);

				List<Haber> haberler1 = haberAyristirici1.haberleriCek();

				Util.showList(haberler1);
			}
		});

		JButton btn2 = new JButton();
		btn2.setText("WORLD");
		btn2.setBounds(180,35,100,30);

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kategoriad = String.valueOf(Kategori.WORLD);

				String baglantiBilim = BilgiRSS.ANA_BAGLANTI.getDeger()
						+ kategoriad
						+ BilgiRSS.UZANTI.getDeger();

				HaberAyristirici haberAyristirici1 = new HaberAyristirici(baglantiBilim);

				List<Haber> haberler1 = haberAyristirici1.haberleriCek();

				Util.showList(haberler1);
			}
		});



		JButton btn3 = new JButton();
		btn3.setText("SPORTS");
		btn3.setBounds(180,70,100,30);

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kategoriad = String.valueOf(Kategori.SPORTS);

				String baglantiBilim = BilgiRSS.ANA_BAGLANTI.getDeger()
						+ kategoriad
						+ BilgiRSS.UZANTI.getDeger();

				HaberAyristirici haberAyristirici1 = new HaberAyristirici(baglantiBilim);

				List<Haber> haberler1 = haberAyristirici1.haberleriCek();

				Util.showList(haberler1);
			}
		});

		JButton btn4 = new JButton();
		btn4.setText("TECHNOLOGY");
		btn4.setBounds(180,105,100,30);

		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kategoriad = String.valueOf(Kategori.TECHNOLOGY);

				String baglantiBilim = BilgiRSS.ANA_BAGLANTI.getDeger()
						+ kategoriad
						+ BilgiRSS.UZANTI.getDeger();

				HaberAyristirici haberAyristirici1 = new HaberAyristirici(baglantiBilim);

				List<Haber> haberler1 = haberAyristirici1.haberleriCek();

				Util.showList(haberler1);
			}
		});
		f.add(btn);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.setSize(550,200);
		f.setLayout(null);
		f.setVisible(true);

	}

}
