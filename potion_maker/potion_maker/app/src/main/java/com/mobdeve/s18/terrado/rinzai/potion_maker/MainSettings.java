package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAO;
import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAOSQLImpl;

public class MainSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);

        PotionDAO potionDAO = new PotionDAOSQLImpl(getApplicationContext());

        Button btn_reset = findViewById(R.id.btn_reset);
        Button btn_return = findViewById(R.id.btn_return);

        btn_reset.setOnClickListener(recyclerView ->{
            potionDAO.clearDatabase();
            Toast.makeText(getApplicationContext(), "Shelf has been reset", Toast.LENGTH_SHORT).show();
                });

        btn_return.setOnClickListener(v -> finish());
    }
}
