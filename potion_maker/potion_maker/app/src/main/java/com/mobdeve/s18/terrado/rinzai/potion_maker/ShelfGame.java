package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAO;
import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAOSQLImpl;
import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionModel;

import java.util.ArrayList;

public class ShelfGame extends AppCompatActivity {
    private ArrayList<PotionModel> data;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_shelf);

        this.data = new ArrayList<>();
        this.myAdapter = new MyAdapter(getApplicationContext(), this.data);

        PotionDAO potionDAO = new PotionDAOSQLImpl(getApplicationContext());

        this.recyclerView = findViewById(R.id.recyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.myAdapter);

        Button btn_return = findViewById(R.id.btn_return);

        this.data = potionDAO.getAllPotions();
        this.myAdapter = new MyAdapter(getApplicationContext(), this.data);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.myAdapter);

        btn_return.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        PotionDAO potionDAO = new PotionDAOSQLImpl(getApplicationContext());
        this.data = potionDAO.getAllPotions();
        this.myAdapter = new MyAdapter(getApplicationContext(), this.data);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setAdapter(this.myAdapter);
        super.onResume();
    }
}
