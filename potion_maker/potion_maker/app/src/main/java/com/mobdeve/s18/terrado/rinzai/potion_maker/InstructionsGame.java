package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InstructionsGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_instructions);
        buttonConfig();
    }

    private void buttonConfig(){
        Button buttonReturn = findViewById(R.id.button_instructions_return);
        buttonReturn.setOnClickListener(v -> finish());
    }
}
