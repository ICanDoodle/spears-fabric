package com.doodle.spearsmod.item;

import com.doodle.spearsmod.entity.NetheriteSpearEntity;
import com.doodle.spearsmod.init.modenchantments;
import com.doodle.spearsmod.init.modentities;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class NetheriteSpearItem extends SpearItem {


    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    public NetheriteSpearItem(ToolMaterial mat, int attackDamage, float attackSpeed, Settings settings) {
        super(mat, attackDamage, attackSpeed, settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 6.0D, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -3.2F, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack) - remainingUseTicks;
            if (i >= 10) {
                int j = EnchantmentHelper.getRiptide(stack);
                if (j <= 0 || playerEntity.isTouchingWaterOrRain()) {
                    if (!world.isClient) {
                        stack.damage(1, playerEntity, (p) -> {
                            p.sendToolBreakStatus(user.getActiveHand());
                        });
                        if (j == 0) {
                            NetheriteSpearEntity spearEntity = new NetheriteSpearEntity(modentities.NETHERITE_SPEAR,world, playerEntity, stack);
                            spearEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
                            if (playerEntity.getAbilities().creativeMode) {
                                spearEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
                            }
                            int a = EnchantmentHelper.getLevel(Enchantments.FIRE_ASPECT, stack);
                            if (a > 0) {
                                spearEntity.setOnFireFor(100);
                            }
                            if (EnchantmentHelper.getLevel(modenchantments.SPIRALING, stack) > 0 ) {
                                spearEntity.setCritical(true);
                            }

                            world.spawnEntity(spearEntity);
                            world.playSoundFromEntity((PlayerEntity)null, spearEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
                            if (!playerEntity.getAbilities().creativeMode) {
                                playerEntity.getInventory().removeOne(stack);
                            }
                        }
                    }

                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
                    if (j > 0) {
                        float f = playerEntity.getYaw();
                        float g = playerEntity.getPitch();
                        float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
                        float k = -MathHelper.sin(g * 0.017453292F);
                        float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
                        float m = MathHelper.sqrt(h * h + k * k + l * l);
                        float n = 3.0F * ((1.0F + (float)j) / 4.0F);
                        h *= n / m;
                        k *= n / m;
                        l *= n / m;
                        playerEntity.addVelocity((double)h, (double)k, (double)l);
                        playerEntity.useRiptide(20);
                        if (playerEntity.isOnGround()) {
                            float o = 1.1999999F;
                            playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
                        }

                        SoundEvent soundEvent;
                        if (j >= 3) {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
                        } else if (j == 2) {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
                        } else {
                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
                        }

                        world.playSoundFromEntity((PlayerEntity)null, playerEntity, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                    }

                }
            }
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (itemStack.getDamage() >= itemStack.getMaxDamage() - 1) {
            return TypedActionResult.fail(itemStack);
        } else if (EnchantmentHelper.getRiptide(itemStack) > 0 && !user.isTouchingWaterOrRain()) {
            return TypedActionResult.fail(itemStack);
        } else {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if ((double)state.getHardness(world, pos) != 0.0) {
            stack.damage(2, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    public int getEnchantability() {
        return 1;
    }

}
