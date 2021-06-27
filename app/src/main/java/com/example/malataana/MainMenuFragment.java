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

public class MainMenuFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Image border = view.findViewById(R.id.border_1);
        ImageView soundImage=(ImageView) view.findViewById(R.id.border_1);
        soundImage.setImageResource(R.drawable.listen_fear_final);//set the source in java class
        //sound icon
        //TODO record voice and attach it

        ImageView learnImage = (ImageView) view.findViewById(R.id.border_2);
        learnImage.setImageResource(R.drawable.learn);//set the source in java class
        learnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainMenuFragment.this)
                        .navigate(R.id.action_mainMenuFragment_to_menuChooseEmotionFragment);
            }
        });

        ImageView quizImage = (ImageView) view.findViewById(R.id.border_3);
        quizImage.setImageResource(R.drawable.quiz);//set the source in java class
        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.stravv);
//        sound.setOnClickListener(new View.OnClickListener(){
//
//            public void onClick(View v) {
//                mp.start();
//            }
//        });
//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(MainMenuFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });

    }
}