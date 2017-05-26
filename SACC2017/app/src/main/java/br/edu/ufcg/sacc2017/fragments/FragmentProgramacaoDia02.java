package br.edu.ufcg.sacc2017.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.edu.ufcg.sacc2017.R;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentProgramacaoDia02 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programacao_dia02,container,false);
        return  rootView;
    }

}
