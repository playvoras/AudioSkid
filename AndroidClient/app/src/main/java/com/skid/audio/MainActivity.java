package com.skid.audio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    static {
        System.loadLibrary("audio-skid");
    }

    public native void startAudioEngine(String ip);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(60, 60, 60, 60);

        TextView title = new TextView(this);
        title.setText("AUDIO SKID");
        title.setTextSize(24);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 50);

        EditText ipInput = new EditText(this);
        ipInput.setHint("PC IP Address");
        
        Button connectBtn = new Button(this);
        connectBtn.setText("CONNECT");

        layout.addView(title);
        layout.addView(ipInput);
        layout.addView(connectBtn);

        setContentView(layout);

        connectBtn.setOnClickListener(v -> {
            String ip = ipInput.getText().toString();
            if (!ip.isEmpty()) {
                new Thread(() -> startAudioEngine(ip)).start();
            }
        });
    }
}
