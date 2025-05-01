package net.natte.synthetic_slots;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.natte.synthetic_slots.client.SyntheticSlotsClient;
import net.natte.synthetic_slots.datagen.Datagen;
import org.slf4j.Logger;

@Mod(SyntheticSlots.MOD_ID)
public class SyntheticSlots {

    public static final String MOD_ID = "synthetic_slots";

    public static final Logger LOGGER = LogUtils.getLogger();

    public SyntheticSlots(FMLJavaModLoadingContext context) {

        LOGGER.info("starting...");

        IEventBus modBus = context.getModEventBus();

        Implants.register(modBus);

        modBus.addListener(Datagen::registerDataGen);
        Attributes.register(modBus);

        EventListeners.register(modBus);

        if (FMLEnvironment.dist.isClient())
            SyntheticSlotsClient.initialize(context);
    }
}
