package com.mobdeve.s18.terrado.rinzai.potion_maker;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.terrado.rinzai.potion_maker.dao.PotionModel;

public class LinearViewHolder extends RecyclerView.ViewHolder {
    private final TextView potionNameTv;
    private final ImageView potionIv;

    public LinearViewHolder(View itemView) {
        super(itemView);

        this.potionNameTv = itemView.findViewById(R.id.potionNameTv);
        this.potionIv = itemView.findViewById(R.id.potionIv);
    }

    public void bindData(PotionModel potion) {
        String ingr2 = potion.getIng2();
        String ingr3 = potion.getIng3();

        this.potionNameTv.setText(potion.getName());

        if(ingr2.equals("none") && ingr3.equals("none")) {
            this.potionIv.setImageResource(R.drawable.abottle);
        }
        else if(ingr3.equals("none")){
            this.potionIv.setImageResource(R.drawable.bbottle);
        }
        else{
            this.potionIv.setImageResource(R.drawable.cbottle);
        }
    }
}
