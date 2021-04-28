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
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alisamil.kutuphaneprojesi.view.adapters.KatagoriRecylerAdapter;
import com.alisamil.kutuphaneprojesi.R;


public class KatagoriFragment extends Fragment {




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_katagori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] katagoriTurleri={"Edebiyat","Tarih","Kişisel Gelişim","Bilim-Kurgu","Masal","Hikaye","Öykü"};


        RecyclerView recyclerView=view.findViewById(R.id.katagoriRecyclerView);
        GridLayoutManager gridLayout=new GridLayoutManager(getContext(),2);

        recyclerView.setLayoutManager(gridLayout);
        KatagoriRecylerAdapter adapter= new KatagoriRecylerAdapter(katagoriTurleri,getActivity());

        recyclerView.setAdapter(adapter);


        ImageView imageView=view.findViewById(R.id.kategoriImageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections navDirections= KatagoriFragmentDirections.actionKatagoriFragmentToProfilFragment();
                Navigation.findNavController(v).navigate(navDirections);


            }
        });






    }
}