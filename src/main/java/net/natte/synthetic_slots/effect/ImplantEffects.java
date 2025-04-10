package net.natte.synthetic_slots.effect;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ImplantEffects {
    public static final ImplantEffect EMPTY = new ImplantEffect() {
    };

    public static final ImplantEffect SPEED = new AttributeEffect("Hyper-Speed", Attributes.MOVEMENT_SPEED, 0.3, AttributeModifier.Operation.MULTIPLY_TOTAL);
}
