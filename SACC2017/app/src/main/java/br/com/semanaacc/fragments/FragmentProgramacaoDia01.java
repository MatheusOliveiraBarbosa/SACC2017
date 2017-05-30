package br.com.ufcg.sacc2017.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

import br.com.ufcg.sacc2017.R;
import br.com.ufcg.sacc2017.adapter.ScheduleRecyclerAdapter;
import br.com.ufcg.sacc2017.model.Schedule;
import br.com.ufcg.sacc2017.util.JSONRawReader;

/**
 * Created by mathe on 25/05/2017.
 */

public class FragmentProgramacaoDia01 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG1 = "FragmentProgramacaoDia01";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_programacao_dia01,container,false);

        mRecyclerView = new RecyclerView(getActivity());
        mRecyclerView.findViewById(R.id.reclycer_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ScheduleRecyclerAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private List<Schedule> getDataSet() {


        JSONRawReader reader = new JSONRawReader(getActivity());

        List<Schedule> schedules = new ArrayList<>();

        try {
            JSONArray dados = reader.getJSONArrayFromRaw(R.raw.programacao_dia01);

            if (dados != null) {
                int len = dados.length();
                for (int i=0;i<len;i++){

                    Schedule schedule = new Schedule();

                    schedule.setDescription((String) dados.getJSONObject(i).get("descricao"));
                    schedule.setName((String) dados.getJSONObject(i).get("titulo"));
                    schedule.setTime((String) dados.getJSONObject(i).get("hora"));
                    schedule.setSite((String) dados.getJSONObject(i).get("localizacao"));
                    schedule.setLogo((String) dados.getJSONObject(i).get("logo"));
                    schedule.setPresenter((String) dados.getJSONObject(i).get("palestrante"));

                    schedules.add(schedule);
                }
            }


        } catch (IOException e) {
            Log.e("Fragment01IOException", e.getMessage());
        } catch (JSONException e) {
            Log.e("Fragment01JSONException", e.getMessage());
        }

        return schedules;

    }

}
