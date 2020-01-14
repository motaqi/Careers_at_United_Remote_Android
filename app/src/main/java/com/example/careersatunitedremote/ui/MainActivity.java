package com.example.careersatunitedremote.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.careersatunitedremote.R;
import com.example.careersatunitedremote.adapter.TabAdapter;
import com.example.careersatunitedremote.ui.repositoriesList.RepositoriesListFragment;
import com.example.careersatunitedremote.ui.settings.SettingsFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {

    //Fragments
    private RepositoriesListFragment repositoriesListFragment;
    private SettingsFragment settingsFragment;

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.toolBarTitle)
    TextView toolBarTitle;

    TabAdapter tabAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeFragments();
        setupTabLayout();
    }

    private void initializeFragments() {
        repositoriesListFragment = new RepositoriesListFragment();
        settingsFragment = new SettingsFragment();
    }

    private void setupTabLayout() {
        tabAdapter = new TabAdapter(this.getSupportFragmentManager());
        tabAdapter.addFragment(repositoriesListFragment, getString(R.string.trending_title));
        tabAdapter.addFragment(settingsFragment, getString(R.string.settings_title));
        tabLayout.addOnTabSelectedListener(this);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_start);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_settings);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab.getPosition() == 0){
            toolBarTitle.setText(R.string.trending_repos_title);
        }else {
            toolBarTitle.setText(R.string.settings_title);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
