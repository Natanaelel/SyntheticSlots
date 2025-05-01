package net.natte.synthetic_slots.effect;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.function.Supplier;

public record Modifier(String name, Supplier<Attribute> attribute, double value, AttributeModifier.Operation operation) {
    public Modifier(String name, Attribute attribute, double value, AttributeModifier.Operation operation) {
        this(name, () -> attribute, value, operation);
    }
}
