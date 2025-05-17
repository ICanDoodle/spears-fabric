package com.doodle.spearsmod.mixin;

import com.doodle.spearsmod.init.moditems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.LoyaltyEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LoyaltyEnchantment.class)
public abstract class EnchantmentTargetMixin extends Enchantment {


    protected EnchantmentTargetMixin(Rarity rarity, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(rarity, target, slotTypes);
    }
@Override
public boolean isAcceptableItem(ItemStack stack) {
    return stack.isOf(moditems.WOODEN_SPEAR) || super.isAcceptableItem(stack)
            || stack.isOf(moditems.STONE_SPEAR) || super.isAcceptableItem(stack)
            || stack.isOf(moditems.IRON_SPEAR) || super.isAcceptableItem(stack)
            || stack.isOf(moditems.GOLDEN_SPEAR) || super.isAcceptableItem(stack)
            || stack.isOf(moditems.DIAMOND_SPEAR) || super.isAcceptableItem(stack)
            || stack.isOf(moditems.NETHERITE_SPEAR) || super.isAcceptableItem(stack);
}
}
