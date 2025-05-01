package net.natte.synthetic_slots;

import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;

public class EventListeners {
    public static void register(IEventBus modBus) {
        MinecraftForge.EVENT_BUS.addListener(EventListeners::onExperienceDrop);
        MinecraftForge.EVENT_BUS.addListener(EventListeners::onTestMobEffectApplicability);
    }

    private static void onExperienceDrop(LivingExperienceDropEvent event) {

        Player player = event.getAttackingPlayer();
        if (player == null)
            return;

        AttributeInstance instance = player.getAttribute(Attributes.XP_BOOST.get());
        if (instance == null)
            return;

        event.setDroppedExperience(Mth.ceil(event.getDroppedExperience() * instance.getValue()));
    }

    private static void onTestMobEffectApplicability(MobEffectEvent.Applicable event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getEffectInstance().getEffect() == MobEffects.POISON && Util.hasImplant(player, Implants.AUGMENT_SHIELD))
                event.setResult(Event.Result.DENY);
        }
    }
}
