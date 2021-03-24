package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.ViewHolder>{
    ArrayList<Ambulance_driver> ambList;
    ArrayList<Ambulance_driver> searchBarDriverList;
    Context mCont;

    public AmbulanceAdapter(ArrayList<Ambulance_driver> ambList, Context mCont) {
        this.ambList = ambList;
        this.mCont = mCont;
        this.searchBarDriverList = ambList;
    }

    @NonNull
    @Override
    public AmbulanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_row2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmbulanceAdapter.ViewHolder holder, int position) {
        holder.Name.setText(ambList.get(position).getDName());
        holder.Company.setText(ambList.get(position).getCompany());
        holder.Location.setText(ambList.get(position).getDLocation());
        holder.Image.setImageResource(ambList.get(position).getDImage());

        ItemAnimation.animateFadeIn(holder.itemView,position);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mCont,AmbulanceInfoUI.class);
            intent.putExtra("",searchBarDriverList.get(position).getDImage());
            intent.putExtra("Driver Name", searchBarDriverList.get(position).getDName());
            intent.putExtra("Company", searchBarDriverList.get(position).getCompany());
            intent.putExtra("Location", searchBarDriverList.get(position).getDLocation());
            mCont.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return searchBarDriverList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Company,Location;
        ImageView Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.txtdrivername);
            Company =itemView.findViewById(R.id.txtcompany);
            Location = itemView.findViewById(R.id.txtdriverlocation);
            Image = itemView.findViewById(R.id.imgdriver);
        }
    }

    public Filter getFiltered(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();
                if(key.isEmpty()){
                    searchBarDriverList = ambList;
                }
                else {
                    ArrayList<Ambulance_driver> lstFiltered = new ArrayList<>();
                    for(Ambulance_driver row: ambList){
                        if(row.getDLocation().toLowerCase().contains(key.toLowerCase())){
                            lstFiltered.add(row);
                        }
                    }
                    searchBarDriverList =lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = searchBarDriverList;
                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                //noinspection unchecked
                searchBarDriverList = (ArrayList<Ambulance_driver>)results.values;
                notifyDataSetChanged();

            }
        };
    }
}
