package com.alisamil.kutuphaneprojesi.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.alisamil.kutuphaneprojesi.model.Kitap;
import com.alisamil.kutuphaneprojesi.repository.KitapRepository;


import java.util.List;

public class KitapViewModel extends AndroidViewModel {

    private KitapRepository repository;
    private LiveData<List<Kitap>> tumKitaplar;

    public KitapViewModel(@NonNull Application application) {
        super(application);
        repository = new KitapRepository(application);
        tumKitaplar = repository.getTumKitaplar();
    }

    public void insertKitap(Kitap kitap){
        repository.insertKitap(kitap);
    }

    public LiveData<List<Kitap>> getTumKitaplar(){
        return tumKitaplar;
    }


}
