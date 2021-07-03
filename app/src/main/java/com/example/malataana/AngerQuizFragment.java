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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
public class AngerQuizFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fear_quiz, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView fearQuizFirstImage = (ImageView) view.findViewById(R.id.quiz_fear);
        Animation animation;
        animation = AnimationUtils.loadAnimation(this.getContext(),
                R.anim.slide_down);

        fearQuizFirstImage.setImageResource(R.drawable.quiz_fear);//set the source in java class
        fearQuizFirstImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.findViewById(R.id.imageView5).setVisibility(View.VISIBLE);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        view.findViewById(R.id.imageView5).setVisibility(View.INVISIBLE); //TRUE
                    }
                }, 4000);
            }
        });


        ImageView fearQuizSecondImage = (ImageView) view.findViewById(R.id.quiz_anger);
        fearQuizSecondImage.setImageResource(R.drawable.quiz_anger);//set the source in java class
        fearQuizSecondImage.setImageResource(R.drawable.quiz_anger);//set the source in java class
        fearQuizSecondImage.setOnClickListener(new View.OnClickListener() {
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

        ImageView sound = (ImageView) view.findViewById(R.id.quiz_anger_sound);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.quiz_anger_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AngerQuizFragment.this)
                        .navigate(R.id.action_angerQuizFragment_to_mainMenuFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.ana_se_plashi);
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
                NavHostFragment.findNavController(AngerQuizFragment.this)
                        .navigate(R.id.action_angerQuizFragment_to_mainMenuFragment);
            }
        });
        ImageView arrowBack = (ImageView) view.findViewById(R.id.back_id);
        arrowBack.setImageResource(R.drawable.back);//set the source in java class
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                NavHostFragment.findNavController(AngerQuizFragment.this)
                        .navigate(R.id.action_angerQuizFragment_to_happinessQuizFragment);
            }
        });
    }
}