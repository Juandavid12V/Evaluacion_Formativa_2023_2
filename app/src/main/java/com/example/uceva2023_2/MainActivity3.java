package com.example.uceva2023_2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {

    private SimpleExoPlayer exoPlayer;
    private HashMap<String, String> estacionesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        estacionesMap = new HashMap<>();
        estacionesMap.put("Radio 1", "https://21293.live.streamtheworld.com:443/RAC_1_SC");
        estacionesMap.put("Radio 2", "https://flucast-b03-04.flumotion.com/cope/net1.mp3");
        estacionesMap.put("Radio 3", "https://21263.live.streamtheworld.com/SER_SEVILLA_SC");
        estacionesMap.put("Radio 4", "https://rtvehlslivestream.akamaized.net/hls/live/2096782/rne5/main/T1696546956/128/s25240628.aac");
        estacionesMap.put("Radio 5", "https://25543.live.streamtheworld.com/RAC_1_SC?dist=web");
        estacionesMap.put("Radio 6", "http://url_para_radio_2.com/stream");

        Intent intent = getIntent();
        String nombreEstacion = intent.getStringExtra("nombreEstacion");
        String radioUrl = estacionesMap.get(nombreEstacion);

        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        MediaItem mediaItem = MediaItem.fromUri(radioUrl);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();

        Button buttonPlay = findViewById(R.id.buttonPlay);
        Button buttonStop = findViewById(R.id.buttonStop);

        buttonPlay.setOnClickListener(v -> {
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(true);
            }
        });

        buttonStop.setOnClickListener(v -> {
            if (exoPlayer != null) {
                exoPlayer.setPlayWhenReady(false);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
            exoPlayer = null;
        }
    }
}