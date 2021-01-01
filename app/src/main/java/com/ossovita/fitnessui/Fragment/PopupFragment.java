package com.ossovita.fitnessui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ossovita.fitnessui.FitnessMove;
import com.ossovita.fitnessui.R;

public class PopupFragment extends Fragment {

    TextView nameText,descriptionText,calorieText;
    ImageView imageView;
    ProgressBar progressBar;
    private FitnessMove fitnessMove;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FitnessPictures 'da yollanılan fitnessMove'u PopupActivity'deki metodla yolluyoruz
        //ve PopupFragment içinde bunu alabiliyoruz
        fitnessMove = getActivity().getIntent().getParcelableExtra("INFO");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popup,container,false);
        nameText = rootView.findViewById(R.id.fragment_popup_name_textview);
        descriptionText = rootView.findViewById(R.id.fragment_popup_description_textview);
        calorieText = rootView.findViewById(R.id.fragment_popup_calorie_textview);
        imageView = rootView.findViewById(R.id.fragment_popup_imageview);
        progressBar = rootView.findViewById(R.id.fragment_popup_progressbar);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
