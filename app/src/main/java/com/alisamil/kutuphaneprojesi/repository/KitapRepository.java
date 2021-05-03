package com.alisamil.kutuphaneprojesi.repository;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import com.alisamil.kutuphaneprojesi.data.KitapDao;
import com.alisamil.kutuphaneprojesi.data.KutuphaneDatabase;
import com.alisamil.kutuphaneprojesi.model.Kitap;


import java.util.List;

public class KitapRepository {

    private KitapDao kitapDao;
    private LiveData<List<Kitap>> tumKitaplar;

    public KitapRepository(Application application)
    {
        KutuphaneDatabase database = KutuphaneDatabase.getDatabase(application);
        kitapDao = database.kitapDao();
        tumKitaplar = kitapDao.getTumKitaplariAl();
    }

    public void insertKitap(Kitap kitap)
    {
        new KitapRepository.InsertKitapAsyncTask(kitapDao).execute(kitap);

    }

    public LiveData<List<Kitap>> getTumKitaplar()
    {
        return tumKitaplar;
    }


    private static class InsertKitapAsyncTask extends AsyncTask<Kitap, Void, Void> {
        private KitapDao kitapDao;

        private InsertKitapAsyncTask(KitapDao kitapDao)
        {
            this.kitapDao = kitapDao;
        }

        @Override
        protected Void doInBackground(Kitap... kitaps) {
            kitapDao.insertKitap(kitaps[0]);
            return null;
        }
    }


}
