package com.example.myapplication4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNewElement;
    private Button buttonAdd;
    private ListView listViewNotes;

    private ArrayList<String> notesList;
    private ArrayAdapter<String> notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNewElement = findViewById(R.id.editTextNewElement);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewNotes = findViewById(R.id.listViewNotes);
        notesList = new ArrayList<>();
        notesList.add("Zakupy: chleb, masło, ser");
        notesList.add("Do zrobienia: obiad, umyć podłogi");
        notesList.add("weekend: kino, spacer z psem");
        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        listViewNotes.setAdapter(notesAdapter);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNote = editTextNewElement.getText().toString().trim();

                if (!newNote.isEmpty()) {
                    notesList.add(newNote);  // Dodajemy nową notatkę do listy
                    notesAdapter.notifyDataSetChanged();  // Odświeżamy ListView
                    editTextNewElement.setText("");  // Czyszczymy pole edycyjne
                    Toast.makeText(MainActivity.this, "Notatka dodana", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić treść notatki", Toast.LENGTH_SHORT).show();
                }
            }
        });
        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedNote = notesList.get(position);
                Toast.makeText(MainActivity.this, "Wybrano: " + clickedNote, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
