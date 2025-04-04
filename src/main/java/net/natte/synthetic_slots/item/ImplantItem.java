package net.natte.synthetic_slots.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.natte.synthetic_slots.Implant;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ImplantItem extends Item {
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
}
