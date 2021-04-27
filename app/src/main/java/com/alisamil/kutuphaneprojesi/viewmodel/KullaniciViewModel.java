package com.alisamil.kutuphaneprojesi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.alisamil.kutuphaneprojesi.model.Kullanici;
import com.alisamil.kutuphaneprojesi.repository.KullaniciRepository;

import java.util.List;

public class KullaniciViewModel extends AndroidViewModel {

    private KullaniciRepository repository;
    private LiveData<List<Kullanici>> tumKullanicilar;

    public KullaniciViewModel(@NonNull Application application) {
        super(application);
        repository = new KullaniciRepository(application);
        tumKullanicilar = repository.getTumKullanicilar();
    }

    public void insertKullanici(Kullanici kullanici){
        repository.insertKullanici(kullanici);
    }

    public LiveData<List<Kullanici>> getTumKullanicilar(){
        return tumKullanicilar;
    }

}
