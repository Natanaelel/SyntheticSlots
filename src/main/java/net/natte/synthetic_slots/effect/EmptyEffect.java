package net.natte.synthetic_slots.effect;

import net.minecraft.network.chat.Component;

public class EmptyEffect implements ImplantEffect {
    private final Component description;

    public EmptyEffect(String descriptionPath) {
        this.description = Component.translatable("synthetic_slots.effect_description." + descriptionPath);
    }

    public Component getDescription() {
        return description;
    }
}
