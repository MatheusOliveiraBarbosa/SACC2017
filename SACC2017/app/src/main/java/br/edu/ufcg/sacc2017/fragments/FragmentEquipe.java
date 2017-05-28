package br.edu.ufcg.sacc2017.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.adapter.SupportRecyclerAdapter;
import br.edu.ufcg.sacc2017.adapter.TeamRecyclerAdapter;
import br.edu.ufcg.sacc2017.model.SupportMember;
import br.edu.ufcg.sacc2017.model.TeamMember;
import br.edu.ufcg.sacc2017.util.JSONRawReader;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentEquipe extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "FragmentApoio";

    public static FragmentEquipe newInstance() {
        FragmentEquipe fragment = new FragmentEquipe();
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
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TeamRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private List<TeamMember> getDataSet() {

        JSONRawReader reader = new JSONRawReader(getActivity());

        List<TeamMember> teamMembers = new ArrayList<>();

        try {
            JSONArray dados = reader.getJSONArrayFromRaw(R.raw.equipe);

            if (dados != null) {
                int len = dados.length();
                for (int i=0;i<len;i++){

                    TeamMember teamMember = new TeamMember();

                    teamMember.setDescription((String) dados.getJSONObject(i).get("descricao"));
                    teamMember.setName((String) dados.getJSONObject(i).get("nome"));
                    teamMember.setRole((String) dados.getJSONObject(i).get("papel"));
                    teamMember.setPhoto((String) dados.getJSONObject(i).get("foto"));

                    teamMembers.add(teamMember);
                }
            }


            } catch (IOException e) {
            Log.e("TIME", e.getMessage());
        } catch (JSONException e) {
            Log.e("TIME", e.getMessage());
        }

        return teamMembers;
    }


}
