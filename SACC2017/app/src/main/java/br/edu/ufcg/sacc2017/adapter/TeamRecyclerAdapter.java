package br.edu.ufcg.sacc2017.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.model.SupportMember;
import br.edu.ufcg.sacc2017.model.TeamMember;
import br.edu.ufcg.sacc2017.util.Base64Parser;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by easyo on 27/05/2017.
 */

public class TeamRecyclerAdapter extends RecyclerView.Adapter<TeamRecyclerAdapter.ViewHolder> {

    private List<TeamMember> mTeamMembers;

    ViewHolder mViewHolder;

    public TeamRecyclerAdapter(List<TeamMember> supportMemberSet) {
        this.mTeamMembers = supportMemberSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_equipe, parent, false);

        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mTeamMembers.get(position).getName());
        holder.role.setText(mTeamMembers.get(position).getRole());
        holder.description.setText(mTeamMembers.get(position).getDescription());

        holder.setTeamMember(mTeamMembers.get(position));
        holder.setup();

    }


    @Override
    public int getItemCount() {
        return mTeamMembers.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView role;
        TextView description;
        CircleImageView ivLogo;

        TeamMember teamMember;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            role = (TextView) itemView.findViewById(R.id.tv_role);
            ivLogo = (CircleImageView) itemView.findViewById(R.id.iv_logo);
        }

        public void setup(){

            if (getTeamMember().getPhoto().equals("") || getTeamMember().getPhoto() == null){
                ivLogo.setImageResource(R.drawable.avatar);
            } else {
                ivLogo.setImageBitmap(setLogo());
            }


        }

        private Bitmap setLogo() {
            Base64Parser parser = new Base64Parser();

            return parser.parseToBitmap(getTeamMember().getPhoto());
        }

        public TeamMember getTeamMember() {
            return teamMember;
        }

        public void setTeamMember(TeamMember teamMember) {
            this.teamMember = teamMember;
        }
    }
}