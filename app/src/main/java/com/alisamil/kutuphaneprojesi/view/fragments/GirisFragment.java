package com.alisamil.kutuphaneprojesi.view.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kullanici;
import com.alisamil.kutuphaneprojesi.viewmodel.KullaniciViewModel;

import java.util.List;


public class GirisFragment extends Fragment implements View.OnClickListener{

    private KullaniciViewModel kullaniciViewModel;
    private List<Kullanici> kullaniciListesi;
    private EditText kullaniciAdi;
    private EditText kullaniciSifre;
    private Button buttonGiris;
    private TextView kayitEkrani;
    private boolean kayitKontrol = false;

    private void init()
    {
        kullaniciAdi = requireActivity().findViewById(R.id.et_giris_kullanici_adi);
        kullaniciSifre = requireActivity().findViewById(R.id.et_kullanici_giris_sifre);
        buttonGiris = requireActivity().findViewById(R.id.btn_giris);
        kayitEkrani = requireActivity().findViewById(R.id.txt_giris_kayit);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_giris, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        kullaniciViewModel = new ViewModelProvider(this).get(KullaniciViewModel.class);
        buttonGiris.setOnClickListener(this);
        kayitEkrani.setOnClickListener(this);

        //Observe İşlemi
        kullaniciViewModel.getTumKullanicilar().observe(getViewLifecycleOwner(), new Observer<List<Kullanici>>() {
            @Override
            public void onChanged(List<Kullanici> kullaniciList) {
                kullaniciListesi = kullaniciList;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_giris:
                kayitKontrol = false;
                String ad = kullaniciAdi.getText().toString().trim();
                String sifre = kullaniciSifre.getText().toString().trim();
                if(ad.equals("") || sifre.equals(""))
                {
                    Toast.makeText(requireContext(), "Lütfen Boşlukları Doldurunuz", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(!kullaniciListesi.isEmpty())
                    {
                        for(int i = 0; i<kullaniciListesi.size(); i++)
                        {
                                Kullanici kayitliKullanici = kullaniciListesi.get(i);
                                if(kayitliKullanici.getKullaniciAdi().equals(ad))
                                {
                                    kayitKontrol = true;
                                    if(kayitliKullanici.getKullaniciSifre().equals(sifre))
                                    {
                                        NavDirections action = GirisFragmentDirections.actionGirisFragmentToKatagoriFragment();
                                        Navigation.findNavController(v).navigate(action);

                                    }
                                    else
                                    {
                                        Toast.makeText(requireContext(), "Kullanıcı Adı ya da Şifre Yanlış", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        }
                        if(!kayitKontrol){
                            Toast.makeText(requireContext(), "Kaydınız Bulunmamaktadır", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(requireContext(), "Kaydınız Bulunmamaktadır", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.txt_giris_kayit:
                NavDirections action= GirisFragmentDirections.actionGirisFragmentToKayitFragment();
                Navigation.findNavController(v).navigate(action);
                break;
        }
    }
}