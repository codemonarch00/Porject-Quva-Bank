package com.example.zoomnride;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


public class profile_fragment extends Fragment {
        ImageButton buttonImg;
        ImageView banm;
    public profile_fragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_profile_fragment, container, false);

        banm = view.findViewById(R.id.banm);
        buttonImg = view.findViewById(R.id.personButton);
        banm.setImageResource(R.drawable.banm);


        return view;
    }

}