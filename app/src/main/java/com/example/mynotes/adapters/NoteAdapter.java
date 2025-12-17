package com.example.mynotes.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

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

        CardView card = row.findViewById(R.id.cardNote);
        TextView tvNom = row.findViewById(R.id.tvNom);
        TextView tvDate = row.findViewById(R.id.tvDate);
        TextView tvPriorite = row.findViewById(R.id.tvPriorite);

        if (note != null) {
            tvNom.setText(note.getNom());
            tvDate.setText(note.getDate());
            tvPriorite.setText(note.getPriorite());

            int bgColor;
            int badgeColor;

            switch (note.getPriorite()) {
                case "Haute":
                    bgColor = getContext().getColor(R.color.note_high_bg);
                    badgeColor = getContext().getColor(R.color.priority_high);
                    break;
                case "Moyenne":
                    bgColor = getContext().getColor(R.color.note_medium_bg);
                    badgeColor = getContext().getColor(R.color.priority_medium);
                    break;
                default:
                    bgColor = getContext().getColor(R.color.note_low_bg);
                    badgeColor = getContext().getColor(R.color.priority_low);
                    break;
            }

            card.setCardBackgroundColor(bgColor);
            tvPriorite.setBackgroundColor(badgeColor);
        }

        return row;
    }
}
