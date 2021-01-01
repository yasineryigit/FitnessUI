package com.ossovita.fitnessui.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ossovita.fitnessui.FitnessMove;
import com.ossovita.fitnessui.FitnessPictureAdapter;
import com.ossovita.fitnessui.PopupActivity;
import com.ossovita.fitnessui.R;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class FitnessPictures extends Fragment implements FitnessPictureAdapter.MyListener {
    private FitnessPictureAdapter fitnessPictureAdapter;
    private RecyclerView recyclerView;
    private ArrayList<FitnessMove> fitnessMoves;
    //Direkt obje oluşturma metodu
    public static FitnessPictures newInstance() {
        return new FitnessPictures();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fitness_pictures, container, false);
        fitnessPictureAdapter = new FitnessPictureAdapter((AppCompatActivity) getActivity(),this);
        fitnessMoves=fitnessPictureAdapter.getFitnessMoves();
        recyclerView = rootView.findViewById(R.id.fragment_fitness_pictures_recyclerView);
        //yan yana kaç tane resim olacağı
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        //Fragment aktiviteye eklendiyse recyclerView'a adapterini bağla
        if(isAdded()){
            recyclerView.setAdapter(fitnessPictureAdapter);
        }

        getFitnessMoves(fitnessMoves);
        return rootView;
    }
    //FitnessMove objeleri buradan alınacak
    private ArrayList<FitnessMove> getFitnessMoves(ArrayList<FitnessMove> fitnessMoves){

        for(int i = 0; i<16;i++){
            fitnessMoves.add(new FitnessMove("Fitness move name "+i
                    ,"https://1.bp.blogspot.com/-7JUDxQgjr40/WzAeYQcSy7I/AAAAAAAAGl8/xAL9gjXc4FQsQr1rnU9w8NUNvH4rGhLUgCLcBGAs/s1600/Serdar-Aktolga-Motivasyon.jpg"
                    ,"Fitness move description"
                    ,100*i));
        }


        return fitnessMoves;
    }
    //Hangi objenin üzerine tıklandığını görüyoruz
    //Tıklanınca popup çıkacak
    @Override
    public void MyListener(FitnessMove fitnessMove) {
        System.out.println("Fitness move: " + fitnessMove.getFitnessName());
        //Üzerine tıklanan objeyi al PopupActivity'e götür
         Intent intent = PopupActivity.newIntent(getContext(),fitnessMove);
         startActivity(intent);
    }
}
