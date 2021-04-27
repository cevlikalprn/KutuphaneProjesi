package com.alisamil.kutuphaneprojesi.view.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alisamil.kutuphaneprojesi.R;


public class KitapGoruntuleFragment extends Fragment {




    public KitapGoruntuleFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitap_goruntule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int id=KitapGoruntuleFragmentArgs.fromBundle(getArguments()).getId();
        try {
            SQLiteDatabase database = getContext().openOrCreateDatabase("Kitap", Context.MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS kitaplar(id INTEGER PRIMARY KEY, isim VARCHAR, yazar VARCHAR, ozet VARCHAR, adet VARCHAR)");
            Cursor cursor = database.rawQuery("SELECT * FROM kitaplar WHERE id="+id, null);

            int idIx = cursor.getColumnIndex("id");
            int isimIx = cursor.getColumnIndex("isim");
            int yazarIx = cursor.getColumnIndex("yazar");
            int ozetIx = cursor.getColumnIndex("ozet");
            int adetIx = cursor.getColumnIndex("adet");

            while (cursor.moveToNext()) {
                String idString=Integer.toString(idIx);
                String isim = cursor.getString(isimIx);
                TextView kitapAdi=view.findViewById(R.id.kitapGoruntuleKitapAdi);
                kitapAdi.setText("Kitap Adı: "+isim);
                String yazar = cursor.getString(yazarIx);
                TextView yazarAdi=view.findViewById(R.id.kitapGoruntuleKitapYazari);
                yazarAdi.setText("Kitap Yazarı: "+yazar);
                String ozet = cursor.getString(ozetIx);
                TextView ozetText=view.findViewById(R.id.kitapGoruntuleKitapOzeti);
                ozetText.setText("Kitap Özeti: "+ozet);
                String adet = cursor.getString(adetIx);



            }
        }catch (Exception e){

            e.printStackTrace();
        }


        ImageView imageView1=view.findViewById(R.id.imageView6);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections action=KitapGoruntuleFragmentDirections.actionKitapGoruntuleFragmentToMainFragment();
                Navigation.findNavController(v).navigate(action);

            }
        });


    }
}