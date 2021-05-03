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

    private ImageView btnGeri;
    private TextView kullaniciAdi;

    private void init() {
        btnGeri = requireActivity().findViewById(R.id.img_btn_geri_profil_fragment);
        kullaniciAdi = requireActivity().findViewById(R.id.profilKullaniciAdi);
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
        init();

        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("kullanici", Context.MODE_PRIVATE);
        String kullanici = sharedPreferences.getString("kullanici", "Kullanıcı");
        kullaniciAdi.setText(kullanici);

        btnGeri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavDirections action = ProfilFragmentDirections.actionProfilFragmentToMainFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });

    }
}