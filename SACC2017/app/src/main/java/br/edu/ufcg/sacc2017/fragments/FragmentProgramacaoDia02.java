package br.edu.ufcg.sacc2017.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.edu.ufcg.sacc2017.Adapter.RecyclerViewAdapter;
import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.models.Apoio;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentProgramacaoDia02 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG_DIA2 = "FragmentProgramacaoDia02";

    private String[] title = {"Palestra: O Negócio da Vida", "Palestra: Sistemas para a Saúde",
    "Coffee Break", "Campus APPs", "----","Oficina de Entrevistas", "Minicurso de ReactJS",
            "Mini Maratona", "----", "Copa SACC de Robocode", "Minicurso de ASP.NET"};

    private String[] description = {"8:30 \nLocal: Centro de Extensão", "8:30 \nLocal: Centro de Extensão",
            "10:00 \nLocal: Centro de Extensão", "10:15 \nLocal: Centro de Extensão",
            "12:00 \nLocal: Tirando uma soneca que já já tem mais", "14:00 \nLocal: a ser definido",
            "14:00 \nLocal: LCC1 - Reenge (Bloco CB)", "14:00 \nLocal: aguardando informação",
            "16:00 \nLocal: Fui comprar pipoca", "16:15 \nLocal: aguardando informação",
            "18:00 \nLocal: REENGE - 10 (Bloco CB)"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programacao_dia02,container,false);

        mRecyclerView = new RecyclerView(rootView.getContext());
        mRecyclerView.findViewById(R.id.reclycer_view_2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((RecyclerViewAdapter) mAdapter).setOnItemClickListener(new RecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
            }
        });

    }

    private ArrayList<Apoio> getDataSet() {
        ArrayList results = new ArrayList<Apoio>();
        for (int index = 0; index < title.length; index++) {
            Apoio obj = new Apoio(title[index],
                    description[index]);
            results.add(index, obj);
        }
        return results;
    }

}
