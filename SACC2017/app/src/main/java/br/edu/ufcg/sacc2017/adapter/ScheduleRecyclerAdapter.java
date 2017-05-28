package br.edu.ufcg.sacc2017.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.model.Schedule;
import br.edu.ufcg.sacc2017.util.Base64Parser;

/**
 * Created by mathe on 28/05/2017.
 */

public class ScheduleRecyclerAdapter extends RecyclerView.Adapter<ScheduleRecyclerAdapter.ViewHolder> {

    private List<Schedule> mSchedules;

    ScheduleRecyclerAdapter.ViewHolder mViewHolder;

    public ScheduleRecyclerAdapter(List<Schedule> scheduleSet) {
        this.mSchedules = scheduleSet;
    }

    @Override
    public ScheduleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        mViewHolder = new ScheduleRecyclerAdapter.ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ScheduleRecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(mSchedules.get(position).getName());
        holder.description.setText(mSchedules.get(position).getDescription());

        holder.setSchedule(mSchedules.get(position));
        holder.setup();

    }


    @Override
    public int getItemCount() {
        return mSchedules.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout container;
        TextView title;
        TextView description;
        ImageView ivLogo;

        Schedule schedule;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            ivLogo = (ImageView) itemView.findViewById(R.id.iv_card_logo);
            container = (RelativeLayout) itemView.findViewById(R.id.rl_schedule_container);
        }

        public void setup(){

            container.setOnClickListener(openSite());
            ivLogo.setImageBitmap(setLogo());

            if (getSchedule().getLogo().equals("") || getSchedule().getLogo() == null){
                ivLogo.setImageResource(R.drawable.ufcg);
            } else {
                ivLogo.setImageBitmap(setLogo());
            }


        }

        private Bitmap setLogo() {
            Base64Parser parser = new Base64Parser();

            return parser.parseToBitmap(getSchedule().getLogo());
        }

        public Schedule getSchedule() {
            return schedule;
        }

        public void setSchedule(Schedule schedule) {
            this.schedule = schedule;
        }

        private View.OnClickListener openSite() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse(getSchedule().getSite());

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    v.getContext().startActivity(intent);
                }
            };
        }

    }
}
