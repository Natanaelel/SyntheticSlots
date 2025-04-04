package net.natte.synthetic_slots.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.List;

public class ItemTags {
    public static final TagKey<Item> CURIOS_CURIO = tag("curios:curio");
    public static final TagKey<Item> CURIOS_HEAD = tag("curios:head");
    public static final TagKey<Item> CURIOS_ARMS = tag("curios:arms");
    public static final TagKey<Item> CURIOS_HANDS = tag("curios:hands");

    public static final List<TagKey<Item>> TAG_KEYS = List.of(CURIOS_CURIO, CURIOS_HEAD, CURIOS_ARMS, CURIOS_HANDS);

    private static TagKey<Item> tag(String key) {
        return TagKey.create(Registries.ITEM, ResourceLocation.parse(key));
    }
}