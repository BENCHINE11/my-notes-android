package com.example.mynotes.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes.R;

public class DetailsNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_note);

        TextView tvNom = findViewById(R.id.tvDetailNom);
        TextView tvDesc = findViewById(R.id.tvDetailDesc);
        TextView tvDate = findViewById(R.id.tvDetailDate);
        TextView tvPrio = findViewById(R.id.tvDetailPrio);
        Button btnBack = findViewById(R.id.btnBack);

        tvNom.setText(getIntent().getStringExtra(NoteListActivity.EXTRA_NOM));
        tvDesc.setText(getIntent().getStringExtra(NoteListActivity.EXTRA_DESC));
        tvDate.setText(getIntent().getStringExtra(NoteListActivity.EXTRA_DATE));
        tvPrio.setText(getIntent().getStringExtra(NoteListActivity.EXTRA_PRIORITE));

        btnBack.setOnClickListener(v -> finish());
    }
}
