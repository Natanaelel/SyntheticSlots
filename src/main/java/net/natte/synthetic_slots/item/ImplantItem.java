package net.natte.synthetic_slots.item;

import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLLoader;
import net.natte.synthetic_slots.Implant;
import net.natte.synthetic_slots.effect.EmptyEffect;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosTooltip;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ImplantItem extends Item implements ICurioItem {
    public final Implant implant;

    public ImplantItem(Properties properties, Implant implant) {
        super(properties);
        this.implant = implant;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {

        tooltip.add(Component.literal(implant.desc1).withStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltip.add(Component.literal(implant.desc2).withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)));

        super.appendHoverText(stack, level, tooltip, tooltipFlag);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        if (slotContext.entity() instanceof Player player)
            this.implant.effect.onEquip(player);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if (slotContext.entity() instanceof Player player)
            this.implant.effect.onUnequip(player);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player)
            this.implant.effect.tick(player);

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        return this.implant.effect.getAttributeModifiers(slotContext, uuid, stack);
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, ItemStack stack) {
        if (this.implant.effect instanceof EmptyEffect emptyEffect) {

            Set<String> curioTags = CuriosApi.getItemStackSlots(stack, FMLLoader.getDist() == Dist.CLIENT).keySet();
            if (curioTags.contains("curio"))
                curioTags = Set.of("curio");

            CuriosTooltip curiosTooltip = new CuriosTooltip();
            curiosTooltip.forSlots(new ArrayList<>(curioTags).toArray(new String[0]));
            curiosTooltip.appendAdditive(emptyEffect.getDescription().copy());
            return curiosTooltip.build();
        }
        return ICurioItem.super.getAttributesTooltip(tooltips, stack);
    }
}
