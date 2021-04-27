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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.view.adapters.AnaEkranAdapter;
import com.alisamil.kutuphaneprojesi.view.adapters.KatagoriRecylerAdapter;

import java.util.ArrayList;


public class MainFragment extends Fragment {




    public MainFragment() {
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
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> idArray = new ArrayList<String>();
        ArrayList<String> isimArray = new ArrayList<String>();
        ArrayList<String> yazarArray = new ArrayList<String>();
        ArrayList<String> ozetArray = new ArrayList<String>();
        ArrayList<String> adetArray = new ArrayList<String>();



            try {
                SQLiteDatabase database = getContext().openOrCreateDatabase("Kitap", Context.MODE_PRIVATE, null);
                database.execSQL("CREATE TABLE IF NOT EXISTS kitaplar(id INTEGER PRIMARY KEY, isim VARCHAR, yazar VARCHAR, ozet VARCHAR, adet VARCHAR)");
                Cursor cursor = database.rawQuery("SELECT * FROM kitaplar" , null);

                int idIx = cursor.getColumnIndex("id");
                int isimIx = cursor.getColumnIndex("isim");
                int yazarIx = cursor.getColumnIndex("yazar");
                int ozetIx = cursor.getColumnIndex("ozet");
                int adetIx = cursor.getColumnIndex("adet");

                while (cursor.moveToNext()) {
                    int id=cursor.getInt(idIx);
                    String idString=Integer.toString(id);
                    String isim = cursor.getString(isimIx);
                    String yazar = cursor.getString(yazarIx);
                    String ozet = cursor.getString(ozetIx);
                    String adet = cursor.getString(adetIx);

                    idArray.add(idString);

                    isimArray.add(isim);

                    yazarArray.add(yazar);

                    ozetArray.add(ozet);

                    adetArray.add(adet);


                }
            }catch (Exception e){

                e.printStackTrace();
            }

            ImageView imageView=view.findViewById(R.id.maintoadd);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections action=MainFragmentDirections.actionMainFragmentToKitapEkleFragment();
                    Navigation.findNavController(v).navigate(action);


                }
            });





        RecyclerView recyclerView=view.findViewById(R.id.anaEkranRecyler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        AnaEkranAdapter adapter= new AnaEkranAdapter(idArray,isimArray,yazarArray,adetArray);

        recyclerView.setAdapter(adapter);

        ImageView view1=view.findViewById(R.id.imageView8);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections navDirections=MainFragmentDirections.actionMainFragmentToKatagoriFragment();
                Navigation.findNavController(v).navigate(navDirections);


            }
        });





    }
}