package com.alisamil.kutuphaneprojesi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "kitap_table")
public class Kitap implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kitap_adi")
    private String kitapAdi;

    @ColumnInfo(name = "yazar_adi")
    private String kitapYazariAdi;

    @ColumnInfo(name = "kitap_kategori")
    private int kitapKategori;

    @ColumnInfo(name = "kitap_adedi")
    private int kitapAdedi;

    @ColumnInfo(name = "kitap_ozeti")
    private String kitapOzeti;


    public Kitap(String kitapAdi, String kitapYazariAdi, int kitapKategori, int kitapAdedi, String kitapOzeti) {
        this.kitapAdi = kitapAdi;
        this.kitapYazariAdi = kitapYazariAdi;
        this.kitapKategori = kitapKategori;
        this.kitapAdedi = kitapAdedi;
        this.kitapOzeti = kitapOzeti;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapYazariAdi() {
        return kitapYazariAdi;
    }

    public void setKitapYazariAdi(String kitapYazariAdi) {
        this.kitapYazariAdi = kitapYazariAdi;
    }

    public int getKitapKategori() {
        return kitapKategori;
    }

    public void setKitapKategori(int kitapKategori) {
        this.kitapKategori = kitapKategori;
    }

    public int getKitapAdedi() {
        return kitapAdedi;
    }

    public void setKitapAdedi(int kitapAdedi) {
        this.kitapAdedi = kitapAdedi;
    }

    public String getKitapOzeti() {
        return kitapOzeti;
    }

    public void setKitapOzeti(String kitapOzeti) {
        this.kitapOzeti = kitapOzeti;
    }
}
