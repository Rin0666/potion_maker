package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShelfGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_shelf);
        buttonConfig();
    }

    private void buttonConfig(){
        Button buttonReturn = (Button) findViewById(R.id.button_shelf_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}