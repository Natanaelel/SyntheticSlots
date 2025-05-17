package net.natte.synthetic_slots.effect;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;

public class ImplantEffects {
    public static final ImplantEffect EMPTY = new ImplantEffect() {
    };

    public static final ImplantEffect SPEED = new AttributeEffect(
            new Modifier("Hyper-Speed", Attributes.MOVEMENT_SPEED, 0.3, AttributeModifier.Operation.MULTIPLY_BASE),
            new Modifier("HyperLeg-StepUp", ForgeMod.STEP_HEIGHT_ADDITION, 0.4, AttributeModifier.Operation.ADDITION)
    );
    public static final ImplantEffect SMALL_XP_BOOST = new AttributeEffect(
            new Modifier("Small-XP-Boost", net.natte.synthetic_slots.Attributes.XP_BOOST, 0.7, AttributeModifier.Operation.MULTIPLY_BASE)
    );
    public static final ImplantEffect LARGE_XP_BOOST = new AttributeEffect(
            new Modifier("Large-XP-Boost", net.natte.synthetic_slots.Attributes.XP_BOOST, 2, AttributeModifier.Operation.MULTIPLY_BASE)
    );
    public static ImplantEffect attackDamage(String name, double addition) {
        return new AttributeEffect(
                new Modifier(name, Attributes.ATTACK_DAMAGE, addition, AttributeModifier.Operation.ADDITION)
        );
    }

    // used for implants with no AttributeModifier(s), The effect is implemented some other way
    public static ImplantEffect description(String descriptionId) {
        return new EmptyEffect(descriptionId);
    }
}
