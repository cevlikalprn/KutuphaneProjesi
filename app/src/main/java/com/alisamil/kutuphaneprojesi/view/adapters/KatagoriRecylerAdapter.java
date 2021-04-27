package com.alisamil.kutuphaneprojesi.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.alisamil.kutuphaneprojesi.R;
import com.alisamil.kutuphaneprojesi.view.fragments.KatagoriFragmentDirections;

public class KatagoriRecylerAdapter extends RecyclerView.Adapter<KatagoriRecylerAdapter.KatagoriVH> {


    String[] localDataset;
    Activity activity;
    public KatagoriRecylerAdapter(String[] katagoriler,Activity activitya){
        localDataset=katagoriler;
        activity=activitya;
    }

    public class KatagoriVH extends RecyclerView.ViewHolder {
        public KatagoriVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public KatagoriVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.katagori_recycler_shape,parent,false);
        KatagoriVH viewHolder = new KatagoriVH(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KatagoriVH holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NavDirections action= KatagoriFragmentDirections.actionKatagoriFragmentToMainFragment();
                Navigation.findNavController(v).navigate(action);


            }
        });

        TextView textView=holder.itemView.findViewById(R.id.katagoriRecyclerTextView);
        textView.setText(localDataset[position]);
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }


}
