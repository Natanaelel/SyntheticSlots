package net.natte.synthetic_slots.client;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SyntheticSlotsClient {
    public static void initialize(FMLJavaModLoadingContext context) {
        IEventBus modBus = context.getModEventBus();

        MinecraftForge.EVENT_BUS.addListener(AttributeRenderer::render);

    }
}
