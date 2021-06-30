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

public class LoveFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_love, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView loveFirstImage = (ImageView) view.findViewById(R.id.love_ana);
        loveFirstImage.setImageResource(R.drawable.love_ana);//set the source in java class
        ImageView loveSecondImage = (ImageView) view.findViewById(R.id.love_boy);
        loveSecondImage.setImageResource(R.drawable.love_boy);//set the source in java class
        ImageView sound = (ImageView) view.findViewById(R.id.sound_love);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.love_home);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoveFragment.this)
                        .navigate(R.id.action_loveFragment_to_menuChooseEmotionFragment);
            }
        });
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.ljuov);
        sound.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                mp.start();
            }
        });
    }
}