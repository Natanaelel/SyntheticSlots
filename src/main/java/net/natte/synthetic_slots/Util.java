package net.natte.synthetic_slots;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;

public class Util {
    public static boolean hasImplant(Player player, Implant implant) {
        LazyOptional<ICuriosItemHandler> curiosInventory = CuriosApi.getCuriosInventory(player);
        if (!curiosInventory.isPresent())
            return false;

        return curiosInventory.orElse(null).findFirstCurio(implant.getItem()).isPresent();
    }
}
