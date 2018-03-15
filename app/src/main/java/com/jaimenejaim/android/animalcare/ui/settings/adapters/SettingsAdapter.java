package com.jaimenejaim.android.animalcare.ui.settings.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jaimenejaim on 14/03/2018.
 */

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Animal> animals;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }


    public SettingsAdapter(List<Animal> animals) {
        this.animals = animals;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(animals.get(position));
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView _icon;
        TextView _title;
        LinearLayout _enter;

        public ViewHolder(View itemView) {
            super(itemView);
            _icon = itemView.findViewById(R.id.icon);
            _title = itemView.findViewById(R.id.title);
            _enter = itemView.findViewById(R.id.linearLayoutEnter);
        }

        public void bind(final Animal item) {

            if (_icon != null) {
                Picasso.get().load("http://res.cloudinary.com/drfcfazt5/image/upload/v1521046642/placeholder_dog_tehfax.jpg").into(_icon);
                _title.setText(item.getName());

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) listener.onItemClick(item);
                    }
                });
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(Animal item);
    }
}