package com.alisamil.kutuphaneprojesi.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alisamil.kutuphaneprojesi.R;

public class KatagoriRecylerAdapter extends RecyclerView.Adapter<KatagoriRecylerAdapter.KatagoriVH> {


    String[] localDataset;
    public KatagoriRecylerAdapter(String[] katagoriler){
        localDataset=katagoriler;
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
        TextView textView=holder.itemView.findViewById(R.id.katagoriRecyclerTextView);
        textView.setText(localDataset[position]);
    }

    @Override
    public int getItemCount() {
        return localDataset.length;
    }


}
