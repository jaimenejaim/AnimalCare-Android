package com.jaimenejaim.android.animalcare.ui.my_animals.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.rmiri.skeleton.SkeletonGroup;
import io.rmiri.skeleton.SkeletonView;

/**
 * Created by jaimenejaim on 11/03/2018.
 */

public class MyAnimalsRecyclerAdapter extends RecyclerView.Adapter<MyAnimalsRecyclerAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Animal> animals;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.listener = onItemClickListener;
    }



    public MyAnimalsRecyclerAdapter(List<Animal> animals){
        this.animals = animals;
    }


    @NonNull
    @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_animals_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(animals.get(position));
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
        SkeletonView _skeletonViewPhoto;
        SkeletonView _skeletonViewName;
        SkeletonView _skeletonViewBreed;

        public ViewHolder(View itemView) {
            super(itemView);
            _photo = itemView.findViewById(R.id.img);
            _name =  itemView.findViewById(R.id.textViewName);
            _breed = itemView.findViewById(R.id.textViewBreed);
            _skeletonGroup = itemView.findViewById(R.id.skeletonGroup);
        }

        public void bind(final Animal item) {

            if(_name != null){
                Picasso.get().load("http://res.cloudinary.com/drfcfazt5/image/upload/v1521046642/placeholder_dog_tehfax.jpg").into(_photo);
                _name.setText(item.getName());
                _breed.setText(item.getBreed().getDescription());

                itemView.setOnClickListener(v -> {
                    if(listener !=null) listener.onItemClick(item);
                });
            }

            if(item.getId() > 0){
                _skeletonGroup.setShowSkeleton(false);
                _skeletonGroup.finishAnimation();
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Animal item);
    }

}
