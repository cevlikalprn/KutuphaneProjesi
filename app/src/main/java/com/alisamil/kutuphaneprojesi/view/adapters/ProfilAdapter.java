package com.alisamil.kutuphaneprojesi.view.adapters;

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
import com.alisamil.kutuphaneprojesi.view.fragments.MainFragmentDirections;

import java.util.ArrayList;

public class ProfilAdapter extends RecyclerView.Adapter<ProfilAdapter.ProfilVH> {

    ArrayList<String> isim;
    ArrayList<String> yazar;
    ArrayList<String> ozet;
    public ProfilAdapter(ArrayList<String> kitapIsmi,ArrayList<String> yazarIsmi,ArrayList<String> ozetA){

        isim=kitapIsmi;
        yazar=yazarIsmi;
        ozet=ozetA;

    }



    @NonNull
    @Override
    public ProfilVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.profil_recycler_shape,parent,false);
        ProfilVH vh=new ProfilVH(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfilVH holder, int position) {
        ImageView imageView=holder.itemView.findViewById(R.id.profil_recycler_image);
        imageView.setImageResource(R.drawable.logo);
        TextView textView=holder.itemView.findViewById(R.id.KitapAdiTextView);
        textView.setText(isim.get(position));
        TextView textView1=holder.itemView.findViewById(R.id.recyclet_yazar);
        textView1.setText(yazar.get(position));


    }

    @Override
    public int getItemCount() {
        return isim.size();
    }

    public class ProfilVH extends RecyclerView.ViewHolder {
        public ProfilVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
