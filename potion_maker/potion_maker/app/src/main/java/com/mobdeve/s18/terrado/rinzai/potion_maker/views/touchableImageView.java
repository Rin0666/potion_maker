package com.mobdeve.s18.terrado.rinzai.potion_maker.views;

import android.content.Context;

class touchableImageView extends androidx.appcompat.widget.AppCompatImageView {

    public touchableImageView(Context context) {
        super(context);
    }
    @Override
    public boolean performClick() {
        return true;
    }
}
