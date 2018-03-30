package com.jaimenejaim.android.animalcare.ui.my_animals.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;

import java.util.List;

import io.rmiri.skeleton.SkeletonGroup;

/**
 * Created by jaimenejaim on 11/03/2018.
 */

public class MyAnimalsRecyclerAdapter extends RecyclerView.Adapter<MyAnimalsRecyclerAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Animal> animals;
    private Context context;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }


    public MyAnimalsRecyclerAdapter(Context context, List<Animal> animals) {
        this.animals = animals;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_animals_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Glide.with(context).load(animals.get(position).getPhoto()).into(holder._photo);

        holder._name.setText(animals.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            if(listener !=null) listener.onItemClick(animals.get(position));
        });



        if(animals.size() > 0){
            holder._skeletonGroup.setShowSkeleton(false);
            holder._skeletonGroup.finishAnimation();
        }
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView _photo;
        TextView _name;
        TextView _breed;
        SkeletonGroup _skeletonGroup;

        ViewHolder(View view) {
            super(view);
            _photo = view.findViewById(R.id.img);
            _name = view.findViewById(R.id.textViewName);
            _breed = view.findViewById(R.id.textViewBreed);
            _skeletonGroup = view.findViewById(R.id.skeletonGroup);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Animal item);
    }

}

