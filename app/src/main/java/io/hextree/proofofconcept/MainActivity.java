package io.hextree.proofofconcept;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    String Name = "Cobry Manga";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Wanna Play?");

        Button FirsButt1 = findViewById(R.id.FirsButt1);
        FirsButt1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                textView.setText(String.format("Hello %s! You Clicked: %d time", Name, counter));
                if (counter == 3) {
                    Log.v("AnasLog", "You Clicked 3 Times.");
                    Intent echoIntent = new Intent(MainActivity.this, EchoActivity.class);
                    echoIntent.putExtra(Intent.EXTRA_TEXT, "Congratulations! " + Name + " You clicked 3 times.");
                    startActivity(echoIntent);
                    counter = 0;
                }
            }
        });

        // Button to navigate to CurlActivity
        Button btnCurl = findViewById(R.id.btnCurl);
        btnCurl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curlIntent = new Intent(MainActivity.this, CurlActivity.class);
                startActivity(curlIntent);
            }
        });
    }
}
