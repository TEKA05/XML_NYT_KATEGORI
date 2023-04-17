package com.universal_yazilim.city_app.utility;

public enum Kategori {
    SCIENCE("Science"),

    WORLD("World") ,


    SPORTS("Sports"),

    TECHNOLOGY("Technology");


    private String kategori;

    private Kategori(String kategori) {this.kategori = kategori;}

    public String getKategori() {
        return kategori;
    }
}
