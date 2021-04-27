package com.alisamil.kutuphaneprojesi.view.fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alisamil.kutuphaneprojesi.R;


public class KitapEkleFragment extends Fragment {



    public KitapEkleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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


        super.onViewCreated(view, savedInstanceState);


        Button kayit=view.findViewById(R.id.button);
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText kitapAdi=(EditText) view.findViewById(R.id.kitapEkleKitapAdiEditText);
                String bookName=kitapAdi.getText().toString();
                System.out.println(bookName);

                EditText kitapYazari=(EditText) view.findViewById(R.id.kitapEkleKitapYazariEditText);
                String bookAuthor=kitapYazari.getText().toString();
                EditText kitapOzeti=(EditText) view.findViewById(R.id.kitapEkleKitapOzetiEditText);
                String bookSummary=kitapOzeti.getText().toString();
                EditText kitapAdedi=(EditText) view.findViewById(R.id.asdsaa);
                String bookPiece=kitapAdedi.getText().toString();
                EditText kategorii=(EditText) view.findViewById(R.id.kategori_edit_text);
                String kategori=kategorii.getText().toString();



                try{

                    SQLiteDatabase database = getContext().openOrCreateDatabase("Kitap", Context.MODE_PRIVATE,null);
                    database.execSQL("CREATE TABLE IF NOT EXISTS kitaplar(id INTEGER PRIMARY KEY, isim VARCHAR, yazar VARCHAR, ozet VARCHAR, adet VARCHAR)");
                    String insert="INSERT INTO kitaplar (isim,yazar,ozet,adet) VALUES (?,?,?,?)";
                    SQLiteStatement statement=database.compileStatement(insert);
                    statement.bindString(1,bookName);
                    statement.bindString(2,bookAuthor);
                    statement.bindString(3,bookSummary);
                    statement.bindString(4,bookPiece);
                    statement.execute();



                }catch(Exception e){

                    e.printStackTrace();

                }


                NavDirections action=KitapEkleFragmentDirections.actionKitapEkleFragmentToMainFragment();
                Navigation.findNavController(v).navigate(action);



            }


        });

        ImageView imageView=view.findViewById(R.id.kitapEkleBackButton);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NavDirections action=KitapEkleFragmentDirections.actionKitapEkleFragmentToMainFragment();
                Navigation.findNavController(v).navigate(action);

            }
        });




    }
}