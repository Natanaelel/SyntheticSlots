package net.natte.synthetic_slots;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class Implants {
    public static final List<Implant> IMPLANTS = new ArrayList<>();

    public static final Implant AUGMENT_BRAIN_CHIP = register(new Implant("augment_brain_chip", "Augment Brain Chip", "Increases cognitive functions.", "slight increase to xp gain"));

    private static Implant register(Implant implant) {
        IMPLANTS.add(implant);
        return implant;
    }

    public static void register(IEventBus modBus) {

        DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, SyntheticSlots.MOD_ID);
        for (Implant implant : IMPLANTS) {
            SyntheticSlots.LOGGER.info("registering implant " + implant.id);
            implant.register(items);
        }
        items.register(modBus);
    }
}
