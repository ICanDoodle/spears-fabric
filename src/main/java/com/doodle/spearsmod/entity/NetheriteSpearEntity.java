package com.doodle.spearsmod.entity;

import com.doodle.spearsmod.init.modenchantments;
import com.doodle.spearsmod.init.modentities;
import com.doodle.spearsmod.init.moditems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NetheriteSpearEntity extends SpearEntity {
    private static final TrackedData<Byte> LOYALTY;
    private static final TrackedData<Boolean> ENCHANTED;
    private ItemStack spearStack;

    private static ItemStack DEFAULT_STACK;
    private boolean dealtDamage;
    public int returnTimer;

    public NetheriteSpearEntity(EntityType<NetheriteSpearEntity> type, World world) {
        super(type, world);
        this.spearStack = new ItemStack(moditems.NETHERITE_SPEAR);
    }

    public NetheriteSpearEntity(EntityType<? extends SpearEntity> type, World world, LivingEntity owner, @NotNull ItemStack stack) {
        super(type, world, owner, stack);
        this.spearStack = new ItemStack(moditems.NETHERITE_SPEAR);
        this.spearStack = stack.copy();
        this.dataTracker.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(stack));
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
    }


    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LOYALTY, (byte)0);
        this.dataTracker.startTracking(ENCHANTED, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        int i = (Byte)this.dataTracker.get(LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoClip()) && entity != null) {
            if (!this.isOwnerAlive()) {
                if (!this.getWorld().isClient && this.pickupType == PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoClip(true);
                Vec3d vec3d = entity.getEyePos().subtract(this.getPos());
                this.setPos(this.getX(), this.getY() + vec3d.y * 0.015 * (double)i, this.getZ());
                if (this.getWorld().isClient) {
                    this.lastRenderY = this.getY();
                }

                double d = 0.05 * (double)i;
                this.setVelocity(this.getVelocity().multiply(0.95).add(vec3d.normalize().multiply(d)));
                if (this.returnTimer == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.returnTimer;
            }
        }

        super.tick();
    }

    private boolean isOwnerAlive() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack asItemStack() {
        return this.spearStack.copy();
    }

    public boolean isEnchanted() {
        return (Boolean)this.dataTracker.get(ENCHANTED);
    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return this.dealtDamage ? null : super.getEntityCollision(currentPosition, nextPosition);
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 14.0F;
        if (entity instanceof LivingEntity livingEntity) {
            f += EnchantmentHelper.getAttackDamage(this.spearStack, livingEntity.getGroup());
            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, this.spearStack) > 0 ) {
                f += 2.0D;
            }
            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, this.spearStack) > 1 ) {
                f += 2.0D;
            }
            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, this.spearStack) > 2 ) {
                f += 2.0D;
            }
            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, this.spearStack) > 3 ) {
                f += 2.0D;
            }
            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, this.spearStack) > 4 ) {
                f += 2.0D;
            }
        }
        if (EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.spearStack) > 0) {
            entity.setOnFireFor(4);
        } else if (EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, this.spearStack) > 1) {
            entity.setOnFireFor(8);
        }

        Entity entity2 = this.getOwner();
        DamageSource damageSource = this.getDamageSources().trident(this, (Entity)(entity2 == null ? this : entity2));
        if (entity instanceof PlayerEntity) {
            if (((PlayerEntity) entity).isBlocking()) {
                ((PlayerEntity) entity).disableShield(false);
                this.dealtDamage = false;
            }
        }
        else {
            this.dealtDamage = true;
        }
        SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity)entity;
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
                }

                this.onHit(livingEntity2);
            }
        }

        this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
        float g = 1.0F;


        this.playSound(soundEvent, g, 1.0F);
    }


    protected boolean tryPickup(PlayerEntity player) {
        return super.tryPickup(player) || this.isNoClip() && this.isOwner(player) && player.getInventory().insertStack(this.asItemStack());
    }

    protected SoundEvent getHitSound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    public void onPlayerCollision(PlayerEntity player) {
        if (this.isOwner(player) || this.getOwner() == null) {
            super.onPlayerCollision(player);
        }

    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Netherite Spear", 10)) {
            this.spearStack = ItemStack.fromNbt(nbt.getCompound("Netherite Spear"));
        }

        this.dealtDamage = nbt.getBoolean("DealtDamage");
        this.dataTracker.set(LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.spearStack));
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("Netherite Spear", this.spearStack.writeNbt(new NbtCompound()));
        nbt.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void age() {
        int i = (Byte)this.dataTracker.get(LOYALTY);
        if (this.pickupType != PickupPermission.ALLOWED || i <= 0) {
            super.age();
        }

    }


    protected float getDragInWater() {
        return 0.99F;
    }

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }

    static {
        LOYALTY = DataTracker.registerData(NetheriteSpearEntity.class, TrackedDataHandlerRegistry.BYTE);
        ENCHANTED = DataTracker.registerData(NetheriteSpearEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        DEFAULT_STACK = new ItemStack(moditems.NETHERITE_SPEAR);
    }
}
