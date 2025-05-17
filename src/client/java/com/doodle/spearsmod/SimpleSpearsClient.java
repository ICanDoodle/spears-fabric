package com.doodle.spearsmod;

import com.doodle.spearsmod.entity.*;
import com.doodle.spearsmod.init.modentities;
import com.doodle.spearsmod.init.moditems;
import com.doodle.spearsmod.model.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourceType;

public class SimpleSpearsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModModelProvider.registerItemsWithModelProvider();
        EntityModelLayerRegistry.registerModelLayer(SpearModel.SPEAR, SpearModel::getTexturedModelData);
        EntityRendererRegistry.register(modentities.SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.WOODEN_SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.STONE_SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.IRON_SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.GOLDEN_SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.DIAMOND_SPEAR, SpearEntityRenderer::new);
        EntityRendererRegistry.register(modentities.NETHERITE_SPEAR, SpearEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CrossSpearModel.CROSS_SPEAR, CrossSpearModel::getTexturedModelData);
    }


    public static void registerBuiltinItemRenderers(MinecraftClient client) {
        BuiltinItemModRenderer builtinItemModRenderer = new BuiltinItemModRenderer(client.getBlockEntityRenderDispatcher(), client.getEntityModelLoader());
       ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(builtinItemModRenderer);
        BuiltinItemRendererRegistry.DynamicItemRenderer dynamicItemRenderer = builtinItemModRenderer::render;
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.WOODEN_SPEAR, dynamicItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.STONE_SPEAR, dynamicItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.IRON_SPEAR, dynamicItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.GOLDEN_SPEAR, dynamicItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.DIAMOND_SPEAR, dynamicItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(moditems.NETHERITE_SPEAR, dynamicItemRenderer);

    }

}
