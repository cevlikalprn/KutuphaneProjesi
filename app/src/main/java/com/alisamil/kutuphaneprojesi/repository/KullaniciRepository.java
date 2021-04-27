package com.alisamil.kutuphaneprojesi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.alisamil.kutuphaneprojesi.data.KutuphaneDao;
import com.alisamil.kutuphaneprojesi.data.KutuphaneDatabase;
import com.alisamil.kutuphaneprojesi.model.Kullanici;

public class KullaniciRepository {

    private KutuphaneDao kutuphaneDao;
    //private LiveData<List<Test>> allTests;

    public KullaniciRepository(Application application)
    {
        KutuphaneDatabase database = KutuphaneDatabase.getDatabase(application);
        kutuphaneDao = database.kutuphaneDao();
        //allTest = kutuphaneDao.getAllTests();
    }

    public void insertKullanici(Kullanici kullanici)
    {
        new InsertKullaniciAsyncTask(kutuphaneDao).execute(kullanici);

    }

    private static class InsertKullaniciAsyncTask extends AsyncTask<Kullanici, Void, Void> {
        private KutuphaneDao kutuphaneDao;

        private InsertKullaniciAsyncTask(KutuphaneDao kutuphaneDao)
        {
            this.kutuphaneDao = kutuphaneDao;
        }

        @Override
        protected Void doInBackground(Kullanici... kullanicis) {
            kutuphaneDao.insertKullanici(kullanicis[0]);
            return null;
        }
    }




    /*
    public LiveData<List<Test>> getAllTests()
    {
        return allTests;
    }
     */

}
