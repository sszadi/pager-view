package com.hfad.viewpager;

import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.hfad.viewpager.fragments.FirstFragment;
import com.hfad.viewpager.fragments.SecondFragment;
import com.hfad.viewpager.fragments.ThirdFragment;
import com.hfad.viewpager.model.News;
import com.hfad.viewpager.model.NewsResponse;
import com.hfad.viewpager.rest.ApiClient;
import com.hfad.viewpager.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {


    @BindView(R.id.view_pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager()));


    }

    private class CustomPagerAdapter extends FragmentPagerAdapter {

        public CustomPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                case 2:
                    return new ThirdFragment();
                default:
                    return new FirstFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


}
