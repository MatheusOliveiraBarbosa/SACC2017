package br.edu.ufcg.sacc2017.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.edu.ufcg.sacc2017.adapter.RecyclerViewAdapter;
import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.models.Apoio;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentProgramacaoDia03 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG_DIA3 = "FragmentProgramacaoDia03";

    private String[] title = {"Palestra: Red Hat e OpenSource",
            "Coffee Break",
            "Mesa Redonda",
            "3MT",
            "Pausa Para Almoço",
            "Palestra: Trabalho Remoto",
            "Palestra: Uma Odisséia no Espaço.",
            "----",
            "Encerramento e Premiações",
            "Obrigado Por Participar"};

    private String[] description = {"8:30 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "10:00 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "10:15 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "10:15 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "Tirando aquela velha soneca",
            "14:00 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "14:00 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "16:00 \nAnsioso para receber minha premiação",
            "16:15 \nLocal: Centro de Extensão José Farias da Nóbrega",
            "18:00 \nVoltem Sempre :)"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programacao_dia03,container,false);

        mRecyclerView = new RecyclerView(rootView.getContext());
        mRecyclerView.findViewById(R.id.reclycer_view_3);
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
