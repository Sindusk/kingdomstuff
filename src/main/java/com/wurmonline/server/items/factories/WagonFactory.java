package com.wurmonline.server.items.factories;

import java.util.ArrayList;

import org.gotti.wurmunlimited.mods.kingdomstuff.KingdomStuff;

import com.wurmonline.server.item.KingdomWagon;

/**
 * Creates all variants of wagons
 */
public class WagonFactory {
    public static ArrayList<Integer> wagonList = new ArrayList<>();

    public static void addAllWagons() {
        for (int i=0; i < Constants.WAGON_LIST.length; i++) {
            int id= KingdomWagon.addWagon(Constants.WAGON_LIST[i],Constants.NAMES[i]);
            if (id!=0) {
                wagonList.add(id);
            } else {
                KingdomStuff.debug(Constants.NAMES[i] + " wagon - cant' be created, id is 0");
            }
        }

    }
}
