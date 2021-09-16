package com.mobdeve.s18.terrado.rinzai.potion_maker.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import java.util.ArrayList;

public class PotionDAOSQLImpl implements PotionDAO{

    private SQLiteDatabase database;
    private final PotionDatabase PotionDatabase;

    public PotionDAOSQLImpl(Context context){
        PotionDatabase = new PotionDatabase(context);
    }

    @Override
    public boolean addPotion(PotionModel Potion) {
        ContentValues values = new ContentValues();

        values.put(PotionDatabase.POTION_NAME, Potion.getName());
        values.put(PotionDatabase.POTION_INGR1, Potion.getIng1());
        values.put(PotionDatabase.POTION_INGR2, Potion.getIng2());
        values.put(PotionDatabase.POTION_INGR3, Potion.getIng3());

        database = PotionDatabase.getReadableDatabase();

        long id = database.insert (PotionDatabase.TABLE_POTION,null, values);

        if (database != null){
            database.close();
            return true;
        }

        return false;
    }

    @Override
    public ArrayList<PotionModel> getAllPotions() {
        ArrayList<PotionModel> result = new ArrayList<>();
        String [] columns = {
                PotionDatabase.POTION_NAME,
                PotionDatabase.POTION_INGR1,
                PotionDatabase.POTION_INGR2,
                PotionDatabase.POTION_INGR3};

        try {
            database = PotionDatabase.getReadableDatabase();

            Cursor cursor = database.query(PotionDatabase.TABLE_POTION,
                    columns,
                    null,
                    null,
                    null,
                    null,
                    null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                PotionModel POTION = new PotionModel();
                POTION.setName(cursor.getString(cursor.getColumnIndex(PotionDatabase.POTION_NAME)));
                POTION.setIng1(cursor.getString(cursor.getColumnIndex(PotionDatabase.POTION_INGR1)));
                POTION.setIng2(cursor.getString(cursor.getColumnIndex(PotionDatabase.POTION_INGR2)));
                POTION.setIng3(cursor.getString(cursor.getColumnIndex(PotionDatabase.POTION_INGR3)));
                result.add(POTION);
                cursor.moveToNext();
            }

            if (cursor != null) {
                cursor.close();
            }

            if (database != null) {
                database.close();
            }
        }catch(SQLiteException ignored){}

        return result;
    }

    @Override
    public boolean clearDatabase() {
        database = PotionDatabase.getReadableDatabase();

        database.execSQL("DELETE FROM " + PotionDatabase.TABLE_POTION);

        return true;
    }
}
