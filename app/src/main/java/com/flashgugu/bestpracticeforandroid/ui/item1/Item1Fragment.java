package com.flashgugu.bestpracticeforandroid.ui.item1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flashgugu.bestpracticeforandroid.R;
import com.flashgugu.bestpracticeforandroid.ui.BestPracticeFragment;
import com.flashgugu.bestpracticeforandroid.ui.MainActivity;

public class Item1Fragment extends BestPracticeFragment {

    private final String TAG = Item1Fragment.class.getSimpleName();

    private static final String KEY_TITLE = "title";

    private CharSequence mTitle;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Fragment title.
     * @return A new instance of fragment Item1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Item1Fragment newInstance(CharSequence title) {
        Item1Fragment fragment = new Item1Fragment();
        Bundle args = new Bundle();
        args.putCharSequence(KEY_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public Item1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getCharSequence(KEY_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /**
         * Write your viewlogic
         */

        View rootView = inflater.inflate(R.layout.fragment_item1, container, false);

        initToolbar(rootView);

        return rootView;
    }

    public void initToolbar(View rootView) {
        Toolbar toolbar = (Toolbar)rootView.findViewById(R.id.item1_toolbar);
        toolbar.setTitle(mTitle);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        MainActivity.actionBarDrawerToggle.syncState();
    }
}
