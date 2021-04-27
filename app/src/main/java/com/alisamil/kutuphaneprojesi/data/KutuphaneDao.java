package com.alisamil.kutuphaneprojesi.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alisamil.kutuphaneprojesi.model.Kullanici;

import java.util.List;

@Dao
public interface KutuphaneDao {

    @Insert
    void insertKullanici(Kullanici kullanici);

    @Query("SELECT * FROM kullanici_table")
    LiveData<List<Kullanici>> getTumKullanicilariAl();



    /*
    @Update
    void update(Test test)

    @Delete
    void update(Test test)

    @Query("DELETE FROM test_table")
    void deleteAllTest()

    @Query("SELECT * FROM test_table ORDER BY test DESC")
    LiveData<List<Test>> getAllTests()
     */



}
