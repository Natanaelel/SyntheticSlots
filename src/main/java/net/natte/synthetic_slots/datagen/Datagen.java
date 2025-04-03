package net.natte.synthetic_slots.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.natte.synthetic_slots.Implant;
import net.natte.synthetic_slots.Implants;
import net.natte.synthetic_slots.SyntheticSlots;

public class Datagen {

    public static void registerDataGen(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput pack = generator.getPackOutput();

        generator.addProvider(true, getLangProvider(pack));
        generator.addProvider(true, getModelProvider(pack, event.getExistingFileHelper()));
    }

    private static LanguageProvider getLangProvider(PackOutput pack) {
        return new LanguageProvider(pack, SyntheticSlots.MOD_ID, "en_us") {
            @Override
            protected void addTranslations() {
                for(Implant implant : Implants.IMPLANTS){
                    add(implant.getItem(), implant.name);
                }
            }
        };
    }

    private static ItemModelProvider getModelProvider(PackOutput pack, ExistingFileHelper existingFileHelper){
        return new ItemModelProvider(pack, SyntheticSlots.MOD_ID, existingFileHelper) {
            @Override
            protected void registerModels() {
                for(Implant implant : Implants.IMPLANTS){
                    basicItem(implant.getItem());
                }
            }
        };
    }
}
