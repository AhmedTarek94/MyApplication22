package com.example.ltc_pc.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

final Context context=this;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.mtc);

        tabLayout.getTabAt(1).setIcon(R.drawable.parts);

        tabLayout.getTabAt(2).setIcon(R.drawable.iugrclogo);

        tabLayout.getTabAt(3).setIcon(R.drawable.enroll);



    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Tab_mtc();
                case 1:
                    return new Tab_parts();
                case 2:
                    return new Tab_conf();
                default:
                    return new Tab_enroll6();
            }
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                //case 0:
                  //  return " MTC";
                case 1:
                    return "Parts.";
                case 2:
                    return "IUGRC";
                case 3:
                    return "Enroll";
            }
            return null;
        }
    }
}