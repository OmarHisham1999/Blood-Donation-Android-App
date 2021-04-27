package com.example.blooddonation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{


    ArrayList<Model> mlist;
    Context context;

    public MyAdapter(Context context, ArrayList<Model> mlist){

        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mlist.get(position);
        holder.email.setText(model.getEmail());
        holder.bloodtype.setText(model.getBloodtype());
        holder.status.setText(model.getStatus());
        holder.numberofdonors.setText(model.getNumberpfdonors());
        holder.patientname.setText(model.getPatientname());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView email, bloodtype, status, numberofdonors, patientname;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email_text);
            bloodtype = itemView.findViewById(R.id.bloodtype_text);
            status = itemView.findViewById(R.id.status_text);
            numberofdonors = itemView.findViewById(R.id.numberofdonors_text);
            patientname = itemView.findViewById(R.id.patientname_text);
        }
    }
}
