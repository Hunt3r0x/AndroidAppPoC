package io.cobrydroid.proofofconcept;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import io.cobrydroid.weatherusa.InternetUtil2;

public class JNIActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jniactivity);

        TextView textView = findViewById(R.id.textView);
        textView.setText("FLAG: " + InternetUtil2.solve());
    }
}