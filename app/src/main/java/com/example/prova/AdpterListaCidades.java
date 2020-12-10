package com.example.prova;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdpterListaCidades extends RecyclerView.Adapter<AdpterListaCidades.ViewHolder>{
    private List<Cidade> list;
    private LayoutInflater layoutInflater;
    private static RecyclerViewOnClickListener recyclerViewOnClickListener;

    public AdpterListaCidades(List<Cidade> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }


    public void setRecyclerOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.listpaises,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.city.setText(list.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //public TextView nome;

        public TextView city;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            city = (TextView) itemView.findViewById(R.id.txtCity);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(recyclerViewOnClickListener != null){
                recyclerViewOnClickListener.onClickListener(v,getLayoutPosition());
            }
        }
    }
}
