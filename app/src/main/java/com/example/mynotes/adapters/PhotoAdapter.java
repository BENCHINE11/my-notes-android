package com.example.mynotes.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.VH> {

    private final List<Uri> uris;

    public PhotoAdapter(List<Uri> uris) {
        this.uris = uris;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.iv.setImageURI(uris.get(position));
    }

    @Override
    public int getItemCount() {
        return uris.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView iv;
        VH(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivPhoto);
        }
    }
}
