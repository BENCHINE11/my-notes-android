package com.example.mynotes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes.R;

public class AddNoteActivity extends AppCompatActivity {

    private EditText etNom, etDesc, etDate;
    private Spinner spPriorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etNom = findViewById(R.id.etNom);
        etDesc = findViewById(R.id.etDesc);
        etDate = findViewById(R.id.etDate);
        spPriorite = findViewById(R.id.spPriorite);
        Button btnSave = findViewById(R.id.btnSave);

        ArrayAdapter<CharSequence> prioAdapter = ArrayAdapter.createFromResource(
                this, R.array.priorites, android.R.layout.simple_spinner_item
        );
        prioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPriorite.setAdapter(prioAdapter);

        btnSave.setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        String nom = etNom.getText().toString().trim();
        String desc = etDesc.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String prio = String.valueOf(spPriorite.getSelectedItem());

        if (nom.isEmpty()) {
            Toast.makeText(this, "Le nom est obligatoire.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (date.isEmpty()) {
            Toast.makeText(this, "La date est obligatoire.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(NoteListActivity.EXTRA_NOM, nom);
        data.putExtra(NoteListActivity.EXTRA_DESC, desc);
        data.putExtra(NoteListActivity.EXTRA_DATE, date);
        data.putExtra(NoteListActivity.EXTRA_PRIORITE, prio);

        setResult(RESULT_OK, data);
        finish(); // exigence cycle de vie
    }
}
