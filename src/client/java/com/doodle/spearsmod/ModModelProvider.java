package com.doodle.spearsmod;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

import static com.doodle.spearsmod.init.moditems.*;

public class ModModelProvider {
    private static void registerTridentModels() {
        ModelPredicateProviderRegistry.register(WOODEN_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(STONE_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(IRON_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(GOLDEN_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(DIAMOND_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
        ModelPredicateProviderRegistry.register(NETHERITE_SPEAR, new Identifier("throwing"), (itemStack, clientWorld, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
        });
    }

    public static void registerItemsWithModelProvider() {
    registerTridentModels();
    }
}
