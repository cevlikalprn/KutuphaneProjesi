package com.alisamil.kutuphaneprojesi.view.fragments;

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

import com.alisamil.kutuphaneprojesi.util.Constants;
import com.alisamil.kutuphaneprojesi.view.adapters.KatagoriRecylerAdapter;
import com.alisamil.kutuphaneprojesi.R;


public class KatagoriFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_katagori, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] katagoriTurleri = {
                Constants.EDEBIYAT,
                Constants.TARIH,
                Constants.KISISEL_GELISIM,
                Constants.BILIM_KURGU,
                Constants.MASAL,
                Constants.HIKAYE,
                Constants.OYKU};

        RecyclerView recyclerView=view.findViewById(R.id.katagoriRecyclerView);
        GridLayoutManager gridLayout=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayout);
        KatagoriRecylerAdapter adapter= new KatagoriRecylerAdapter(katagoriTurleri,getActivity());
        recyclerView.setAdapter(adapter);

        ImageView imageView=view.findViewById(R.id.img_btn_profil_kategori_fragment);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections= KatagoriFragmentDirections.actionKatagoriFragmentToProfilFragment();
                Navigation.findNavController(v).navigate(navDirections);
            }
        });

        ImageView kitapEkle=view.findViewById(R.id.img_kitap_ekle);
        kitapEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action=KatagoriFragmentDirections.actionKatagoriFragmentToKitapEkleFragment();
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}