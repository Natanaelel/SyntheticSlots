package net.natte.synthetic_slots.client;

import joptsimple.internal.Strings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttributeRenderer {
    private static final Minecraft minecraft = Minecraft.getInstance();

    public static void render(RenderGuiEvent.Post event) {
        GuiGraphics gui = event.getGuiGraphics();
        LocalPlayer player = minecraft.player;
        AttributeMap attributes = player.getAttributes();

        int i = 0;
        for (Attribute attribute : ForgeRegistries.ATTRIBUTES) {
            if (!attributes.hasAttribute(attribute))
                continue;

            AttributeInstance instance = attributes.getInstance(attribute);
            List<String> strings = new ArrayList<>();
            strings.add("Base: " + (float)((int)(instance.getBaseValue()*10000))/10000);
            for (AttributeModifier modifier : instance.getModifiers()) {
                float value = (float)((int)(modifier.getAmount()*10000))/10000;
                strings.add(modifier.getName() + ": " + (modifier.getOperation() == AttributeModifier.Operation.ADDITION ? "+" : modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE ? "*" : "*=") + value);
            }
            String string = "";

            string += Strings.join(strings, ", ");
            string += " = " + (float)((int)(instance.getValue()*10000))/10000;

            gui.drawString(minecraft.font, Component.translatable(attribute.getDescriptionId()).getString() + ": " + string, 10, 10 + i * 20, 0xffffff, true);
            i++;
        }

        gui.drawString(minecraft.font, "Total XP: " + player.totalExperience, 300, 10, 0xffffff, true);
    }
}
