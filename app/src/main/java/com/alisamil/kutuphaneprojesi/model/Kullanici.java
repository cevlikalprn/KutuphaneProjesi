package com.alisamil.kutuphaneprojesi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kullanici_table")
public class Kullanici {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kullanici_adi")
    private String kullaniciAdi;

    @ColumnInfo(name = "kullanici_sifre")
    private String kullaniciSifre;

    public Kullanici(String kullaniciAdi, String kullaniciSifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSifre = kullaniciSifre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }
}


