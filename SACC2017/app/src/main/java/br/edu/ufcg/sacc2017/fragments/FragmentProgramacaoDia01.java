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

public class FragmentProgramacaoDia01 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG1 = "FragmentProgramacaoDia01";

    private String[] title = {"Abertura",  "Palestra: Combate à Corrupção",
    "Coffee Break", "TFG, Como fazer o melhor jogo do mundo?",
    "----", "Minicurso de API Rest com NodeJS", "Minicurso Latex",
    "----", "Copa SACC de Robocode", "Capture The Flag"};

    private String[] description={"8:30 \nLocal: Centro de Extensão","8:30 \nLocal: Centro de Extensão",
        "10:00 \nLocal: Centro de Extensão", "10:15 \nLocal: Centro de Extensão",
        "12:00 \nLocal: Tirando aquela soneca", "14:00 \nLocal: LCC1 - Reenge (Bloco CB)",
        "14:00 \nLocal: LCC2 (Bloco CN)", "16:00 \nLocal: Fui comprar a corneta para o Robocode",
        "16:15 \nLocal: esperando confirmação", "18:00 \nLocal: esperando confirmação"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programacao_dia01,container,false);

        mRecyclerView = new RecyclerView(rootView.getContext());
        mRecyclerView.findViewById(R.id.reclycer_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;

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
