package com.wurmonline.server.item;

import java.io.IOException;

import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.mods.kingdomstuff.KingdomStuff;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviours;

import com.wurmonline.server.items.AdvancedCreationEntry;
import com.wurmonline.server.items.CreationCategories;
import com.wurmonline.server.items.CreationEntryCreator;
import com.wurmonline.server.items.CreationRequirement;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.factories.Constants;

/**
 * Base for all wagons
 */
public class KingdomWagon implements ItemTypes, Initable {

    public static int addWagon(String model, String name) {
        KingdomStuff.debug("Initing KingdomWagon " + model);
        try {
            ModVehicleBehaviours.init();
            return createItem(model, name);
        } catch (Exception e) {
            KingdomStuff.debug("Initiatiation of wagon failed: " + e.toString());
        }
        return 0;
    }


    private static int createItem(String model, String name) throws IOException {
        KingdomStuff.debug("id :  org.takino.wagon." + name);
        ItemTemplateBuilder builder = new ItemTemplateBuilder("org.takino.wagon." + name);
        builder.name(name + " wagon", name + " wagons", "A fairly large wagon designed to be dragged by four animals. " +
                "This design is used by "+ name + " kingdom.");
        builder.descriptions("almost full", "somewhat occupied", "half-full", "emptyish");
        builder.itemTypes(new short[] {
                ITEM_TYPE_NAMED,
                ITEM_TYPE_HOLLOW,
                ITEM_TYPE_NOTAKE,
                ITEM_TYPE_WOOD,
                ITEM_TYPE_TURNABLE,
                ITEM_TYPE_DECORATION,
                ITEM_TYPE_REPAIRABLE,
                ITEM_TYPE_VEHICLE,
                ITEM_TYPE_CART,
                ITEM_TYPE_VEHICLE_DRAGGED,
                ITEM_TYPE_LOCKABLE,
                ITEM_TYPE_HASDATA,
                ITEM_TYPE_TRANSPORTABLE,
                ITEM_TYPE_USES_SPECIFIED_CONTAINER_VOLUME,
                ITEM_TYPE_NOWORKPARENT,
                ITEM_TYPE_NORENAME
        });
        builder.imageNumber((short)60);
        builder.behaviourType((short)41);
        builder.combatDamage(0);
        builder.decayTime(9072000L);
        builder.dimensions(550,300,410);
        builder.primarySkill(-10);
        builder.modelName(model + ".");
        //builder.size(3);

        builder.difficulty(80.0F);
        builder.weightGrams(240000);
        builder.material(Constants.BIRCHWOOD);
        builder.value(50000); //?? same thing is set for wagon in CreationEntryCreator..
        builder.isTraded(false);
        builder.armourType(-1);

        ItemTemplate resultTemplate = builder.build();
        resultTemplate.setContainerSize(200, 260, 400);

        KingdomStuff.debug(name + "; Template ID: " + resultTemplate.getTemplateId() + "; vehicle? " + resultTemplate.isVehicle());
        createCreationEntry(resultTemplate);

        //KingdomWagonBehaviour kingdomWagonBehaviour = new KingdomWagonBehaviour();
        //ModVehicleBehaviours.addItemVehicle(resultTemplate.getTemplateId(), kingdomWagonBehaviour);

        return resultTemplate.getTemplateId();
    }


    private static void createCreationEntry(ItemTemplate newWwagon) {

        AdvancedCreationEntry wagon = CreationEntryCreator.createAdvancedEntry(10044, 22, 191, newWwagon.getTemplateId(),
                false, false, 0.0F, true, true, 0, 50.0D, CreationCategories.CARTS);

        wagon.addRequirement(new CreationRequirement(1, 191, 1, true));
        wagon.addRequirement(new CreationRequirement(2, 22, 20, true));
        wagon.addRequirement(new CreationRequirement(3, 23, 4, true));
        wagon.addRequirement(new CreationRequirement(4, 218, 10, true));
        wagon.addRequirement(new CreationRequirement(5, 632, 2, true));
        wagon.addRequirement(new CreationRequirement(6, 486, 2, true));
    }


	@Override
	public void init() {
        ModVehicleBehaviours.init();
	}
}
