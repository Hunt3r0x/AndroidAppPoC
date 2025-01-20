package io.cobrydroid.proofofconcept;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ClicksActivity extends AppCompatActivity {

    int counter = 0;
    String Name = "Cobry Manga";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clicks);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Wanna Play?");

        Button FirsButt1 = findViewById(R.id.FirsButt1);
        FirsButt1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                counter = counter + 1;
                textView.setText(String.format("%s! You Clicked: %d time", Name, counter));
                if (counter == 30000) {
                    Log.v("AnasLog", "Congrats You Solved It (:");
                    Intent echoIntent = new Intent(ClicksActivity.this, EchoActivity.class);
                    echoIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.ssagzz) + " " + getString(R.string.ssag) + getString(R.string.ssagg) + getString(R.string.ssaggg) + getString(R.string.ssagGgg) + getString(R.string.ssagGggg) + getString(R.string.ssagggggg));
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
                Intent curlIntent = new Intent(ClicksActivity.this, CurlActivity.class);
                startActivity(curlIntent);
            }
        });

        // Button to navigate to EchoActivity
        Button btnEcho = findViewById(R.id.btnEcho);
        btnEcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curlIntent = new Intent(ClicksActivity.this, EchoActivity.class);
                startActivity(curlIntent);
            }
        });

        // Button to navigate to HTTP2Activity
        Button btnHTTP2 = findViewById(R.id.btnHTTP2);
        btnHTTP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curlIntent = new Intent(ClicksActivity.this, HTTP2.class);
                startActivity(curlIntent);
            }
        });

        // Button to navigate to JNIActivity
        Button JNIButton1 = findViewById(R.id.JNIButton1);
        JNIButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curlIntent = new Intent(ClicksActivity.this, JNIActivity.class);
                startActivity(curlIntent);
            }
        });
    }
}