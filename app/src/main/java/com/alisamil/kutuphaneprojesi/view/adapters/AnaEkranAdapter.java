package com.alisamil.kutuphaneprojesi.view.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.model.Kitap;
import com.alisamil.kutuphaneprojesi.view.fragments.KatagoriFragmentDirections;
import com.alisamil.kutuphaneprojesi.view.fragments.MainFragmentDirections;
import com.alisamil.kutuphaneprojesi.view.fragments.ProfilFragmentDirections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnaEkranAdapter extends RecyclerView.Adapter<AnaEkranAdapter.AnaEkranVH> {

    public class AnaEkranVH extends RecyclerView.ViewHolder {

        public AnaEkranVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    List<Kitap> kitapListesi = Collections.emptyList();
    Context context;
    public AnaEkranAdapter( Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public AnaEkranVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_shape,parent,false);
        AnaEkranAdapter.AnaEkranVH viewHolder = new AnaEkranAdapter.AnaEkranVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnaEkranVH holder, int position) {

        ImageView recyclerImage=holder.itemView.findViewById(R.id.recycler_image);
        TextView isimTextView=holder.itemView.findViewById(R.id.recyclerKitapAdiTextView);
        TextView adetTextView=holder.itemView.findViewById(R.id.recyclet_adet);

        Kitap kitap = kitapListesi.get(position);

        recyclerImage.setImageResource(R.drawable.logo);
        isimTextView.setText("İsim: "+kitap.getKitapAdi());
        adetTextView.setText("Adet:"+kitap.getKitapAdedi());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                MainFragmentDirections.ActionMainFragmentToKitapGoruntuleFragment action
                        = MainFragmentDirections.actionMainFragmentToKitapGoruntuleFragment(kitap);
                Navigation.findNavController(v).navigate(action);

            }
        });

    }

    @Override
    public int getItemCount() {
        return kitapListesi.size();
    }

    public void setData(ArrayList<Kitap> kitapListesi)
    {
        this.kitapListesi = kitapListesi;
        notifyDataSetChanged();
    }

}