package com.example.rmayo.myapplication.mFragments;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.rmayo.myapplication.R;

/**
 * Created by rmayo on 23/10/2016.
 */
public class AvatarFragment extends Fragment {
    protected static final int TIMER_RUNTIME = 1000;

    protected boolean mbActive;
    protected ProgressBar mProgresBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_avatar,container,false);

        //mProgresBar = (ProgressBar)
        return rootView;
    }
}
