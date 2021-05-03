package com.alisamil.kutuphaneprojesi.view.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.alisamil.kutuphaneprojesi.model.Kullanici;
import com.alisamil.kutuphaneprojesi.viewmodel.KullaniciViewModel;

import java.util.List;


public class KayitFragment extends Fragment implements View.OnClickListener {

    private KullaniciViewModel kullaniciViewModel;
    private List<Kullanici> kullaniciListesi;
    private EditText kullaniciAdi;
    private EditText kullaniciSifre;
    private Button buttonKayit;
    private TextView girisEkrani;
    private boolean kullaniciKontrol = false;

    private void init() {
        kullaniciAdi = requireActivity().findViewById(R.id.et_kayit_kullanici_adi);
        kullaniciSifre = requireActivity().findViewById(R.id.et_kayit_kullanici_sifre);
        buttonKayit = requireActivity().findViewById(R.id.btn_kayit);
        girisEkrani = requireActivity().findViewById(R.id.txt_kayit_giris);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kayit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        kullaniciViewModel = new ViewModelProvider(this).get(KullaniciViewModel.class);

        buttonKayit.setOnClickListener(this);
        girisEkrani.setOnClickListener(this);

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
            case R.id.btn_kayit:

                kullaniciKontrol = false;

                String ad = kullaniciAdi.getText().toString().trim();
                String sifre = kullaniciSifre.getText().toString().trim();
                if(ad.equals("") || sifre.equals("")) {
                    Toast.makeText(requireContext(), "Lütfen Boşlukları Doldurunuz", Toast.LENGTH_LONG).show();
                }

                else
                {
                    if(!kullaniciListesi.isEmpty())
                    {
                        for(Kullanici kullanici: kullaniciListesi){
                            if(ad.equals(kullanici.getKullaniciAdi()))
                            {
                                kullaniciKontrol = true;
                                Toast.makeText(requireActivity(), "Bu kullanıcı adı alınmış", Toast.LENGTH_LONG).show();
                            }
                        }
                        if(!kullaniciKontrol)
                        {
                            yeniKullaniciOlustur(ad,sifre,v);
                        }
                    }
                    else{
                        yeniKullaniciOlustur(ad,sifre,v);
                    }
                }
                break;
            case R.id.txt_kayit_giris:
                NavDirections action= KayitFragmentDirections.actionKayitFragmentToGirisFragment();
                Navigation.findNavController(v).navigate(action);
                break;
        }
    }
    //Yeni oluştur ve Giriş ekranına zıpla
    private void yeniKullaniciOlustur(String ad, String sifre, View v)
    {
        Kullanici yeniKullanici = new Kullanici(ad, sifre);
        kullaniciViewModel.insertKullanici(yeniKullanici);
        NavDirections action = KayitFragmentDirections.actionKayitFragmentToGirisFragment();
        Navigation.findNavController(v).navigate(action);
    }


}