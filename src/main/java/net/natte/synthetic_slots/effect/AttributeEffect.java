package net.natte.synthetic_slots.effect;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.UUIDUtil;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;
import java.util.function.Supplier;

public class AttributeEffect implements ImplantEffect {
    private final Modifier[] modifiers;

    public AttributeEffect(Modifier... modifiers) {
        this.modifiers = modifiers;
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        HashMultimap<Attribute, AttributeModifier> attributeModifiers = HashMultimap.create();

//        if (modifiers.length == 1) {
//            Modifier modifier = modifiers[0];
//            attributeModifiers.put(modifier.attribute().get(), new AttributeModifier(uuid, modifier.name(), modifier.value(), modifier.operation()));
//            return attributeModifiers;
//        }
        for (int i = 0; i < modifiers.length; i++) {
            Modifier modifier = modifiers[i];
            UUID uuuid = UUID.nameUUIDFromBytes((slotContext.identifier() + slotContext.index() + modifier.name() + i).getBytes());

            attributeModifiers.put(modifier.attribute().get(), new AttributeModifier(uuuid, modifier.name(), modifier.value(), modifier.operation()));
        }
        return attributeModifiers;
    }
}
