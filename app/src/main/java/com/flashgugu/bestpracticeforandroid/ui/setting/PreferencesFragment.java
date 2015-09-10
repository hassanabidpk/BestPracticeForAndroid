package com.flashgugu.bestpracticeforandroid.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;

import com.flashgugu.bestpracticeforandroid.R;

public class PreferencesFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String KEY_PREF_NOTI = "pref_noti";
    public static final String KEY_PREF_NOTI_CYCLETIME = "pref_noti_cycletime";

    private static final String TAG = PreferencesFragment.class.getSimpleName();
    private SharedPreferences sharedPref;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

        //Get stored Preferencedata from SharedPreference
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case KEY_PREF_NOTI:
                Log.d(TAG, "Change KEY_PREF_NOTI");

                break;

            case KEY_PREF_NOTI_CYCLETIME:
                Log.d(TAG, "Change KEY_PREF_NOTI_CYCLETIME");

                break;

            default:
                try {
                    throw new Exception("Cannot found preference key");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }
}
