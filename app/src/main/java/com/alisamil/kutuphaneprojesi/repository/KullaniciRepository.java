package com.alisamil.kutuphaneprojesi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.alisamil.kutuphaneprojesi.data.KullaniciDao;
import com.alisamil.kutuphaneprojesi.data.KutuphaneDatabase;
import com.alisamil.kutuphaneprojesi.model.Kullanici;

import java.util.List;

public class KullaniciRepository {

    private KullaniciDao kullaniciDao;
    private LiveData<List<Kullanici>> tumKullanicilar;

    public KullaniciRepository(Application application)
    {
        KutuphaneDatabase database = KutuphaneDatabase.getDatabase(application);
        kullaniciDao = database.kutuphaneDao();
        tumKullanicilar = kullaniciDao.getTumKullanicilariAl();
    }

    public void insertKullanici(Kullanici kullanici)
    {
        new InsertKullaniciAsyncTask(kullaniciDao).execute(kullanici);

    }

    public LiveData<List<Kullanici>> getTumKullanicilar()
    {
        return tumKullanicilar;
    }

    private static class InsertKullaniciAsyncTask extends AsyncTask<Kullanici, Void, Void> {
        private KullaniciDao kullaniciDao;

        private InsertKullaniciAsyncTask(KullaniciDao kullaniciDao)
        {
            this.kullaniciDao = kullaniciDao;
        }

        @Override
        protected Void doInBackground(Kullanici... kullanicis) {
            kullaniciDao.insertKullanici(kullanicis[0]);
            return null;
        }
    }
}
