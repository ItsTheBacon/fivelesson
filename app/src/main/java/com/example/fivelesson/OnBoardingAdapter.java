package com.example.fivelesson;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class OnBoardingAdapter extends FragmentStatePagerAdapter {
    List<OnboardingModel> list;

    public OnBoardingAdapter(@NonNull FragmentManager fm, List<OnboardingModel> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public OnBoardingFragment getItem(int position) {
        return OnBoardingFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
