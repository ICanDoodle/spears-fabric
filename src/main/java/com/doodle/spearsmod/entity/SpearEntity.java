package com.doodle.spearsmod.entity;

import com.doodle.spearsmod.init.modentities;
import com.doodle.spearsmod.init.moditems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class SpearEntity extends PersistentProjectileEntity {
    private static final TrackedData<Byte> LOYALTY;
    private static final TrackedData<Boolean> ENCHANTED;

    private static final ItemStack DEFAULT_STACK;

    private boolean dealtDamage;
    public int returnTimer;



    public SpearEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world, DEFAULT_STACK);
    }

    public SpearEntity(EntityType<? extends PersistentProjectileEntity> type, World world, LivingEntity owner, ItemStack stack) {
        super(type, owner, world, stack);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        if (EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.DEFAULT_STACK) > 0) {
            entity.setOnFireFor(4);
        } else if (EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.DEFAULT_STACK) > 1) {
            entity.setOnFireFor(8);
        }
    }


    public boolean isEnchanted() {
        return (Boolean)this.dataTracker.get(ENCHANTED);
    }

    public void applyEnchantmentEffects(LivingEntity entity, float p_36747_) {
        if (EnchantmentHelper.getEquipmentLevel(Enchantments.FIRE_ASPECT, entity) > 0) {
            this.setOnFireFor(80);
        }
    }

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    static {
        LOYALTY = DataTracker.registerData(SpearEntity.class, TrackedDataHandlerRegistry.BYTE);
        ENCHANTED = DataTracker.registerData(SpearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        DEFAULT_STACK = new ItemStack(moditems.WOODEN_SPEAR);
    }
}

