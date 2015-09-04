package com.flashgugu.bestpracticeforandroid.ui;

import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flashgugu.bestpracticeforandroid.R;
import com.flashgugu.bestpracticeforandroid.helper.GlideCircleTransformHelper;

public class MainActivity extends AppCompatActivity implements BestPracticeFragment.OnFragmentInteractionListener {

    //We should naming "m"+valuename for membervalues
    private DrawerLayout mDrawerLayout;

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
        selectFragment = HomeFragment.newInstance(getResources().getString(R.string.home));
        showFragment(selectFragment);

        initNavigationView();
        initToolbar();
    }

    private void initToolbar() {
        //We can naming free for localvalues
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // This code is used for Animation of DrawerArrow
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
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

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(getString(R.string.home));
        }

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
                .load("https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xtf1/v/t1.0-1/10426818_298699680298861_6964286880340337220_n.jpg?oh=558c634bf659aabb4dcd3f3a358b74a9&oe=56800343&__gda__=1450909156_e6b74805f182808291d8b7f89755f0c4")
                .transform(new GlideCircleTransformHelper(getApplicationContext()))
                .into(avatarImage);

        nameText.setText("Kahye");
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

    private void showFragment(Fragment selectFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content_container, selectFragment);
        fragmentTransaction.addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
