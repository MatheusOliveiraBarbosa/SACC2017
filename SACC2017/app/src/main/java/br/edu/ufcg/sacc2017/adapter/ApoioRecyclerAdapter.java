package br.edu.ufcg.sacc2017.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.edu.ufcg.sacc2017.R;
import br.edu.ufcg.sacc2017.model.Apoio;
import br.edu.ufcg.sacc2017.util.Base64Parser;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by easyo on 27/05/2017.
 */

public class ApoioRecyclerAdapter extends RecyclerView.Adapter<ApoioRecyclerAdapter.ViewHolder> {

    private List<Apoio> mApoioset;
    private static RecyclerViewAdapter.MyClickListener myClickListener;

    ViewHolder mViewHolder;

    public ApoioRecyclerAdapter(List<Apoio> apoioSet) {
        this.mApoioset = apoioSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_apoio, parent, false);

        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mApoioset.get(position).getTitle());
        holder.description.setText(mApoioset.get(position).getDescription());

        holder.setApoio(mApoioset.get(position));
        holder.setup();

    }


    @Override
    public int getItemCount() {
        return mApoioset.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout container;
        TextView title;
        TextView description;
        CircleImageView ivLogo;

        Apoio apoio;


        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            container = (LinearLayout) itemView.findViewById(R.id.ll_card_container);
            ivLogo = (CircleImageView) itemView.findViewById(R.id.iv_logo);
        }

        public void setup(){
            container.setOnClickListener(openSite());
            ivLogo.setImageBitmap(setLogo());



            if (getApoio().getType() == 2){

                Context context = ivLogo.getContext();
                ivLogo.setLayoutParams(new LinearLayout.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.rounded_image), context.getResources().getDimensionPixelSize(R.dimen.rounded_image)));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    title.setTextColor(context.getColor(R.color.colorAccentLight));
                } else {
                    title.setTextColor(context.getResources().getColor(R.color.colorAccentLight));
                }

            }
        }

        private Bitmap setLogo() {
            Base64Parser parser = new Base64Parser();

            return parser.parseToBitmap(getApoio().getLogo());
        }

        private View.OnClickListener openSite() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse(getApoio().getSite());

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    v.getContext().startActivity(intent);
                }
            };
        }

        public Apoio getApoio() {
            return apoio;
        }

        public void setApoio(Apoio apoio) {
            this.apoio = apoio;
        }
    }
}