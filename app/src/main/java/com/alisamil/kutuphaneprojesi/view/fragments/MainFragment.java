package com.alisamil.kutuphaneprojesi.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kitap;
import com.alisamil.kutuphaneprojesi.view.adapters.AnaEkranAdapter;
import com.alisamil.kutuphaneprojesi.viewmodel.KitapViewModel;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment{

    private RecyclerView recyclerView;
    private ImageView btnGeri;
    private ImageView btnProfil;

    private KitapViewModel kitapViewModel;
    private ArrayList<Kitap> kitapListesi;
    AnaEkranAdapter adapter;


    private void init() {
        recyclerView = requireActivity().findViewById(R.id.anaEkranRecyler);
        btnGeri = requireActivity().findViewById(R.id.img_btn_geri_main_fragment);
        btnProfil = requireActivity().findViewById(R.id.img_btn_profil_main_fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        kitapViewModel = new ViewModelProvider(this).get(KitapViewModel.class);

        int istenenKategori = MainFragmentArgs.fromBundle(getArguments()).getKategori();

        kitapListesi = new ArrayList();

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new AnaEkranAdapter(requireContext());
        recyclerView.setAdapter(adapter);

        kitapViewModel.getTumKitaplar().observe(getViewLifecycleOwner(), new Observer<List<Kitap>>() {
            @Override
            public void onChanged(List<Kitap> kitapList) {

                for(Kitap kitap: kitapList)
                {
                    if(istenenKategori == kitap.getKitapKategori()){
                        kitapListesi.add(kitap);
                    }
                }
                adapter.setData(kitapListesi);
            }
        });

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections=MainFragmentDirections.actionMainFragmentToProfilFragment();
                Navigation.findNavController(v).navigate(navDirections);
            }
        });

        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections=MainFragmentDirections.actionMainFragmentToKatagoriFragment();
                Navigation.findNavController(v).navigate(navDirections);
            }
        });
    }

}