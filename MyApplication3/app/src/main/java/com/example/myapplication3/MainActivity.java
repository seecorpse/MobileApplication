package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, repeatPasswordEditText;
    private TextView messageTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String repeatPassword = repeatPasswordEditText.getText().toString();
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                messageTextView.setText("Nieprawidłowy adres e-mail");
                return;
            }
            if (!password.equals(repeatPassword)) {
                messageTextView.setText("Hasła się różnią");
                return;
            }
            messageTextView.setText("Witaj " + email);
        });
    }
}
