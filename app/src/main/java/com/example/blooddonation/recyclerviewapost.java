package com.example.blooddonation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class recyclerviewapost extends RecyclerView.Adapter<recyclerviewapost.PostViewHolder> {

    List<Post> posts;
    private static Context context;

    public recyclerviewapost(List<Post> posts) {
        this.posts = posts;

    }

    public recyclerviewapost(List<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);

        PostViewHolder postViewHolder = new PostViewHolder(view);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {

        holder.hospital_name.setText(posts.get(position).hospitalname);
        holder.blood_type.setText(posts.get(position).bloodtype);
        holder.description.setText(posts.get(position).description);
        holder.progress.setProgress(posts.get(position).progress);
        holder.status.setText(posts.get(position).status);
        holder.number_of_donors.setText(posts.get(position).numberofdonors);
        holder.status.setText(posts.get(position).status);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public static class PostViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView hospital_name;
        TextView status;
        TextView number_of_donors;
        TextView blood_type;
        TextView description;
        ImageButton plusone;
        ProgressBar progress;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.postcard);
            hospital_name = (TextView) itemView.findViewById(R.id.hospitalnamecard);
            description = (TextView) itemView.findViewById(R.id.descriptioncard);
            number_of_donors = (TextView) itemView.findViewById(R.id.numberofdonorscard);
            status = (TextView) itemView.findViewById(R.id.statuscard);
            blood_type = (TextView) itemView.findViewById(R.id.bloodtypecard);
            progress = (ProgressBar) itemView.findViewById(R.id.progressBar);
            plusone = (ImageButton) itemView.findViewById(R.id.plusonecardbtn);

        }
    }
}
