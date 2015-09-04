package com.flashgugu.bestpracticeforandroid.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flashgugu.bestpracticeforandroid.R;

public class Item2Fragment extends BestPracticeFragment {

    private final String TAG = Item2Fragment.class.getSimpleName();

    private static final String KEY_TITLE = "title";

    private CharSequence mTitle;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Fragment title.
     * @return A new instance of fragment Item2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Item2Fragment newInstance(CharSequence title) {
        Item2Fragment fragment = new Item2Fragment();
        Bundle args = new Bundle();
        args.putCharSequence(KEY_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public Item2Fragment() {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item2, container, false);
    }
}
