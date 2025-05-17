package com.doodle.spearsmod.init;

import com.doodle.spearsmod.SimpleSpears;
import com.doodle.spearsmod.init.moditems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class moditemgroups {
public static final ItemGroup SPEAR_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(SimpleSpears.MOD_ID,"spear"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.spear"))
                .icon(() -> new ItemStack(moditems.NETHERITE_SPEAR)).entries((displayContext, entries) -> {
                    entries.add(moditems.WOODEN_SPEAR);
                    entries.add(moditems.STONE_SPEAR);
                    entries.add(moditems.IRON_SPEAR);
                    entries.add(moditems.GOLDEN_SPEAR);
                    entries.add(moditems.DIAMOND_SPEAR);
                    entries.add(moditems.NETHERITE_SPEAR);
                }).build());

public static void registerModItemGroups(){
        SimpleSpears.LOGGER.info("Registering Item Groups for" + SimpleSpears.MOD_ID);
    }

}
