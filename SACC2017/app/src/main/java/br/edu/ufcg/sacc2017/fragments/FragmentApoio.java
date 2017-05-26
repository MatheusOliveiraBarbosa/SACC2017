package br.edu.ufcg.sacc2017.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ufcg.sacc2017.R;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentApoio extends Fragment {

    public static FragmentApoio newInstance() {
        FragmentApoio fragment = new FragmentApoio();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_apoio, container, false);
    }
}
