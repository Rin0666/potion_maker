package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.terrado.rinzai.potion_maker.databinding.GameMainBinding;

public class MainGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        buttonConfig();
    }

    private Ingredient current_ing = new Ingredient("none");
    private void buttonConfig(){
        Button buttonStart = (Button) findViewById(R.id.button_game_return);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button buttonShelf = (Button) findViewById(R.id.button_game_self);
        buttonShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainGame.this,ShelfGame.class);
                startActivity(i);
            }
        });
        Button buttonInstruction = (Button) findViewById(R.id.button_instructions);
        buttonInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainGame.this,InstructionsGame.class);
                startActivity(i);
            }
        });
        ImageView ginseng_img = (ImageView) findViewById(R.id.ginseng);
        ImageView turmeric_img = (ImageView) findViewById(R.id.turmeric);
        ImageView cinnamon_img = (ImageView) findViewById(R.id.cinnamon);
        ImageView current_img = (ImageView) findViewById(R.id.current_ingredient);
        ImageView bottle_img = (ImageView) findViewById(R.id.bottle);
        ginseng_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_ing = new Ingredient("ginseng");
                current_img.setImageResource(R.drawable.ginseng);
            }
        });

        turmeric_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_ing = new Ingredient("turmeric");
                current_img.setImageResource(R.drawable.turmeric);
            }
        });

        cinnamon_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_ing = new Ingredient("cinnamon");
                current_img.setImageResource(R.drawable.cinnamon);
            }
        });

        current_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to potion temporary
                if(current_ing.getName().equals("ginseng")){
                    bottle_img.setBackgroundResource(R.drawable.ginseng);
                }
                if(current_ing.getName().equals("turmeric")){
                    bottle_img.setBackgroundResource(R.drawable.turmeric);
                }
                if(current_ing.getName().equals("cinnamon")){
                    bottle_img.setBackgroundResource(R.drawable.cinnamon);
                }
            }
        });
    }

}

