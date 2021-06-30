package com.example.malataana;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SadnessQuizFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sadness, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView sadnessQuizFirstImage = (ImageView) view.findViewById(R.id.quiz_sadness);

        sadnessQuizFirstImage.setImageResource(R.drawable.quiz_sadness);//set the source in java class
        sadnessQuizFirstImage.setOnClickListener(new View.OnClickListener() {
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
                }, 3000);
            }
        });


        ImageView sadnessQuizSecondImage = (ImageView) view.findViewById(R.id.quiz_fear);
        sadnessQuizSecondImage.setImageResource(R.drawable.quiz_fear);//set the source in java class
        sadnessQuizSecondImage.setOnClickListener(new View.OnClickListener() {
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

        ImageView sound = (ImageView) view.findViewById(R.id.quiz_sadness_sound);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.quiz_sadness_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(SadnessQuizFragment.this)
                        .navigate(R.id.action_fearQuizFragment_to_mainMenuFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.ana_e_tazna);
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
                NavHostFragment.findNavController(SadnessQuizFragment.this)
                        .navigate(R.id.action_fearQuizFragment_to_mainMenuFragment);
            }
        });
    }
}