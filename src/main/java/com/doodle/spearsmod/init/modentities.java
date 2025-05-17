package com.doodle.spearsmod.init;

import com.doodle.spearsmod.SimpleSpears;
import com.doodle.spearsmod.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class modentities {


    public static final EntityType<SpearEntity> SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "spear"),
            FabricEntityTypeBuilder.<SpearEntity>create(SpawnGroup.MISC, SpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<WoodenSpearEntity> WOODEN_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "wooden_spear"),
            FabricEntityTypeBuilder.<WoodenSpearEntity>create(SpawnGroup.MISC, WoodenSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<StoneSpearEntity> STONE_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "stone_spear"),
            FabricEntityTypeBuilder.<StoneSpearEntity>create(SpawnGroup.MISC, StoneSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<IronSpearEntity> IRON_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "iron_spear"),
            FabricEntityTypeBuilder.<IronSpearEntity>create(SpawnGroup.MISC, IronSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<GoldenSpearEntity> GOLDEN_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "golden_spear"),
            FabricEntityTypeBuilder.<GoldenSpearEntity>create(SpawnGroup.MISC, GoldenSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<DiamondSpearEntity> DIAMOND_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "diamond_spear"),
            FabricEntityTypeBuilder.<DiamondSpearEntity>create(SpawnGroup.MISC, DiamondSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<NetheriteSpearEntity> NETHERITE_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SimpleSpears.MOD_ID, "netherite_spear"),
            FabricEntityTypeBuilder.<NetheriteSpearEntity>create(SpawnGroup.MISC, NetheriteSpearEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());



    public static void registerModEntities() {
        SimpleSpears.LOGGER.info("Registering Entities for " + SimpleSpears.MOD_ID);
    }
}
