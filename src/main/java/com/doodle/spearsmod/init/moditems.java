package com.doodle.spearsmod.init;

import com.doodle.spearsmod.SimpleSpears;
import com.doodle.spearsmod.item.*;
import it.unimi.dsi.fastutil.objects.ReferenceOpenHashSet;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Set;

public class moditems {
    public static final Set<SpearItem> SPEAR_ITEMS = new ReferenceOpenHashSet<>();
    public static final Item WOODEN_SPEAR = registerSpear("wooden_spear",new WoodenSpearItem(ToolMaterials.WOOD, 2, -3.2F, new Item.Settings().maxCount(1).maxDamage(15)));
    public static final Item STONE_SPEAR = registerSpear("stone_spear",new StoneSpearItem(ToolMaterials.STONE, 3, -3.2F, new Item.Settings().maxCount(1).maxDamage(33)));
    public static final Item IRON_SPEAR = registerSpear("iron_spear",new IronSpearItem(ToolMaterials.IRON, 4, -3.2F, new Item.Settings().maxCount(1).maxDamage(63)));
    public static final Item GOLDEN_SPEAR = registerSpear("golden_spear",new GoldenSpearItem(ToolMaterials.GOLD, 2, -3.2F, new Item.Settings().maxCount(1).maxDamage(8)));
    public static final Item DIAMOND_SPEAR = registerSpear("diamond_spear",new DiamondSpearItem(ToolMaterials.DIAMOND, 5, -3.2F, new Item.Settings().maxCount(1).maxDamage(390)));
    public static final Item NETHERITE_SPEAR = registerSpear("netherite_spear",new NetheriteSpearItem(ToolMaterials.NETHERITE, 6, -3.2F, new Item.Settings().maxCount(1).maxDamage(508)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(SimpleSpears.MOD_ID, name), item);
    }

    public static SpearItem registerSpear(String name, SpearItem item) {
       return Registry.register(Registries.ITEM, new Identifier(SimpleSpears.MOD_ID, name), item);
    }


    public static void registerModItems() {
        SimpleSpears.LOGGER.info("Registering Mod Items for" + SimpleSpears.MOD_ID);
    }
}
