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


public class AllergistsAdapter extends RecyclerView.Adapter<AllergistsAdapter.ViewHolder>{
    ArrayList<Allergists_Dr> arrayList;
    ArrayList<Allergists_Dr> searchBarList;
    Context mContext;

    public AllergistsAdapter(ArrayList<Allergists_Dr> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
        this.searchBarList = arrayList;

    }

    @NonNull
    @Override
    public AllergistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllergistsAdapter.ViewHolder holder, int position) {
        holder.Name.setText(arrayList.get(position).getName());
        holder.Specialist.setText(arrayList.get(position).getSpecialist());
        holder.Location.setText(arrayList.get(position).getLocation());
        holder.Image.setImageResource(arrayList.get(position).getImage());

        ItemAnimation.animateFadeIn(holder.itemView,position);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext,DoctorInfoUI.class);
            intent.putExtra("",searchBarList.get(position).getImage());
            intent.putExtra("Doctor Name", searchBarList.get(position).getName());
            intent.putExtra("Specialist", searchBarList.get(position).getSpecialist());
            intent.putExtra("Location", searchBarList.get(position).getLocation());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return searchBarList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name,Specialist,Location;
        ImageView Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.txtdrname);
            Specialist =itemView.findViewById(R.id.txtspl);
            Location = itemView.findViewById(R.id.txtlocation);
            Image = itemView.findViewById(R.id.imgView);
        }
    }
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();
                if(key.isEmpty()){
                    searchBarList = arrayList;
                }
                else {
                    ArrayList<Allergists_Dr> lstFiltered = new ArrayList<>();
                    for(Allergists_Dr row: arrayList){
                        if(row.getLocation().toLowerCase().contains(key.toLowerCase())){
                            lstFiltered.add(row);
                        }
                    }
                    searchBarList =lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = searchBarList;
                return filterResults;
            }


            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                //noinspection unchecked
                searchBarList = (ArrayList<Allergists_Dr>)results.values;
                notifyDataSetChanged();

            }
        };
    }

}
