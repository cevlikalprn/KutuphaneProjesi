package com.alisamil.kutuphaneprojesi.view.adapters;

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
import com.alisamil.kutuphaneprojesi.view.fragments.MainFragmentDirections;

import java.util.ArrayList;

public class AnaEkranAdapter extends RecyclerView.Adapter<AnaEkranAdapter.AnaEkranVH> {

    public class AnaEkranVH extends RecyclerView.ViewHolder {

        public AnaEkranVH(@NonNull View itemView) {
            super(itemView);
        }
    }
    ArrayList<String> id;
    ArrayList<String> isim;
    ArrayList<String> yazar;
    ArrayList<String> adet;
    public AnaEkranAdapter(ArrayList<String> idA,ArrayList<String> kitapIsmi,ArrayList<String> yazarIsmi,ArrayList<String> adetA){
        id=idA;
        isim=kitapIsmi;
        yazar=yazarIsmi;
        adet=adetA;
    }


    @NonNull
    @Override
    public AnaEkranVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_shape,parent,false);
        AnaEkranAdapter.AnaEkranVH viewHolder = new AnaEkranAdapter.AnaEkranVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnaEkranVH holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idString=id.get(position);
                int idInt=Integer.parseInt(idString);
                NavDirections action= MainFragmentDirections.actionMainFragmentToKitapGoruntuleFragment(idInt);
                Navigation.findNavController(v).navigate(action);


            }
        });
        ImageView recyclerImage=holder.itemView.findViewById(R.id.recycler_image);
        recyclerImage.setImageResource(R.drawable.logo);
        TextView isimTextView=holder.itemView.findViewById(R.id.recyclerKitapAdiTextView);
        isimTextView.setText("İsim: "+isim.get(position));
        TextView adetTextView=holder.itemView.findViewById(R.id.recyclet_adet);
        adetTextView.setText("Adet:"+adet.get(position));
        TextView kullanilabilirlikTextView=holder.itemView.findViewById(R.id.recyclerKullanilabilirlik);
        int a=0;
        if (adet.get(position)==null){
              a=0;
        }else {
             a=Integer.parseInt(adet.get(position));
        }

        if(a>=1) {
                kullanilabilirlikTextView.setText("Kullanılabilirlik: Evet");
        }
            else {kullanilabilirlikTextView.setText("Kullanılabilirlik: Hayır");}



    }

    @Override
    public int getItemCount() {
        return isim.size();
    }


}
