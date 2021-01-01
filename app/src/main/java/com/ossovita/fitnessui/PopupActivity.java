package com.ossovita.fitnessui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ossovita.fitnessui.Fragment.PopupFragment;

public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_activity);
        //Popup akctivity ile popupfragmenti birbirine bağladık
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.popup_activity_framelayout);

        if(fragment==null){
            fragment= PopupFragment.newInstance();
            fragmentManager.beginTransaction().add(R.id.popup_activity_framelayout,fragment).commit();
        }

    }

    //FitnessMove objesini alarak PopupActivity'e intent yapıyoruz
    public static Intent newIntent(Context context, FitnessMove fitnessMove){
        Intent intent = new Intent(context,PopupActivity.class);
        intent.putExtra("INFO",fitnessMove);
        return intent;
    }
}
