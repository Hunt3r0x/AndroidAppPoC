package io.hextree.proofofconcept;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurlActivity extends AppCompatActivity {

    private EditText urlEditText;
    private TextView responseTextView;
    private OkHttpClient client;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curl);

        // Initialize UI components
        urlEditText = findViewById(R.id.urlEditText);
        Button sendRequestButton = findViewById(R.id.sendRequestButton);
        responseTextView = findViewById(R.id.responseTextView);

        // Create a single, reusable OkHttpClient
        client = new OkHttpClient();

        // Check if a URL was passed via Intent extras
        if (getIntent() != null && getIntent().hasExtra("url")) {
            String urlFromIntent = getIntent().getStringExtra("url");
            if (urlFromIntent != null && !urlFromIntent.isEmpty()) {
                // If a valid URL came from the Intent, auto-send the request
                sendRequest(urlFromIntent);
            } else {
                responseTextView.setText("URL from intent is empty.");
            }
        } else {
            responseTextView.setText("No URL found in Intent extras. You can enter one below.");
        }

        // Handle clicks on "Send Request" button
        sendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEnteredUrl = urlEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(userEnteredUrl)) {
                    sendRequest(userEnteredUrl);
                } else {
                    responseTextView.setText("Please enter a valid URL.");
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void sendRequest(String url) {
        // Build the request with the provided URL
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Network calls must be done on a background thread
        new Thread(() -> {
            try {
                // Execute the request
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    // Retrieve response body
                    String responseBody = response.body().string();
                    // Update UI on the main thread
                    runOnUiThread(() -> responseTextView.setText(responseBody));
                } else {
                    runOnUiThread(() -> responseTextView.setText("Error: " + response.code()));
                }
            } catch (IOException e) {
                runOnUiThread(() -> responseTextView.setText("Request failed: " + e.getMessage()));
            }
        }).start();
    }
}
