package com.alisamil.kutuphaneprojesi.view.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kullanici;
import com.alisamil.kutuphaneprojesi.viewmodel.KullaniciViewModel;


public class KayitFragment extends Fragment implements View.OnClickListener {

    private KullaniciViewModel kullaniciViewModel;
    private EditText kullaniciAdi;
    private EditText kullaniciSifre;
    private Button buttonKayit;

    private void init()
    {
        kullaniciAdi = requireActivity().findViewById(R.id.et_kayit_kullanici_adi);
        kullaniciSifre = requireActivity().findViewById(R.id.et_kayit_kullanici_sifre);
        buttonKayit = requireActivity().findViewById(R.id.btn_kayit);
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_kayit:
                String ad = kullaniciAdi.getText().toString();
                String sifre = kullaniciSifre.getText().toString();
                if(ad.equals("") || sifre.equals(""))
                {
                    Toast.makeText(requireContext(), "Lütfen Boşlukları Doldurunuz", Toast.LENGTH_LONG).show();
                }
                else{
                    Kullanici yeniKullanici = new Kullanici(ad, sifre);
                    kullaniciViewModel.insertKullanici(yeniKullanici);
                    NavDirections action = KayitFragmentDirections.actionKayitFragmentToGirisFragment();
                    Navigation.findNavController(v).navigate(action);
                }
                break;
        }
    }
}