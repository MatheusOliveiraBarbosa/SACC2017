package br.edu.ufcg.sacc2017.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.models.Apoio;

/**
 * Created by mathe on 26/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ObjectHolder> {


    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Apoio> mApoioset;
    private static MyClickListener myClickListener;

    public static class ObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView title;
        TextView description;
        ImageView imageView;


        public ObjectHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
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
    public ObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        ObjectHolder dataObjectHolder = new ObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ObjectHolder holder, int position) {
        holder.title.setText(mApoioset.get(position).getTitle());
        holder.description.setText(mApoioset.get(position).getDescription());
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
