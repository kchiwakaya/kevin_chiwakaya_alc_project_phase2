package com.technologyedgezw.kevin_chiwakaya_alc_project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.technologyedgezw.kevin_chiwakaya_alc_project.R;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.Learning;
import com.technologyedgezw.kevin_chiwakaya_alc_project.models.SkillIQ;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {


        private final LayoutInflater mLayoutInflater;
        private ArrayList<SkillIQ> learners;


    public SkillAdapter(Context context, ArrayList<SkillIQ> learners) {
        mLayoutInflater =LayoutInflater.from(context);
        this.learners = learners;
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = mLayoutInflater.inflate(R.layout.skillslist, parent, false);
            return new ViewHolder(itemView);

        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIQ skillIQ = learners.get(position);
        holder.name.setText(skillIQ.getName());
        holder.country.setText(skillIQ.getCountry());
        holder.score.setText(String.valueOf(skillIQ.getScore()) );
        holder.ShowImage(skillIQ.getBadgeUrl());




    }



        @Override
        public int getItemCount() {
            return learners.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            private TextView name,country,score;
            private ImageView image;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name= itemView.findViewById(R.id.skill_name);
                country= itemView.findViewById(R.id.skillCountry);
                score =  itemView.findViewById(R.id.txtscore);
                image = itemView.findViewById(R.id.skillpic);

            }
            public void ShowImage(String imageurl)
            {
                Picasso.get()
                        .load(imageurl)
                        .into(image);
            }
        }
    }


