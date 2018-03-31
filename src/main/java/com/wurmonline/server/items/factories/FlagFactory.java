package com.wurmonline.server.items.factories;

import java.util.ArrayList;

import org.gotti.wurmunlimited.mods.kingdomstuff.KingdomStuff;

import com.wurmonline.server.item.KingdomFlag;

/**
 * Creates every flag.
 */
public class FlagFactory {
    public static ArrayList<Integer> flagList = new ArrayList<>();

    public static void addAllFlags() {
        for (int i=0; i < Constants.FLAG_LIST.length; i++) {
            int id= KingdomFlag.addFlag(Constants.FLAG_LIST[i],Constants.NAMES[i]);
            if (id!=0) {
                flagList.add(id);
            } else {
                KingdomStuff.debug(Constants.NAMES[i] + " flag - cant' be created, id is 0");
            }
        }

    }
}
