package com.example.malataana;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class HappinessFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_happiness, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView happinessFirstImage = (ImageView) view.findViewById(R.id.happiness_ana);
        happinessFirstImage.setImageResource(R.drawable.happiness_ana_border);//set the source in java class
        ImageView happinessSecondImage = (ImageView) view.findViewById(R.id.happiness_boy);
        happinessSecondImage.setImageResource(R.drawable.happiness_boy);//set the source in java class
        ImageView sound = (ImageView) view.findViewById(R.id.sound_happiness);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.happiness_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HappinessFragment.this)
                        .navigate(R.id.action_happinessFragment_to_menuChooseEmotionFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.sreka);
        sound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mp.start();
            }
        });
    }
}