package com.mobdeve.s18.terrado.rinzai.potion_maker;

public class Ingredient {

    private String name="";
    private boolean isCrushed = false;
    private boolean isSliced = false;
    public Ingredient(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    public void setCrushed(Boolean isCrushed){
        this.isCrushed = isCrushed;
    }
    public void setSliced(Boolean isSliced){
        this.isSliced = isSliced;
    }
}
