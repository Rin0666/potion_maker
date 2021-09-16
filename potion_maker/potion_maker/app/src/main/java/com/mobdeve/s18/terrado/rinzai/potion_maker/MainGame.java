package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAO;
import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionDAOSQLImpl;
import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionModel;

public class MainGame extends AppCompatActivity {

    SwipeListener swipeListener;
    ConstraintLayout constraintLayout;
    private float acelVal;
    private float acelLast;
    private float shake;
    ScaleGestureDetector objScaleGestureDetector;
    private PotionDAO potionDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        constraintLayout = findViewById(R.id.main_game_layout);
        buttonConfig();
        swipeListener = new SwipeListener(constraintLayout);

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast=SensorManager.GRAVITY_EARTH;
        shake = 0.00f;
        objScaleGestureDetector = new ScaleGestureDetector(this, new PinchZoomListener());
        this.potionDAO = new PotionDAOSQLImpl(getApplicationContext());
    }

    private int bottlectr = 0;
    private Ingredient current_ing = null;
    private PotionModel curr_potion = new PotionModel();
    private void buttonConfig(){
        Button buttonStart = findViewById(R.id.button_game_return);
        buttonStart.setOnClickListener(v -> finish());
        Button buttonShelf = findViewById(R.id.button_game_self);
        buttonShelf.setOnClickListener(v -> {
            Intent i = new Intent(MainGame.this,ShelfGame.class);
            startActivity(i);
        });
        Button buttonInstruction = findViewById(R.id.button_instructions);
        buttonInstruction.setOnClickListener(v -> {
            Intent i = new Intent(MainGame.this,InstructionsGame.class);
            startActivity(i);
        });
        ImageView ginseng_img = findViewById(R.id.ginseng);
        ImageView turmeric_img = findViewById(R.id.turmeric);
        ImageView cinnamon_img = findViewById(R.id.cinnamon);
        ImageButton current_img = findViewById(R.id.current_ingredient);
        ImageView bottle_img = findViewById(R.id.bottle);
        ginseng_img.setOnClickListener(v -> {
            current_ing = new Ingredient("ginseng");
            current_img.setImageResource(R.drawable.ginseng);
        });

        turmeric_img.setOnClickListener(v -> {
            current_ing = new Ingredient("turmeric");
            current_img.setImageResource(R.drawable.turmeric);
        });

        cinnamon_img.setOnClickListener(v -> {
            current_ing = new Ingredient("cinnamon");
            current_img.setImageResource(R.drawable.cinnamon);
        });

        current_img.setOnTouchListener(new View.OnTouchListener() {

            final GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    if(current_ing != null){
                        if(!current_ing.isCrushed() && !current_ing.isSliced()){
                            current_ing.setMashed(true);
                            current_ing.setCrushed(false);
                            current_ing.setSliced(false);

                            switch(current_ing.getName()){
                                case "ginseng":
                                    current_img.setImageResource(R.drawable.mashedginseng);
                                    break;
                                case "cinnamon":
                                    current_img.setImageResource(R.drawable.mashedcinn);
                                    break;
                                case "turmeric":
                                    current_img.setImageResource(R.drawable.mashedturmeric);
                                    break;
                                default:
                                    current_img.setImageResource(android.R.color.transparent);
                            }
                        }
                    }
                    return super.onDoubleTap(e);
                }

                @Override
                public boolean onSingleTapConfirmed(MotionEvent e) {
                    //add to potion temporary
                    if(current_ing != null){
                        if(bottlectr==0){
                            bottle_img.setImageResource(R.drawable.abottle);
                            curr_potion.setIng1(current_ing.getValue());
                        }
                        if(bottlectr==1){
                            bottle_img.setImageResource(R.drawable.bbottle);
                            curr_potion.setIng2(current_ing.getValue());
                        }
                        if(bottlectr==2){
                            bottle_img.setImageResource(R.drawable.cbottle);
                            curr_potion.setIng3(current_ing.getValue());
                        }
                        bottlectr++;
                        if(bottlectr>3) {
                            bottlectr = 3;
                            Toast.makeText(getApplication().getBaseContext(), "Potion is full!",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            current_img.setImageResource(android.R.color.transparent);
                            current_ing=null;
                        }
                    }
                    return super.onSingleTapConfirmed(e);
                }
            });
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });

        bottle_img.setOnClickListener(v -> Toast.makeText(getApplication().getBaseContext(), "Current ingredients : "+curr_potion.getIng1() + ", " + curr_potion.getIng2() + ", " + curr_potion.getIng3(),
            Toast.LENGTH_LONG).show());
    }

    private class SwipeListener implements View.OnTouchListener{
        GestureDetector gestureDetector;

        SwipeListener(View view){
            int threshold = 100;
            int velocity_threshold = 100;

            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onDown(MotionEvent e){
                            return true;
                        }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try {
                                if(Math.abs(xDiff) > Math.abs(yDiff)){
                                    if(Math.abs(xDiff)>threshold && Math.abs(velocityX) > velocity_threshold){

                                        ImageView current_img = findViewById(R.id.current_ingredient);
                                        if(current_ing != null){

                                            if(!current_ing.isCrushed() && !current_ing.isMashed()){
                                                current_ing.setSliced(true);
                                                current_ing.setCrushed(false);
                                                current_ing.setMashed(false);
                                                switch(current_ing.getName()){
                                                    case "ginseng":
                                                        current_img.setImageResource(R.drawable.slicedginseng);
                                                        break;
                                                    case "cinnamon":
                                                        current_img.setImageResource(R.drawable.slicedcinnamon);
                                                        break;
                                                    case "turmeric":
                                                        current_img.setImageResource(R.drawable.slicedturmeric);
                                                        break;
                                                    default:
                                                        current_img.setImageResource(android.R.color.transparent);
                                                }
                                            }
                                        }
                                        return true;
                                    }
                                } else {
                                    if(Math.abs(yDiff) > threshold && Math.abs(velocityY)>velocity_threshold){
                                        return true;
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            ImageView bottle_img = findViewById(R.id.bottle);
            acelLast = acelVal;
            acelVal = (float) Math.sqrt(x*x + y*y + z*z);
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if(shake > 4){
                if(!(curr_potion.getIng1().equals("none"))){
                    curr_potion.generateName();
                    Intent i = new Intent(MainGame.this,PotionCreated.class);
                    i.putExtra("potion", curr_potion);
                    potionDAO.addPotion(curr_potion);
                    startActivity(i);
                }
                bottle_img.setImageResource(R.drawable.bottle);
                curr_potion = new PotionModel();
                bottlectr =0;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        objScaleGestureDetector.onTouchEvent(event);
        return true;
    }

    public class PinchZoomListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float gesturefactor = detector.getScaleFactor();
            ImageView current_img = findViewById(R.id.current_ingredient);
            if(gesturefactor > 1){
                if(current_ing != null){
                    if(!current_ing.isMashed() && !current_ing.isSliced()){
                        current_ing.setCrushed(true);
                        current_ing.setMashed(false);
                        current_ing.setSliced(false);

                        switch(current_ing.getName()){
                            case "ginseng":
                                current_img.setImageResource(R.drawable.crushedginseng);
                                break;
                            case "cinnamon":
                                current_img.setImageResource(R.drawable.crushedcinnamon);
                                break;
                            case "turmeric":
                                current_img.setImageResource(R.drawable.crushedturmeric);
                                break;
                            default:
                                current_img.setImageResource(android.R.color.transparent);
                        }
                    }
                }
            }  //zoom in

            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
        }
    }
}

