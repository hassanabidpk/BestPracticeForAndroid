package com.flashgugu.bestpracticeforandroid.ui.setting;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.flashgugu.bestpracticeforandroid.R;

public class PreferencesFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
