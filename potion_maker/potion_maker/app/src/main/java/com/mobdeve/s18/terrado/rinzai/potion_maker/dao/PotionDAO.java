package com.mobdeve.s18.terrado.rinzai.potion_maker.dao;

import java.util.ArrayList;

public interface PotionDAO {
    //returns true is insert was successful
    //false if not successful
    boolean addPotion(PotionModel potion);

    //returns a all posts
    ArrayList<PotionModel> getAllPotions();

    boolean clearDatabase();
}
