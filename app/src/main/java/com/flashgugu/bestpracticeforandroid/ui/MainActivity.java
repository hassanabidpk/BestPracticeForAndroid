package com.flashgugu.bestpracticeforandroid.ui;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flashgugu.bestpracticeforandroid.R;
import com.flashgugu.bestpracticeforandroid.helper.GlideCircleTransformHelper;
import com.flashgugu.bestpracticeforandroid.ui.home.HomeFragment;
import com.flashgugu.bestpracticeforandroid.ui.item1.Item1Fragment;
import com.flashgugu.bestpracticeforandroid.ui.item2.Item2Fragment;

public class MainActivity extends AppCompatActivity implements BestPracticeFragment.OnFragmentInteractionListener {

    //We should naming "m"+valuename for membervalues
    private DrawerLayout mDrawerLayout;
    public static ActionBarDrawerToggle actionBarDrawerToggle;

    //TAG value is log identifier
    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment selectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        initView();
    }

    private void initView() {
        goToHome();

        initNavigationView();
        initToolbar();
    }

    private void initToolbar() {
        //We can naming free for localvalues

        // This code is used for Animation of DrawerArrow
       actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                syncState();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                syncState();
            }
        };

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);

        if (navigationView != null)
            setupDrawerContent(navigationView);

        setUserInfo();
    }

    private void setUserInfo() {
        ImageView avatarImage = (ImageView) findViewById(R.id.user_image);
        TextView nameText = (TextView) findViewById(R.id.user_name);

        /**
         * Glide Example.
         * How can we write image loade code more fixeible?
         * This is not answer!
         */

        Glide.with(getApplicationContext())
                .load("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xft1/v/t1.0-1/c144.112.815.815/s160x160/10009338_815132388514156_260385636_n.jpg?oh=19ccda918cb457fccb4df10915e12461&oe=56768A7E&__gda__=1453832943_e0256297712e3001006d95ed0bfe047f")
                .transform(new GlideCircleTransformHelper(getApplicationContext()))
                .into(avatarImage);

        nameText.setText("Ace Kim");
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        selectFragment = HomeFragment.newInstance(getResources().getString(R.string.home));

                        break;

                    case R.id.nav_item1:
                        selectFragment = Item1Fragment.newInstance(getResources().getString(R.string.item1));

                        break;

                    case R.id.nav_item2:
                        selectFragment = Item2Fragment.newInstance(getResources().getString(R.string.item2));

                        break;

                    case R.id.nav_setting:
                        break;

                    default:
                        try {
                            throw new Exception("Not Identified NavSelect Exception");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        break;
                }
                showFragment(selectFragment);
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public void showFragment(Fragment selectFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_container, selectFragment);
        fragmentTransaction.addToBackStack(null).commit();
    }

    public void goToHome() {
        selectFragment = HomeFragment.newInstance(getResources().getString(R.string.home));
        showFragment(selectFragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        goToHome();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
