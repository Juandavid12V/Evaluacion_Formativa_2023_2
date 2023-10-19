package com.example.uceva2023_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;



import java.net.URL;
import java.util.HashMap;

public class MainActivity3 extends AppCompatActivity {

    private SimpleExoPlayer exoPlayer;
    private PlayerView playerView;
    private HashMap<String, String> estacionesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        estacionesMap = new HashMap<>();
        estacionesMap.put("Radio 1", "http://livestreaming3.esradio.fm/stream64.mp3");
        estacionesMap.put("Radio 2", "http://url_para_radio_2.com/stream");

        Intent intent = getIntent();
        String nombreEstacion = intent.getStringExtra("nombreEstacion");
        String radioUrl = estacionesMap.get(nombreEstacion);

        reproducirRadio(radioUrl);
    }

    private void reproducirRadio(String radioUrl) {
        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(exoPlayer);

        MediaItem mediaItem = MediaItem.fromUri(radioUrl);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy",Toast.LENGTH_LONG).show();
    }

    public void Volver(View d){
        //Toast.makeText(this, "Hola 2", Toast.LENGTH_LONG).show();
        Intent ir = new Intent(this, MainActivity2.class);
        startActivity(ir);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.agree) {
            Toast.makeText(this, "agree", Toast.LENGTH_LONG).show();
        } else if (id == R.id.badThread) {
            Toast.makeText(this, "badThread", Toast.LENGTH_LONG).show();
        }
        return true;
    }

}