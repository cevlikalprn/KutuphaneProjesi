package com.alisamil.kutuphaneprojesi.view.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.alisamil.kutuphaneprojesi.R;


public class GirisFragment extends Fragment {
    EditText username;
    EditText pass;
    TextView button;
    Button button1;

    public GirisFragment() {
        // Required empty public constructor
    }

    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_giris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button=view.findViewById(R.id.girisKayitButon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitOnClick(v);
            }
        });

        button1=view.findViewById(R.id.girisButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                girisGirisButton(v);
            }
        });


    }

    public void kayitOnClick(View view){

        NavDirections action= GirisFragmentDirections.actionGirisFragmentToKayitFragment();
        Navigation.findNavController(view).navigate(action);

    }


    public void girisGirisButton(View view){
        /*
        username=view.findViewById(R.id.girisKullaniciAdiEditText);
        String kullaniciAdi=username.getText().toString();
        pass=view.findViewById(R.id.girisSifreEditText);
        String sifre=pass.getText().toString();
*/

        NavDirections action=GirisFragmentDirections.actionGirisFragmentToKatagoriFragment();
        Navigation.findNavController(view).navigate(action);


    }



}