package com.example.mynotes.activities;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotes.R;
import com.example.mynotes.adapters.PhotoAdapter;
import com.example.mynotes.utils.PhotoStore;

import java.util.ArrayList;
import java.util.Set;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        TextView tvEmpty = findViewById(R.id.tvEmpty);
        RecyclerView rv = findViewById(R.id.rvGallery);

        Set<String> raw = PhotoStore.getPhotoUris(this);
        ArrayList<Uri> uris = new ArrayList<>();
        for (String s : raw) uris.add(Uri.parse(s));

        if (uris.isEmpty()) {
            tvEmpty.setVisibility(android.view.View.VISIBLE);
        } else {
            tvEmpty.setVisibility(android.view.View.GONE);
        }

        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setAdapter(new PhotoAdapter(uris));
    }
}
