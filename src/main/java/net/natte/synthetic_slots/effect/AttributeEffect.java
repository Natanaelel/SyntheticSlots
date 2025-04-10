package net.natte.synthetic_slots.effect;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;

public class AttributeEffect implements ImplantEffect {
    private final AttributeModifier attributeModifier;
    private final Attribute attribute;

    public AttributeEffect(String name, Attribute attribute, double value, AttributeModifier.Operation operation) {
        this.attribute = attribute;
        this.attributeModifier = new AttributeModifier(name, value, operation);
    }

    @Override
    public void onEquip(Player player) {
        AttributeInstance attributeInstance = player.getAttribute(attribute);
        if (attributeInstance != null && !attributeInstance.hasModifier(attributeModifier))
            attributeInstance.addTransientModifier(attributeModifier);

    }

    @Override
    public void onUnequip(Player player) {
        AttributeInstance attributeInstance = player.getAttribute(attribute);
        if (attributeInstance != null)
            attributeInstance.removeModifier(attributeModifier);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers() {
        HashMultimap<Attribute, AttributeModifier> attributeModifiers = HashMultimap.create();
        attributeModifiers.put(attribute, attributeModifier);
        return attributeModifiers;
    }
}
