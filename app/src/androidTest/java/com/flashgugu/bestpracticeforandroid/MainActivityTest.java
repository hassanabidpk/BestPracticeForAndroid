package com.flashgugu.bestpracticeforandroid;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.flashgugu.bestpracticeforandroid.ui.MainActivity;
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mainActivity = getActivity();

    }

    public void testUserInfo(){
        TextView userName = (TextView)mainActivity.findViewById(R.id.user_name);

        assertEquals(userName.getText().toString(), "Ace Kim");
    }
}