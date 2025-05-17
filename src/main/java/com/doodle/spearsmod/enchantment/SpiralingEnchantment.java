package com.doodle.spearsmod.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class SpiralingEnchantment extends Enchantment {
    public SpiralingEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(rarity, EnchantmentTarget.TRIDENT, slotTypes);
    }

    public boolean canAccept(Enchantment sharplike, Enchantment spiraling) {
        return !(sharplike instanceof DamageEnchantment && spiraling instanceof SpiralingEnchantment);
    }

    public int getMinPower(int level) {
        return 1 + level * 10;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 5;
    }

    public int getMaxLevel() {
        return 5;
    }


}
