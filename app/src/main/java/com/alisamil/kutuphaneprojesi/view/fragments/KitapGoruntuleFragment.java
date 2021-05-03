package com.alisamil.kutuphaneprojesi.view.fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kitap;
import com.alisamil.kutuphaneprojesi.viewmodel.KitapViewModel;


public class KitapGoruntuleFragment extends Fragment {

    private TextView kitapAdi;
    private TextView kitapYazarAdi;
    private TextView kitapOzeti;
    private ImageView btnGeri;
    private ImageView btnProfil;
    private KitapViewModel kitapViewModel;

    private void init(){
        kitapAdi = requireActivity().findViewById(R.id.txt_kitap_adi_goruntule);
        kitapYazarAdi = requireActivity().findViewById(R.id.txt_kitap_yazari_goruntule);
        kitapOzeti = requireActivity().findViewById(R.id.txt_kitap_ozeti_goruntule);
        btnGeri = requireActivity().findViewById(R.id.img_btn_geri_kitap_goruntule_fragment);
        btnProfil = requireActivity().findViewById(R.id.img_btn_profil_kitap_goruntule_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitap_goruntule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();


        Kitap kitap = KitapGoruntuleFragmentArgs.fromBundle(getArguments()).getKitap();

        kitapAdi.setText("Kitap Adı: "+kitap.getKitapAdi());
        kitapYazarAdi.setText("Yazar Adı: "+kitap.getKitapYazariAdi());
        kitapOzeti.setText("Kitap Özeti: "+kitap.getKitapOzeti());

        btnGeri.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavDirections navDirections= KitapGoruntuleFragmentDirections.actionKitapGoruntuleFragmentToMainFragment();
                Navigation.findNavController(v).navigate(navDirections);
            }
        });

        btnProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavDirections navDirections= KitapGoruntuleFragmentDirections.actionKitapGoruntuleFragmentToProfilFragment();
                Navigation.findNavController(v).navigate(navDirections);
            }
        });
    }
}