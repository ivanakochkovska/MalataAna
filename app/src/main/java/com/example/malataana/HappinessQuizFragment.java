package com.example.malataana;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HappinessQuizFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_happiness_quiz, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView angerQuizFirstImage = (ImageView) view.findViewById(R.id.quiz_anger);

        angerQuizFirstImage.setImageResource(R.drawable.quiz_anger);//set the source in java class
        angerQuizFirstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.imageView5).setVisibility(View.VISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        view.findViewById(R.id.imageView5).setVisibility(View.INVISIBLE);
                    }
                }, 3000);
            }
        });


        ImageView happinessQuizSecondImage = (ImageView) view.findViewById(R.id.quiz_happiness);
        happinessQuizSecondImage.setImageResource(R.drawable.quiz_happiness);//set the source in java class
        happinessQuizSecondImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.imageView4).setVisibility(View.VISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        view.findViewById(R.id.imageView4).setVisibility(View.INVISIBLE);
                    }
                }, 4000);
            }
        });

        ImageView sound = (ImageView) view.findViewById(R.id.quiz_happiness_sound);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.quiz_happiness_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HappinessQuizFragment.this)
                        .navigate(R.id.action_happinessQuizFragment_to_mainMenuFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.ana_e_srekna);
        sound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mp.start();
            }
        });
        ImageView arrow = (ImageView) view.findViewById(R.id.arrow_id);
        arrow.setImageResource(R.drawable.arrow);//set the source in java class
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                NavHostFragment.findNavController(HappinessQuizFragment.this)
                        .navigate(R.id.action_happinessQuizFragment_to_angerQuizFragment);
            }
        });
        ImageView arrowBack = (ImageView) view.findViewById(R.id.back_id);
        arrowBack.setImageResource(R.drawable.back);//set the source in java class
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                NavHostFragment.findNavController(HappinessQuizFragment.this)
                        .navigate(R.id.action_happinessQuizFragment_to_sadnessQuizFragment);
            }
        });
    }
}