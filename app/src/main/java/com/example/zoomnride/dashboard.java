package com.example.zoomnride;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;


public class dashboard extends Fragment {
        private int snapPosition;
        HorizontalScrollView horizontalScrollView;
       CircleImageView homePBtn;
        Button home, history, wallet, profile;
    public dashboard() {
        // Required empty public constructor
    }



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        homePBtn = view.findViewById(R.id.homeProfileImg);
        horizontalScrollView = view.findViewById(R.id.horizon);

        horizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        int scrollX =horizontalScrollView.getScrollX();
                        snapPosition = calculateSnapPosition(scrollX);

                        ObjectAnimator animator =ObjectAnimator.ofInt(horizontalScrollView,"scrollX",snapPosition);
                        animator.setDuration(300);
                        animator.start();
                }
                return false;
            }
            private int calculateSnapPosition(int scrollX){
                int childCount = horizontalScrollView.getChildCount();
                int itemWidth = horizontalScrollView.getChildAt(0).getWidth();
                int snapPosition = ((scrollX + itemWidth/2)/itemWidth)*itemWidth;

                if (snapPosition < 0){
                    snapPosition =0;
                }
                else if (snapPosition > (childCount-1)*itemWidth){
                    snapPosition = (childCount-1)*itemWidth;
                }
                return snapPosition;
            }
        });
        profile_fragment profile_fragment = new profile_fragment();
        homePBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        return view;
    }

}