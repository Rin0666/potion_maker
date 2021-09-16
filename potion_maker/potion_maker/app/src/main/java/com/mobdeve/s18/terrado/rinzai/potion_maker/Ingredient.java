package com.mobdeve.s18.terrado.rinzai.potion_maker;

public class Ingredient {

    private String name;
    private boolean isCrushed = false;
    private boolean isSliced = false;
    private boolean isMashed = false;
    public Ingredient(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        if(isCrushed)
            return "crushed "+name;
        if(isSliced)
            return "sliced "+name;
        if(isMashed)
            return "mashed "+name;

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCrushed() {
        return isCrushed;
    }

    public void setCrushed(boolean crushed) {
        isCrushed = crushed;
    }

    public boolean isSliced() {
        return isSliced;
    }

    public void setSliced(boolean sliced) {
        isSliced = sliced;
    }

    public boolean isMashed() {
        return isMashed;
    }

    public void setMashed(boolean mashed) {
        isMashed = mashed;
    }
}
