package com.alisamil.kutuphaneprojesi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.alisamil.kutuphaneprojesi.model.Kullanici;
import com.alisamil.kutuphaneprojesi.repository.KullaniciRepository;

public class KullaniciViewModel extends AndroidViewModel {

    private KullaniciRepository repository;
    //private LiveData<List<Test>> allTests;

    public KullaniciViewModel(@NonNull Application application) {
        super(application);
        repository = new KullaniciRepository(application);
        //allTests = repository.getAllTests();
    }

    public void insertKullanici(Kullanici kullanici){
        repository.insertKullanici(kullanici);
    }
/*
    public LiveData<List<Test>> getAllTests(){
        return allTests;
    }

 */
}
