package com.alisamil.kutuphaneprojesi.data;

import androidx.room.Dao;
import androidx.room.Insert;

import com.alisamil.kutuphaneprojesi.model.Kullanici;

@Dao
public interface KutuphaneDao {

    @Insert
    void insertKullanici(Kullanici kullanici);





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
