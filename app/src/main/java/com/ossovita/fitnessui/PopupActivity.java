package com.ossovita.fitnessui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);

    }

    //FitnessMove objesini alarak PopupActivity'e intent yapıyoruz
    public static Intent newIntent(Context context, FitnessMove fitnessMove){
        Intent intent = new Intent(context,PopupActivity.class);
        intent.putExtra("INFO",fitnessMove);
        return intent;
    }
}
