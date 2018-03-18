package com.jaimenejaim.android.animalcare.ui.settings.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimenejaim.android.animalcare.R;
import com.jaimenejaim.android.animalcare.data.persistence.entity.Settings;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jaimenejaim on 14/03/2018.
 */

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<Settings> settings;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }


    public SettingsAdapter(List<Settings> settings) {
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
        Settings setting = settings.get(position);

        switch (setting.getSettingsEnum()){

            case ACCOUNT:
                Picasso.get().load(R.drawable.ic_account).into(holder.imageViewIcon);
                break;
            case ADOPT:
                Picasso.get().load(R.drawable.ic_care).into(holder.imageViewIcon);
                break;
            case ADDRESS:
                Picasso.get().load(R.drawable.ic_address).into(holder.imageViewIcon);
                break;
            case PAYMENTS:
                Picasso.get().load(R.drawable.ic_creditcard).into(holder.imageViewIcon);
                break;
            case EVALUATION:
                Picasso.get().load(R.drawable.ic_rating).into(holder.imageViewIcon);
                break;
            case INSTRUCTIONS:
                Picasso.get().load(R.drawable.ic_info).into(holder.imageViewIcon);
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
        void onItemClick(Settings item);
    }
}