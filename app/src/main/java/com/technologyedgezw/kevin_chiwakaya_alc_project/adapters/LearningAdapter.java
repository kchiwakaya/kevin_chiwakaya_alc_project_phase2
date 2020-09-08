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

import java.util.ArrayList;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private ArrayList<Learning> learners;
    public LearningAdapter(Context context,ArrayList<Learning> learners)
    {
        this.learners =learners;
        mLayoutInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.learninglist, parent, false);
       return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Learning learner = learners.get(position);
        holder.country.setText(learner.getCountry());
        holder.hours.setText(String.valueOf(learner.getHours()) );
        holder.name.setText(learner.getName());
        holder.showPic(learner.getBadgeUrl());
    }

    @Override
    public int getItemCount() {
        return learners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name,country,hours;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.learning_name);
            country =itemView.findViewById(R.id.leaningCountry);
            hours =itemView.findViewById(R.id.txthour);
            image = itemView.findViewById(R.id.pic);

        }
        public void showPic(String imageUrl)
        {
            Picasso.get()
                    .load(imageUrl)
                    .into(image);
        }
    }
}
