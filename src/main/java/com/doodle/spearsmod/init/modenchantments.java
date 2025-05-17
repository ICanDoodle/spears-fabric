package com.doodle.spearsmod.init;

import com.doodle.spearsmod.SimpleSpears;
import com.doodle.spearsmod.enchantment.SpiralingEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modenchantments {

    public static Enchantment SPIRALING = registerEnchantment("spiraling",
            new SpiralingEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.TRIDENT, EquipmentSlot.MAINHAND));

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(SimpleSpears.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        SimpleSpears.LOGGER.info("Registering Enchantments for" + SimpleSpears.MOD_ID);
    }

}
