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

public class AngerFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anger, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView angerFirstImage = (ImageView) view.findViewById(R.id.anger_ana);
        angerFirstImage.setImageResource(R.drawable.anger);//set the source in java class
        ImageView angerSecondImage = (ImageView) view.findViewById(R.id.anger_boy);
        angerSecondImage.setImageResource(R.drawable.anger_boy);//set the source in java class
        ImageView sound = (ImageView) view.findViewById(R.id.sound_anger);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.anger_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AngerFragment.this)
                        .navigate(R.id.action_angerFragment_to_menuChooseEmotionFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.bes);
        sound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mp.start();
            }
        });
    }
}