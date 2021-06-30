package com.example.malataana;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView sadnessFirstImage=(ImageView) view.findViewById(R.id.sadness_1);
        sadnessFirstImage.setImageResource(R.drawable.taga_ana);//set the source in java class
        ImageView sadnessSecondImage=(ImageView) view.findViewById(R.id.sadness_2);
        sadnessSecondImage.setImageResource(R.drawable.sadness_boy);//set the source in java class
        ImageView sound = (ImageView) view.findViewById(R.id.sound_sadness);
        sound.setImageResource(R.drawable.sound_frame);//set the source in java class
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.taga);
        sound.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp.start();
            }
        });
        ImageView home = (ImageView) view.findViewById(R.id.home_sadness);
        home.setImageResource(R.drawable.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_secondFragment_to_menuChooseEmotionFragment);
            }
        });
//        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }
}