package com.bkav.isoonline.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.bkav.isoonline.R;
import com.bkav.isoonline.fragments.InforTabFragment;
import com.bkav.isoonline.fragments.ReportTabFragment;
import com.bkav.isoonline.fragments.ResultTabFragment;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    // HaiKH sự kiện chuyển tab bên thư viên
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new InforTabFragment();
            case 1:
                return new ResultTabFragment();
            case 2:
                return new ReportTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Thông tin";
            case 1:
                return "Kết quả";
            case 2:
                return "Báo cáo";
        }
        return null;
    }

}
