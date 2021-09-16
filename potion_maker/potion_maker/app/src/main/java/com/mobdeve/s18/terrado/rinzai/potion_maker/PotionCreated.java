package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionModel;

public class PotionCreated extends AppCompatActivity {
    PotionModel potion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.potion_created);

        Intent intent = getIntent();
        potion = (PotionModel)intent.getSerializableExtra("potion");
        buttonConfig();
        init();
    }

    private void init(){
        TextView potionName = findViewById(R.id.potion_created_name);
        TextView potionIng1 = findViewById(R.id.potion_created_ing1);
        TextView potionIng2 = findViewById(R.id.potion_created_ing2);
        TextView potionIng3 = findViewById(R.id.potion_created_ing3);
        ImageView bottle = findViewById(R.id.potion_created_bottle);

        potionName.setText(potion.getName());
        potionIng1.setText(potion.getIng1());
        potionIng2.setText(potion.getIng2());
        potionIng3.setText(potion.getIng3());

        if(potion.getIng3().equals("none") && potion.getIng2().equals("none")){
            bottle.setImageResource(R.drawable.abottle);
        } else if (potion.getIng3().equals("none") ){
            bottle.setImageResource(R.drawable.bbottle);
        } else{
            bottle.setImageResource(R.drawable.cbottle);
        }
    }

    private void buttonConfig(){
        Button buttonReturn = findViewById(R.id.button_created_return);
        buttonReturn.setOnClickListener(v -> finish());
    }
}
