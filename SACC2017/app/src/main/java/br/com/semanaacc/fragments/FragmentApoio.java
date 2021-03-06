package br.com.ufcg.sacc2017.fragments;


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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufcg.sacc2017.adapter.SupportRecyclerAdapter;
import br.com.ufcg.sacc2017.R;
import br.com.ufcg.sacc2017.model.SupportMember;
import br.com.ufcg.sacc2017.util.JSONRawReader;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentApoio extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "FragmentApoio";

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
        mAdapter = new SupportRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private List<SupportMember> getDataSet() {

        JSONRawReader reader = new JSONRawReader(getActivity());

        List<SupportMember> supportMembers = new ArrayList<>();

        try {
            JSONArray dados = reader.getJSONArrayFromRaw(R.raw.apoio);

            if (dados != null) {
                int len = dados.length();
                for (int i=0;i<len;i++){

                    SupportMember supportMember = new SupportMember();

                    supportMember.setDescription((String) dados.getJSONObject(i).get("descricao"));
                    supportMember.setTitle((String) dados.getJSONObject(i).get("sigla"));
                    supportMember.setSite((String) dados.getJSONObject(i).get("site"));
                    supportMember.setType((int) dados.getJSONObject(i).get("tipo"));
                    supportMember.setLogo((String) dados.getJSONObject(i).get("logo"));

                    supportMembers.add(supportMember);
                }
            }


            } catch (IOException e) {
            Log.e("APOIO", e.getMessage());
        } catch (JSONException e) {
            Log.e("APOIO", e.getMessage());
        }

        return supportMembers;
    }


}
