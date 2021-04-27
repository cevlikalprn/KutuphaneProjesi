package com.alisamil.kutuphaneprojesi.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alisamil.kutuphaneprojesi.model.Kullanici;

@Database(entities = {Kullanici.class}, version = 1)
public abstract class KutuphaneDatabase extends RoomDatabase {

    public abstract KutuphaneDao kutuphaneDao();

    private static KutuphaneDatabase INSTANCE;

    public static synchronized KutuphaneDatabase getDatabase(Context context)
    {
        if(INSTANCE == null)
        {
           INSTANCE = Room.databaseBuilder(
                   context.getApplicationContext(),
                   KutuphaneDatabase.class,
                   "kutuphane_db")
                   .fallbackToDestructiveMigration()
                   .build();
        }
        return INSTANCE;
    }

}
