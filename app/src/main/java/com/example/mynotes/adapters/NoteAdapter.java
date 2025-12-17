package com.example.mynotes.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mynotes.R;
import com.example.mynotes.models.Note;

import java.util.List;

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(@NonNull Activity context, @NonNull List<Note> notes) {
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.row_note, parent, false);
        }

        Note note = getItem(position);

        View priorityBar = row.findViewById(R.id.viewPriorityBar);
        TextView tvNom = row.findViewById(R.id.tvNom);
        TextView tvDate = row.findViewById(R.id.tvDate);

        if (note != null) {
            tvNom.setText(note.getNom());
            tvDate.setText(note.getDate());

            int colorRes;
            switch (note.getPriorite()) {
                case "Haute":
                    colorRes = R.color.priority_high;
                    break;
                case "Moyenne":
                    colorRes = R.color.priority_medium;
                    break;
                default:
                    colorRes = R.color.priority_low;
                    break;
            }
            priorityBar.setBackgroundResource(colorRes);
        }

        return row;
    }
}
