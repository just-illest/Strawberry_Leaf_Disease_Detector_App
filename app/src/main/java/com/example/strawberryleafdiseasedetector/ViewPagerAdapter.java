package com.example.strawberryleafdiseasedetector;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new CommonLeafSpot();
            case 1: return new CercosporaLeafSpot();
            case 2: return new BlackLeafSpot();
            case 3: return new LeafBlight();
            case 4: return new LeafScortch();
            default: return new CommonLeafSpot();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
