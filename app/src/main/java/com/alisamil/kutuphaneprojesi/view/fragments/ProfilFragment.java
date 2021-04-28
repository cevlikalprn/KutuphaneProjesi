package com.alisamil.kutuphaneprojesi.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.view.adapters.AnaEkranAdapter;
import com.alisamil.kutuphaneprojesi.view.adapters.ProfilAdapter;

import java.util.ArrayList;


public class ProfilFragment extends Fragment {



    public ProfilFragment() {
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
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences= getActivity().getSharedPreferences("kullanici", Context.MODE_PRIVATE);
        String kullaniciAdi=sharedPreferences.getString("username","");

        TextView textView=view.findViewById(R.id.profilKullaniciAdi);
        textView.setText("Hoşgeldiniz " +kullaniciAdi);



        ArrayList<String> isimArray = new ArrayList<String>();
        ArrayList<String> yazarArray = new ArrayList<String>();
        ArrayList<String> ozetArray = new ArrayList<String>();

        SQLiteDatabase database=getContext().openOrCreateDatabase("Kitap",Context.MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("SELECT * FROM kullaniciKitap" , null);
        int isimIx = cursor.getColumnIndex("isim");
        int yazarIx = cursor.getColumnIndex("yazar");
        int ozetIx = cursor.getColumnIndex("ozet");
        while (cursor.moveToNext()) {
            String isim = cursor.getString(isimIx);
            String yazar = cursor.getString(yazarIx);
            String ozet = cursor.getString(ozetIx);

            isimArray.add(isim);
            yazarArray.add(yazar);
            ozetArray.add(ozet);
        }

        RecyclerView recyclerView=view.findViewById(R.id.profil_recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ProfilAdapter adapter= new ProfilAdapter(isimArray,yazarArray,ozetArray);

        recyclerView.setAdapter(adapter);


        ImageView imageView=view.findViewById(R.id.profil_backtoblack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections navDirections=ProfilFragmentDirections.actionProfilFragmentToMainFragment();
                Navigation.findNavController(v).navigate(navDirections);


            }
        });













    }
}