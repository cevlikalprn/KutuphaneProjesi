package com.alisamil.kutuphaneprojesi;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class KayitFragment extends Fragment {

    EditText username;
    EditText password;
    TextView textView;


    public KayitFragment() {
        // Required empty public constructor
    }


    public static KayitFragment newInstance(String param1, String param2) {
        KayitFragment fragment = new KayitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kayit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView=view.findViewById(R.id.kayitGirisButon);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kayitGoGiris(v);
            }
        });



    }


    public void kayitButton(View view){

        username=view.findViewById(R.id.kayitKullaniciAdiEditText);
        String kullaniciAdi=username.getText().toString();

        password=view.findViewById(R.id.kayitSifreEditText);
        String sifre=password.getText().toString();
        int sifreUzunluk=sifre.length();
        if(kullaniciAdi!="" & sifre!=""){
            if(sifreUzunluk>5){




            }
            else{

                Toast.makeText(getContext(),"Parolan en az 6 karakterden oluşmalı!",Toast.LENGTH_LONG).show();


            }


        }

        else {

            Toast.makeText(getContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_LONG).show();


        }


    }


    public void kayitGoGiris(View view){

        NavDirections action=KayitFragmentDirections.actionKayitFragmentToGirisFragment();
        Navigation.findNavController(view).navigate(action);

    }





}