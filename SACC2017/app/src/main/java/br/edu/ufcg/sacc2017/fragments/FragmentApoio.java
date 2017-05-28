package br.edu.ufcg.sacc2017.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.sacc2017.adapter.ApoioRecyclerAdapter;
import br.edu.ufcg.sacc2017.adapter.RecyclerViewAdapter;
import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.model.Apoio;
import br.edu.ufcg.sacc2017.util.JSONRawReader;

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
        mAdapter = new ApoioRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private List<Apoio> getDataSet() {

        JSONRawReader reader = new JSONRawReader(getActivity());

        List<Apoio> apoios = new ArrayList<>();

        try {
            JSONArray dados = reader.getJSONArrayFromRaw(R.raw.apoio);
            Log.i("Apoio", dados.toString());

            if (dados != null) {
                int len = dados.length();
                for (int i=0;i<len;i++){

                    Apoio apoio = new Apoio();

                    apoio.setDescription((String) dados.getJSONObject(i).get("descricao"));
                    apoio.setTitle((String) dados.getJSONObject(i).get("sigla"));
                    apoio.setSite((String) dados.getJSONObject(i).get("site"));
                    apoio.setType((int) dados.getJSONObject(i).get("tipo"));
                    apoio.setLogo((String) dados.getJSONObject(i).get("logo"));

                    apoios.add(apoio);
                }
            }


            } catch (IOException e) {
            Log.e("APOIO", e.getMessage());
        } catch (JSONException e) {
            Log.e("APOIO", e.getMessage());
        }

        return apoios;
    }


}
