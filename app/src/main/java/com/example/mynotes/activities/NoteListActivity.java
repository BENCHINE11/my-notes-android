package com.example.mynotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.mynotes.R;
import com.example.mynotes.adapters.NoteAdapter;
import com.example.mynotes.models.Note;

import java.util.ArrayList;

public class NoteListActivity extends AppCompatActivity {

    public static final String EXTRA_NOM = "extra_nom";
    public static final String EXTRA_DESC = "extra_desc";
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_PRIORITE = "extra_priorite";

    private final ArrayList<Note> notes = new ArrayList<>();
    private NoteAdapter adapter;

    private final ActivityResultLauncher<Intent> addNoteLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String nom = data.getStringExtra(EXTRA_NOM);
                    String desc = data.getStringExtra(EXTRA_DESC);
                    String date = data.getStringExtra(EXTRA_DATE);
                    String prio = data.getStringExtra(EXTRA_PRIORITE);

                    if (nom != null && date != null && prio != null) {
                        notes.add(new Note(nom, desc == null ? "" : desc, date, prio));
                        adapter.notifyDataSetChanged();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        ListView listView = findViewById(R.id.listViewNotes);

        // ✅ Les deux boutons sont des FloatingActionButton
        FloatingActionButton btnAdd = findViewById(R.id.btnAddNote);
        FloatingActionButton btnCamera = findViewById(R.id.btnCamera);

        adapter = new NoteAdapter(this, notes);
        listView.setAdapter(adapter);

        btnCamera.setOnClickListener(v -> {
            Intent i = new Intent(NoteListActivity.this, CameraActivity.class);
            startActivity(i);
        });

        btnAdd.setOnClickListener(v -> {
            Intent i = new Intent(NoteListActivity.this, AddNoteActivity.class);
            addNoteLauncher.launch(i);
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Note n = notes.get(position);
            Intent i = new Intent(NoteListActivity.this, DetailsNoteActivity.class);
            i.putExtra(EXTRA_NOM, n.getNom());
            i.putExtra(EXTRA_DESC, n.getDescription());
            i.putExtra(EXTRA_DATE, n.getDate());
            i.putExtra(EXTRA_PRIORITE, n.getPriorite());
            startActivity(i);
        });
    }
}
