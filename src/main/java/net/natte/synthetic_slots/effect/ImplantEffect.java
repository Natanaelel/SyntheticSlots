package net.natte.synthetic_slots.effect;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public interface ImplantEffect {

    default void onEquip(Player player) {
    }

    default void onUnequip(Player player) {
    }

    default void tick(Player player) {
    }

    default Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
        return HashMultimap.create();
    }
}
