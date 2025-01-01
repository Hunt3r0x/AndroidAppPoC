package io.hextree.proofofconcept;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EchoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        // Get the Intent
        Intent receivedIntent = getIntent();
        String receivedText = receivedIntent.getStringExtra(Intent.EXTRA_TEXT);

        // Ensure null safety and handle any unexpected input
        if (receivedText != null && !receivedText.isEmpty()) {
            TextView textView = findViewById(R.id.textView2);
            // Safely display the entire string including spaces
            textView.setText("You Shared: " + receivedText.trim());
        } else {
            // Handle case where no text was received
            TextView textView = findViewById(R.id.textView2);
            textView.setText("No text was shared!");
        }
    }
}
