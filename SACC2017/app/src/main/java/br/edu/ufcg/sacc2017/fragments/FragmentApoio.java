package br.edu.ufcg.sacc2017.fragments;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import br.edu.ufcg.sacc2017.Adapter.RecyclerViewAdapter;
import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.models.Apoio;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentApoio extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "FragmentApoio";

    private String[] listName = {"UFCG", "TFG", "Red Hat", "GuardiansDSC", "PET Computação", "SPLAB"};
    private String[] listDescription = {"Universidade Federal de Campina Grande",
    "A TFG é a maior desenvolvedora de games mobile da América Latina.",
    "A Red Hat é o principal fornecedor mundial de soluções de software de open source.",
    "Adicionar Descrição GuardiansDSC",
    "Adicionar Descrição PET Computação",
    "Tem como missão promover o desenvolvimento do estado-da-arte na teoria e prática da Engenharia de Software."};

    private int[] listDrawable= {(R.drawable.ufcg), (R.drawable.tfg), (R.drawable.redhat), (R.drawable.guardians), (R.drawable.pet), (R.drawable.splab) };

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

        mRecyclerView = new RecyclerView(getActivity());
        mRecyclerView.findViewById(R.id.reclycer_view);
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
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });

    }

    private ArrayList<Apoio> getDataSet() {
        ArrayList results = new ArrayList<Apoio>();
        for (int index = 0; index < listName.length; index++) {
            Apoio obj = new Apoio(listName[index],
                    listDescription[index]);
            results.add(index, obj);
        }
        return results;
    }
}
