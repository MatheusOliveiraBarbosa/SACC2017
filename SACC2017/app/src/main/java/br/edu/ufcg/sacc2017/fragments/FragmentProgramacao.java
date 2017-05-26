package br.edu.ufcg.sacc2017.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
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

    private FragmentTabHost tabHostProgramacao;

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

        tabHostProgramacao = new FragmentTabHost(getActivity());
        tabHostProgramacao.setup(getActivity(), getChildFragmentManager(), R.id.rl_programacao_container);

        tabHostProgramacao.addTab(tabHostProgramacao.newTabSpec("fragment_programacao_dia01").setIndicator("Dia 1"), FragmentProgramacaoDia01.class, null);
        tabHostProgramacao.addTab(tabHostProgramacao.newTabSpec("fragment_programacao_dia02").setIndicator("Dia 2"), FragmentProgramacaoDia02.class, null);
        tabHostProgramacao.addTab(tabHostProgramacao.newTabSpec("fragment_programacao_dia03").setIndicator("Dia 3"), FragmentProgramacaoDia03.class, null);

        return tabHostProgramacao;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabHostProgramacao = null;
    }
}
