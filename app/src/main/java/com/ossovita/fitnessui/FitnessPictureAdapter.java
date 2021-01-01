package com.ossovita.fitnessui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ossovita.fitnessui.recyclerview.FitnessPictureViewHolder;

import java.util.ArrayList;

public class FitnessPictureAdapter extends RecyclerView.Adapter<FitnessPictureViewHolder> implements View.OnClickListener {
    //FitnessMove objelerinin tutulduğu bir liste
    private ArrayList<FitnessMove> fitnessMoves;
    private LayoutInflater layoutInflater;
    private AppCompatActivity appCompatActivity;
    private MyListener myListener;

    public FitnessPictureAdapter(AppCompatActivity appCompatActivity, MyListener myListener) {
        this.appCompatActivity = appCompatActivity;
        this.myListener = myListener;
        layoutInflater = appCompatActivity.getLayoutInflater();
        fitnessMoves = new ArrayList<>();
    }
    //Arraylist için constructor oluşturuyoruz
    public ArrayList<FitnessMove> getFitnessMoves(){
        return fitnessMoves;
    }

    //onCreate içinde recyclerView'un alt elemanını bağlıyoruz
    @NonNull
    @Override
    public FitnessPictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.recyclerview_fitness_pictures_list,parent,false);
        rootView.setOnClickListener(this);

        return new FitnessPictureViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessPictureViewHolder holder, int position) {
        //FitnessPictureViewHolder ile adapteri bağlamamız gerekiyor
        holder.getMoves(appCompatActivity,fitnessMoves.get(position));
    }
    //FitnessMove'dan kaç tane varsa o kadar yazılacak
    @Override
    public int getItemCount() {
        return fitnessMoves.size();
    }

    @Override
    public void onClick(View view) {
        //gelen view'ın etiketi FitnessMove'a aitse
        if (view.getTag() instanceof FitnessMove) {
            FitnessMove fitnessMove = (FitnessMove) view.getTag();
            myListener.MyListener(fitnessMove);
        }

    }

    public interface MyListener{
        public void MyListener(FitnessMove fitnessMove);
    }
}
