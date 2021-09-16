package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
        buttonConfig();
    }

    private void buttonConfig(){
        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(v -> {
            Intent i = new Intent(MainMenu.this,MainGame.class);
            startActivity(i);
        });

        Button buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(v -> {
            Intent i = new Intent(MainMenu.this,MainSettings.class);
            startActivity(i);
        });

        Button buttonExit = findViewById(R.id.button_exit);
        buttonExit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });
    }
}