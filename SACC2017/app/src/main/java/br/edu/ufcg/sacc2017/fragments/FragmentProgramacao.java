package br.edu.ufcg.sacc2017.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import br.edu.ufcg.sacc2017.R;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentProgramacao extends Fragment {



    public static FragmentProgramacao newInstance() {
        FragmentProgramacao fragment = new FragmentProgramacao();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolBar);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_programacao, container, false);
    }
}
