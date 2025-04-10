package net.natte.synthetic_slots.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.natte.synthetic_slots.Implant;
import net.natte.synthetic_slots.Implants;
import net.natte.synthetic_slots.SyntheticSlots;
import net.natte.synthetic_slots.tags.ItemTags;

public class Datagen {

    public static void registerDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput pack = generator.getPackOutput();

        generator.addProvider(true, getLangProvider(pack));
        generator.addProvider(true, getModelProvider(pack, event.getExistingFileHelper()));
        generator.addProvider(true, getItemTagProvider(event));
    }

    private static LanguageProvider getLangProvider(PackOutput pack) {
        return new LanguageProvider(pack, SyntheticSlots.MOD_ID, "en_us") {
            @Override
            protected void addTranslations() {
                for (Implant implant : Implants.IMPLANTS) {
                    add(implant.getItem(), implant.name);
                }

                add("curios.identifier.arms", "Arm");
                add("curios.identifier.legs", "Leg");
            }
        };
    }

    private static ItemModelProvider getModelProvider(PackOutput pack, ExistingFileHelper existingFileHelper) {
        return new ItemModelProvider(pack, SyntheticSlots.MOD_ID, existingFileHelper) {
            @Override
            protected void registerModels() {
                for (Implant implant : Implants.IMPLANTS) {
                    basicItem(implant.getItem());
                }
            }
        };
    }

    private static IntrinsicHolderTagsProvider<Item> getItemTagProvider(GatherDataEvent event) {
        return new IntrinsicHolderTagsProvider<Item>(event.getGenerator().getPackOutput(), Registries.ITEM, event.getLookupProvider(), item -> item.builtInRegistryHolder().key(), SyntheticSlots.MOD_ID, event.getExistingFileHelper()) {
            @Override
            protected void addTags(HolderLookup.Provider provider) {
                for (TagKey<Item> tagKey : ItemTags.TAG_KEYS) {

                    IntrinsicTagAppender<Item> itemTag = tag(tagKey);
                    for (Implant implant : Implants.IMPLANTS) {
                        if (implant.implantCategory.goesInSlot(tagKey))
                            itemTag.add(implant.getItem());
                    }

                }
            }
        };
    }


}
