package com.jaimenejaim.android.animalcare.ui.my_animals_detail.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.ui.my_animals_detail.others.MyAnimalsDetailSettings;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jaimenejaim on 14/03/2018.
 */

public class MyAnimalsDetailSettingsAdapter extends RecyclerView.Adapter<MyAnimalsDetailSettingsAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<MyAnimalsDetailSettings> settings;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }


    public MyAnimalsDetailSettingsAdapter(List<MyAnimalsDetailSettings> settings) {
        this.settings = settings;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyAnimalsDetailSettings setting = settings.get(position);

        switch (setting.getSettingsEnum()){

            case VACCINATION_CARD:
                Picasso.get().load(R.drawable.ic_vaccination).into(holder.imageViewIcon);
                break;
            case MEDICINES:
                Picasso.get().load(R.drawable.ic_medical_pill).into(holder.imageViewIcon);
                break;
            case EVENTS:
                Picasso.get().load(R.drawable.ic_event).into(holder.imageViewIcon);
                break;
            case QUERY:
                Picasso.get().load(R.drawable.ic_query).into(holder.imageViewIcon);
                break;


        }

        holder.textViewTitle.setText(setting.getTitle());



        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClick(setting);
        });
    }

    @Override
    public int getItemCount() {
        return settings.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewIcon;
        TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewIcon = itemView.findViewById(R.id.imageViewIcon);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(MyAnimalsDetailSettings item);
    }
}