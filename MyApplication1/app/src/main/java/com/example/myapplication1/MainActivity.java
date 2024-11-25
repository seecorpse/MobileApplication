package com.example.myapplication1;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editOwnerName, editVisitReason;
    private Spinner spinnerAnimal;
    private SeekBar seekBarAge;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editOwnerName = findViewById(R.id.edit_owner_name);
        editVisitReason = findViewById(R.id.edit_visit_reason);
        spinnerAnimal = findViewById(R.id.spinner_animal);
        seekBarAge = findViewById(R.id.seekBar_age);
        timePicker = findViewById(R.id.time_picker);
        Button buttonConfirm = findViewById(R.id.button_confirm);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.animal_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAnimal.setAdapter(adapter);

        buttonConfirm.setOnClickListener(v -> {
            String ownerName = editOwnerName.getText().toString();
            String visitReason = editVisitReason.getText().toString();
            String animalType = spinnerAnimal.getSelectedItem().toString();
            int age = seekBarAge.getProgress();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            String time = String.format("%02d:%02d", hour, minute);

            String message = String.format("Wizyta: %s, %s, %d lat, %s, %s",
                    ownerName, animalType, age, visitReason, time);

            new AlertDialog.Builder(this)
                    .setTitle("Zaplanowana Wizyta")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}
