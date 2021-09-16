package com.mobdeve.s18.terrado.rinzai.potion_maker.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
* Supply the information based on what you think is appropriate.
* */

public class PotionDatabase extends SQLiteOpenHelper {
    // DB information
    private static final String DATABASE_NAME = "potion.db";
    private static final int DATABASE_VERSION = 1;

    // Column names
    public static final String TABLE_POTION = "potion";
    public static final String POTION_ID = "id";
    public static final String POTION_NAME = "name";
    public static final String POTION_INGR1 = "ing1";
    public static final String POTION_INGR2 = "ing2";
    public static final String POTION_INGR3 = "ing3";
    //public static final String POTION_COLOR = "color";


    // Table information
    private static final String CREATE_POTION_TABLE =
            "create table " + TABLE_POTION +
                    " ( "
                    + POTION_ID + " integer primary key, "
                    + POTION_NAME + " text, "
                    + POTION_INGR1 + " text, "
                    + POTION_INGR2 + " text, "
                    + POTION_INGR3 + " text ); ";

    public PotionDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_POTION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POTION);
        onCreate(db);
    }
}
