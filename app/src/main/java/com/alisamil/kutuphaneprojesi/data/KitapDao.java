package com.alisamil.kutuphaneprojesi.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alisamil.kutuphaneprojesi.model.Kitap;
import java.util.List;

@Dao
public interface KitapDao {

    @Insert
    void insertKitap(Kitap kitap);

    @Query("SELECT * FROM kitap_table")
    LiveData<List<Kitap>> getTumKitaplariAl();

}
