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
import android.widget.ImageView;
import android.widget.Toast;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kitap;
import com.alisamil.kutuphaneprojesi.viewmodel.KitapViewModel;


public class KitapEkleFragment extends Fragment {

    private EditText kitapAdi;
    private EditText kitapYazari;
    private EditText kitapKategori;
    private EditText kitapAdedi;
    private EditText kitapOzeti;
    private Button btnKitapEkle;
    private ImageView geriGit;

    private KitapViewModel kitapViewModel;
    private int kategori = 0;

    private void init()
    {
        kitapAdi = requireActivity().findViewById(R.id.et_kitap_adi);
        kitapYazari = requireActivity().findViewById(R.id.et_kitap_yazari);
        kitapKategori = requireActivity().findViewById(R.id.et_kategori);
        kitapAdedi = requireActivity().findViewById(R.id.et_kitap_adedi);
        kitapOzeti = requireActivity().findViewById(R.id.et_kitap_ozeti);
        btnKitapEkle = requireActivity().findViewById(R.id.btn_kitap_ekle);
        geriGit = requireActivity().findViewById(R.id.img_btn_geri_kitap_ekle_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitap_ekle, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        kitapViewModel = new ViewModelProvider(this).get(KitapViewModel.class);

        btnKitapEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kitapEkle(v);
            }
        });




        geriGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action=KitapEkleFragmentDirections.actionKitapEkleFragmentToKatagoriFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });



    }

    private void kitapEkle(View view)
    {
        String kitap = kitapAdi.getText().toString().trim();
        String yazar = kitapYazari.getText().toString().trim();
        String kitapKategorisi = kitapKategori.getText().toString().trim();
        String adedi = kitapAdedi.getText().toString().trim();
        String ozet = kitapOzeti.getText().toString().trim();

        if(kitap.equals("") || yazar.equals("") || kitapKategorisi.equals("") || adedi.equals("") || ozet.equals("")){
            Toast.makeText(requireContext(),"Lütfen Boşlukları Doldurunuz", Toast.LENGTH_LONG).show();
        }
        else{
            kitapKategorisiBelirle(kitapKategorisi);
            kitapViewModel.insertKitap(new Kitap(kitap, yazar, kategori, Integer.parseInt(adedi), ozet));
            Toast.makeText(requireContext(),"Kitap Eklendi", Toast.LENGTH_LONG).show();
            NavDirections action=KitapEkleFragmentDirections.actionKitapEkleFragmentToKatagoriFragment();
            Navigation.findNavController(view).navigate(action);
        }

    }

    private void kitapKategorisiBelirle(String kitapKategorisi)
    {
        switch (kitapKategorisi){
            case "Edebiyat":
                kategori = 0;
                break;
            case "Tarih":
                kategori = 1;
                break;
            case "Kişisel Gelişim":
                kategori = 2;
                break;
            case  "Bilim Kurgu":
                kategori = 3;
                break;
            case "Masal":
                kategori = 4;
                break;
            case "Hikaye":
                kategori = 5;
                break;
            case "Öykü":
                kategori = 6;
                break;
            default:
                kategori = 0;
                break;
        }
    }
}