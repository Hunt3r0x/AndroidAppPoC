package io.cobrydroid.proofofconcept;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hello, World");
        SeekBar seekBar = findViewById(R.id.seekBar);
        // Button to navigate to CurlActivity
        Button btnCurl = findViewById(R.id.btnCurl);
        btnCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentProgress = seekBar.getProgress();
                int newProgress = currentProgress + 1;

                // Ensure we don't go over the max
                if (newProgress <= seekBar.getMax()) {
                    seekBar.setProgress(newProgress);
                    textView.setText("Progress incremented to: " + newProgress);
                } else {
                    textView.setText("Max progress reached: " + currentProgress);
                }
            }
        });

        TextView seekBarValue = findViewById(R.id.seekBarValue);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("Progress: " + progress);
                if (progress == 69) {
                    Intent curlIntent = new Intent(MainActivity.this, ClicksActivity.class);
                    startActivity(curlIntent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
