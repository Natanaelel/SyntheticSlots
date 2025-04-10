package net.natte.synthetic_slots.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public enum ImplantCategory {
    EYE("head"),
    BRAIN("head"),
//    GENERAL,
//    SKELETON,
    ARM("arms"),
    HAND("hands"),
//    SPINE,
//    EAR,
    LEG("legs"),
    //    HEAD,
//    MUSCLE,
//    IMMUNE_SYSTEM,
//    NERVOUS_SYSTEM,
//    COMPUTER,
//    ENERGY,
//    HEALTH,
//    LUNGS,
//    BODY,
//    BACK,
    IDK("curio");

    private final String[] slots;


    ImplantCategory(String... slots) {
        this.slots = slots;
    }

    public boolean goesInSlot(TagKey<Item> tag) {
        String path = tag.location().getPath();
        for (String slot : this.slots) {
            if (slot.equals(path)) {
                return true;
            }
        }
        return false;
    }
}
