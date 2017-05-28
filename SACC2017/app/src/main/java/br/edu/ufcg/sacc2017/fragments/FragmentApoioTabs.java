package br.edu.ufcg.sacc2017.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ufcg.sacc2017.R;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentApoioTabs extends Fragment {

    private FragmentTabHost tabHostProgramacao;

    public static FragmentApoioTabs newInstance() {
        FragmentApoioTabs fragment = new FragmentApoioTabs();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tabHostProgramacao = new FragmentTabHost(getActivity());
        tabHostProgramacao.setup(getActivity(), getChildFragmentManager(), R.id.rl_apoio_container);

        tabHostProgramacao.addTab(tabHostProgramacao.newTabSpec("fragment_apoio").setIndicator("Apoio"), FragmentApoio.class, null);
        tabHostProgramacao.addTab(tabHostProgramacao.newTabSpec("fragment_equipe").setIndicator("Equipe"), FragmentEquipe.class, null);

        return tabHostProgramacao;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tabHostProgramacao = null;
    }
}
