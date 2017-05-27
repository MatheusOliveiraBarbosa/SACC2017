package br.edu.ufcg.sacc2017.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.models.Apoio;

/**
 * Created by mathe on 26/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ApoioHolder> {


    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Apoio> mApoioset;
    private static MyClickListener myClickListener;

    public static class ApoioHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;

        public ApoioHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.tv_title);
            dateTime = (TextView) itemView.findViewById(R.id.tv_description);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerViewAdapter(ArrayList<Apoio> apoioSet) {
        this.mApoioset = apoioSet;
    }

    @Override
    public ApoioHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        ApoioHolder dataObjectHolder = new ApoioHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ApoioHolder holder, int position) {
        holder.label.setText(mApoioset.get(position).getTitle());
        holder.dateTime.setText(mApoioset.get(position).getDescription());
    }

    public void addItem(Apoio apoio, int index) {
        mApoioset.add(index, apoio);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mApoioset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mApoioset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
