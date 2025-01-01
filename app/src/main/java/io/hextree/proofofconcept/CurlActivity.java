package io.hextree.proofofconcept;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CurlActivity extends AppCompatActivity {

    private TextView responseTextView;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curl);

        responseTextView = findViewById(R.id.responseTextView);
        client = new OkHttpClient();

        // Check if the Intent has a "url" extra
        if (getIntent() != null && getIntent().hasExtra("url")) {
            String urlFromIntent = getIntent().getStringExtra("url");
            if (urlFromIntent != null && !urlFromIntent.isEmpty()) {
                sendRequest(urlFromIntent);
            } else {
                responseTextView.setText("URL from intent is empty.");
            }
        } else {
            responseTextView.setText("No URL found in Intent extras.");
        }
    }

    private void sendRequest(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        new Thread(() -> {
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    runOnUiThread(() -> responseTextView.setText(responseBody));
                } else {
                    runOnUiThread(() ->
                            responseTextView.setText("Error: " + response.code()));
                }
            } catch (IOException e) {
                runOnUiThread(() ->
                        responseTextView.setText("Request failed: " + e.getMessage()));
            }
        }).start();
    }
}

