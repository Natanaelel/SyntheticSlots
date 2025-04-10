package net.natte.synthetic_slots;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.natte.synthetic_slots.effect.ImplantEffect;
import net.natte.synthetic_slots.item.ImplantCategory;
import net.natte.synthetic_slots.item.ImplantItem;

public class Implant {
    public final String id;
    public final String name;
    public final String desc1;
    public final String desc2;
    public final ImplantCategory implantCategory;
    public final ImplantEffect effect;

    private RegistryObject<Item> item;

    public Implant(String id, String name, String desc1, String desc2, ImplantCategory implantCategory, ImplantEffect effect) {
        this.id = id;
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.implantCategory = implantCategory;
        this.effect = effect;
    }

    public void register(DeferredRegister<Item> items){
        this.item = items.register(this.id, () -> new ImplantItem(new Item.Properties().stacksTo(1), this));
    }

    public Item getItem(){
        return this.item.get();
    }


}
