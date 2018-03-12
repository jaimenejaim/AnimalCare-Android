package com.jaimenejaim.android.animalcare.ui.my_animals.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;

/**
 * Created by jaimenejaim on 11/03/2018.
 */

public class MyAnimalsRecyclerAdapter extends RecyclerView.Adapter<MyAnimalsRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private String[] title = {};
    private String[] bleed = {};



    public MyAnimalsRecyclerAdapter(Context context, String[] object){
        inflater = LayoutInflater.from(context);
        this.title = object;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.my_animals_list_row,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder._name.setText(title[position]);
        holder._breed.setText("Golden Retreiver");
//            holder._photo.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView _photo;
        TextView _name;
        TextView _breed;

        public ViewHolder(View itemView) {

            super(itemView);
            _photo = itemView.findViewById(R.id.img);
            _name =  itemView.findViewById(R.id.textViewName);
            _breed = itemView.findViewById(R.id.textViewBreed);
        }
    }
}
