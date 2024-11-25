package com.example.myapplication2;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textDisplay;
    private SeekBar seekBarFontSize;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDisplay = findViewById(R.id.text_display);
        seekBarFontSize = findViewById(R.id.seekBar_font_size);
        editTextMessage = findViewById(R.id.edit_text_message);
        Button buttonApply = findViewById(R.id.button_apply);
        seekBarFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textDisplay.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        buttonApply.setOnClickListener(v -> {
            String message = editTextMessage.getText().toString();
            if (!message.isEmpty()) {
                textDisplay.setText(message);
            } else {
                textDisplay.setText("Dzień dobry");
            }
        });
    }
}
