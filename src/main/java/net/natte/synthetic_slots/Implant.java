package net.natte.synthetic_slots;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Implant {
    public final String id;
    public final String name;
    public final String desc1;
    public final String desc2;

    private RegistryObject<Item> item;

    public Implant(String id, String name, String desc1, String desc2) {
        this.id = id;
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;

    }

    public void register(DeferredRegister<Item> items){
        this.item = items.register(this.id, () -> new Item(new Item.Properties()));
    }

    public Item getItem(){
        return this.item.get();
    }
}
