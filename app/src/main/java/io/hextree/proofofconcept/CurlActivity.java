package io.hextree.proofofconcept;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class CurlActivity extends AppCompatActivity {

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curl);

        responseTextView = findViewById(R.id.responseTextView); // Ensure your layout has a TextView with this ID

        sendRequest();
    }

    @SuppressLint("SetTextI18n")
    private void sendRequest() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://pkgtopoca.free.beeceptor.com") // Replace with your URL
                .build();

        new Thread(() -> {
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseBody = response.body().string();
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
