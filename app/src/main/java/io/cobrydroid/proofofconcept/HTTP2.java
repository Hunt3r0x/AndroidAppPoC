package io.cobrydroid.proofofconcept;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTP2 extends AppCompatActivity {

    private TextView homeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http2);

        homeText = findViewById(R.id.homeText);

        // Start the network operation in a separate thread
        ExecutorService getMainExecutor = Executors.newSingleThreadExecutor();
        getMainExecutor.execute(() -> {
            try {
                URL url = new URL("https://www.android.com/");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append('\n');
                }
                String result = sb.toString();

                // Update the TextView on the UI thread
                runOnUiThread(() -> homeText.setText(result));

                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> homeText.setText("Error fetching data!"));
            }
        });
    }
}
