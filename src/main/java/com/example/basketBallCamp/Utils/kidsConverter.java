package com.example.basketBallCamp.Utils;

import com.example.basketBallCamp.Entity.kids;
import com.example.basketBallCamp.Model.kidsModel;

public class kidsConverter {

    public static kidsModel convertKidTokidsModel(kids kid) {
        kidsModel kidsModel = new kidsModel();
        kidsModel.setKidId(kidsModel.getKidId());
        kidsModel.setKidName(kidsModel.getKidName());
        kidsModel.setKidAge(kidsModel.getKidAge());
        kidsModel.setKidAddress(kidsModel.getKidAddress());
        kidsModel.setKidEmail(kidsModel.getKidEmail());
        return kidsModel;
    }
}
