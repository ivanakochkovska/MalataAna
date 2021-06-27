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

public class MenuChooseEmotionFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView fear =(ImageView) view.findViewById(R.id.menu_fear);
        fear.setImageResource(R.drawable.fear_ana);//set the source in java class
        fear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuChooseEmotionFragment.this)
                        .navigate(R.id.action_menuChooseEmotionFragment_to_firstFragment);
            }
        });
        ImageView sadness =(ImageView) view.findViewById(R.id.menu_sadness);
        sadness.setImageResource(R.drawable.taga_ana);//set the source in java class
        sadness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuChooseEmotionFragment.this)
                        .navigate(R.id.action_menuChooseEmotionFragment_to_secondFragment);
            }
        });
        ImageView happiness = (ImageView) view.findViewById(R.id.menu_happiness);
        happiness.setImageResource(R.drawable.happiness_ana);//set the source in java class
        happiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuChooseEmotionFragment.this)
                        .navigate(R.id.action_menuChooseEmotionFragment_to_happinessFragment);
            }
        });
        ImageView love = (ImageView) view.findViewById(R.id.menu_love);
        love.setImageResource(R.drawable.love_ana);//set the source in java class
        ImageView anger = (ImageView) view.findViewById(R.id.menu_anger);
        anger.setImageResource(R.drawable.happiness_ana);//set the source in java class
        ImageView home = (ImageView) view.findViewById(R.id.menu_home);
        home.setImageResource(R.drawable.home);//set the source in java class
        ImageView sound = (ImageView) view.findViewById(R.id.sound_fear);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuChooseEmotionFragment.this)
                        .navigate(R.id.action_menuChooseEmotionFragment_to_mainMenuFragment2);
            }
        });
//        sound.setImageResource(R.drawable.listen_fear_final);//set the source in java class
//        final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.stravv);
//        sound.setOnClickListener(new View.OnClickListener(){
//
//            public void onClick(View v) {
//                mp.start();
//            }
//        });
//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(MenuChooseEmotionFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });

    }

}