package com.example.fivelesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class OnBoardingFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String title;
    private String description;
    private int image;


    private TextView itemtitle , itemDescription;
    private ImageView itemImage;


    public OnBoardingFragment() {
    }



    public static OnBoardingFragment newInstance(String title, String description , int image) {
        OnBoardingFragment fragment = new OnBoardingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, description);
        args.putInt(ARG_PARAM3, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            description = getArguments().getString(ARG_PARAM2);
            image = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_on_boarding, container, false);
        itemtitle = view.findViewById(R.id.onboarding_item_title);
        itemDescription = view.findViewById(R.id.onboarding_item_decription);
        itemImage = view.findViewById(R.id.onboarding_item_image);
        itemtitle.setText(title);
        itemDescription.setText(description);
        itemImage.setImageResource(image);
        return view;
    }
}