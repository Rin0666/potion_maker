package com.mobdeve.s18.terrado.rinzai.potion_maker.dao;

import com.mobdeve.s18.terrado.rinzai.potion_maker.R;

import java.io.Serializable;

public class PotionModel implements Serializable {
    private String name;
    private String ing1;
    private String ing2;
    private String ing3;

    public PotionModel(){
        this.ing1 = "none";
        this.ing2 = "none";
        this.ing3 = "none";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIng1() {
        return ing1;
    }

    public void setIng1(String ing1) {
        this.ing1 = ing1;
    }

    public String getIng2() {
        return ing2;
    }

    public void setIng2(String ing2) {
        this.ing2 = ing2;
    }

    public int getPotionImg(){
        if(this.ing1.equals("none")&&this.ing2.equals("none") && this.ing3.equals("none")){
        return R.drawable.bottle;
        } else if(!(this.ing1.equals("none"))&&this.ing2.equals("none") && this.ing3.equals("none")){
            return R.drawable.abottle;
        } else if(!(this.ing1.equals("none"))&& !(this.ing2.equals("none")) && this.ing3.equals("none")){
            return R.drawable.bbottle;
        } else {
            return R.drawable.cbottle;
        }
    }

    public String getIng3() {
        return ing3;
    }

    public void setIng3(String ing3) {
        this.ing3 = ing3;
    }

    public void generateName(){
        if(ing1.equals("ginseng") && ing2.equals("ginseng") && ing3.equals("ginseng") ||
                ing1.equals("ginseng") && ing2.equals("ginseng") && ing3.equals("none") ||
                ing1.equals("ginseng") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Eternal Youth Potion";
        }
        else if(ing1.equals("cinnamon") && ing2.equals("cinnamon") && ing3.equals("cinnamon") ||
                ing1.equals("cinnamon") && ing2.equals("cinnamon") && ing3.equals("none") ||
                ing1.equals("cinnamon") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Cleansing Potion";
        }
        else if(ing1.equals("turmeric") && ing2.equals("turmeric") && ing3.equals("turmeric") ||
                ing1.equals("turmeric") && ing2.equals("turmeric") && ing3.equals("none") ||
                ing1.equals("turmeric") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Revival Potion";
        }
        else if(ing1.equals("sliced ginseng") && ing2.equals("sliced ginseng") && ing3.equals("sliced ginseng") ||
                ing1.equals("sliced ginseng") && ing2.equals("sliced ginseng") && ing3.equals("none") ||
                ing1.equals("sliced ginseng") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Aging Potion";
        }
        else if(ing1.equals("sliced cinnamon") && ing2.equals("sliced cinnamon") && ing3.equals("sliced cinnamon") ||
                ing1.equals("sliced cinnamon") && ing2.equals("sliced cinnamon") && ing3.equals("none") ||
                ing1.equals("sliced cinnamon") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Poisonous Potion";
        }
        else if(ing1.equals("sliced turmeric") && ing2.equals("sliced turmeric") && ing3.equals("sliced turmeric") ||
                ing1.equals("sliced turmeric") && ing2.equals("sliced turmeric") && ing3.equals("none") ||
                ing1.equals("sliced turmeric") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Lethal Potion";
        }
        else if(ing1.equals("crushed ginseng") && ing2.equals("crushed ginseng") && ing3.equals("crushed ginseng") ||
                ing1.equals("crushed ginseng") && ing2.equals("crushed ginseng") && ing3.equals("none") ||
                ing1.equals("crushed ginseng") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "De-aging Potion";
        }
        else if(ing1.equals("crushed cinnamon") && ing2.equals("crushed cinnamon") && ing3.equals("crushed cinnamon") ||
                ing1.equals("crushed cinnamon") && ing2.equals("crushed cinnamon") && ing3.equals("none") ||
                ing1.equals("crushed cinnamon") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Antidote Potion";
        }
        else if(ing1.equals("crushed turmeric") && ing2.equals("crushed turmeric") && ing3.equals("crushed turmeric") ||
                ing1.equals("crushed turmeric") && ing2.equals("crushed turmeric") && ing3.equals("none") ||
                ing1.equals("crushed turmeric") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Luck Potion";
        }
        else if(ing1.equals("mashed ginseng") && ing2.equals("mashed ginseng") && ing3.equals("mashed ginseng") ||
                ing1.equals("mashed ginseng") && ing2.equals("mashed ginseng") && ing3.equals("none") ||
                ing1.equals("mashed ginseng") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Truth Potion";
        }
        else if(ing1.equals("mashed cinnamon") && ing2.equals("mashed cinnamon") && ing3.equals("mashed cinnamon") ||
                ing1.equals("mashed cinnamon") && ing2.equals("mashed cinnamon") && ing3.equals("none") ||
                ing1.equals("mashed cinnamon") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Love Potion";
        }
        else if(ing1.equals("mashed turmeric") && ing2.equals("mashed turmeric") && ing3.equals("mashed turmeric") ||
                ing1.equals("mashed turmeric") && ing2.equals("mashed turmeric") && ing3.equals("none") ||
                ing1.equals("mashed turmeric") && ing2.equals("none") && ing3.equals("none") ){
            this.name = "Memory Potion";
        }
        else if(ing1.equals("ginseng")){
            this.name = "Speed Potion";
        }
        else if(ing1.equals("cinnamon")){
            this.name = "Health Potion";
        }
        else if(ing1.equals("turmeric")){
            this.name = "Magic Potion";
        }
        else if(ing1.equals("sliced ginseng")){
            this.name = "Rage Potion";
        }
        else if(ing1.equals("sliced cinnamon")){
            this.name = "Insanity Potion";
        }
        else if(ing1.equals("sliced turmeric")){
            this.name = "Explosive Potion";
        }
        else if(ing1.equals("crushed ginseng")){
            this.name = "Nirvana Potion";
        }
        else if(ing1.equals("crushed cinnamon")){
            this.name = "Zen Potion";
        }
        else if(ing1.equals("crushed turmeric")){
            this.name = "Samsara Potion";
        }
        else if(ing1.equals("mashed ginseng")){
            this.name = "Night Vision Potion";
        }
        else if(ing1.equals("mashed cinnamon")){
            this.name = "Water Breathing Potion";
        }
        else if(ing1.equals("mashed turmeric")){
            this.name = "Invisibility Potion";
        }
        else{
            this.name = "Unknown Potion";
        }
    }
}
