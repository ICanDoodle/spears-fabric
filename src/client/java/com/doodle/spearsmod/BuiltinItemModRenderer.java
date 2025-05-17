package com.doodle.spearsmod;


import com.doodle.spearsmod.config.SimpleSpearsConfig;
import com.doodle.spearsmod.entity.*;
import com.doodle.spearsmod.init.moditems;
import com.doodle.spearsmod.model.*;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import static com.doodle.spearsmod.SimpleSpears.MOD_ID;

public class BuiltinItemModRenderer implements SimpleSynchronousResourceReloadListener {

    private final EntityModelLoader entityModelLoader;
    private final BlockEntityRenderDispatcher blockEntityRenderDispatcher;

    private ItemRenderer itemRenderer;

    private SpearModel spearModel;
    
    private CrossSpearModel crossModel;
    
    private BakedModel inventoryWooden;
    private BakedModel inventoryStone;
    private BakedModel inventoryIron;
    private BakedModel inventoryGolden;
    private BakedModel inventoryDiamond;
    private BakedModel inventoryNetherite;


   public BuiltinItemModRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelLoader entityModelLoader) {
       this.blockEntityRenderDispatcher = blockEntityRenderDispatcher;
       this.entityModelLoader = entityModelLoader;
   }

    @Override
    public void reload(ResourceManager manager) {
        MinecraftClient mc = MinecraftClient.getInstance();
        this.itemRenderer = mc.getItemRenderer();
     this.spearModel = new SpearModel(this.entityModelLoader.getModelPart(SpearModel.SPEAR));
     this.crossModel = new CrossSpearModel(this.entityModelLoader.getModelPart(CrossSpearModel.CROSS_SPEAR));
        this.inventoryWooden = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "wooden_spear", "inventory"));
        this.inventoryStone = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "stone_spear", "inventory"));
        this.inventoryIron = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "iron_spear", "inventory"));
        this.inventoryGolden = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "golden_spear", "inventory"));
        this.inventoryDiamond = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "diamond_spear", "inventory"));
        this.inventoryNetherite = mc.getBakedModelManager().getModel(new ModelIdentifier(MOD_ID, "netherite_spear", "inventory"));
    }

    public void render(ItemStack itemStack, ModelTransformationMode transformType, MatrixStack matrices, VertexConsumerProvider vertices, int light, int overlay) {
       if (!SimpleSpearsConfig.isModelCross) {
        if (itemStack.isOf(moditems.WOODEN_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryWooden);
            } else {
                renderWoodenSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }
        if (itemStack.isOf(moditems.STONE_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryStone);
            } else {
                renderStoneSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }
        if (itemStack.isOf(moditems.IRON_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryIron);
            } else {
                renderIronSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }

        if (itemStack.isOf(moditems.GOLDEN_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryGolden);
            } else {
                renderGoldenSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }

        if (itemStack.isOf(moditems.DIAMOND_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryDiamond);
            } else {
                renderDiamondSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }

        if (itemStack.isOf(moditems.NETHERITE_SPEAR)) {
            if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                matrices.pop();
                matrices.push();
                itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryNetherite);
            } else {
                renderNetheriteSpear(spearModel, itemStack, transformType, matrices, vertices, light, overlay);
            }
        }
    } else if (SimpleSpearsConfig.isModelCross) {
           if (itemStack.isOf(moditems.WOODEN_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryWooden);
               } else {
                   renderWoodenCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }
           if (itemStack.isOf(moditems.STONE_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryStone);
               } else {
                   renderStoneCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }
           if (itemStack.isOf(moditems.IRON_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryIron);
               } else {
                   renderIronCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }

           if (itemStack.isOf(moditems.GOLDEN_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryGolden);
               } else {
                   renderGoldenCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }

           if (itemStack.isOf(moditems.DIAMOND_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryDiamond);
               } else {
                   renderDiamondCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }

           if (itemStack.isOf(moditems.NETHERITE_SPEAR)) {
               if (transformType == ModelTransformationMode.GUI || transformType == ModelTransformationMode.GROUND || transformType == ModelTransformationMode.FIXED) {
                   matrices.pop();
                   matrices.push();
                   itemRenderer.renderItem(itemStack, transformType, false, matrices, vertices, light, overlay, this.inventoryNetherite);
               } else {
                   renderNetheriteCross(crossModel, itemStack, transformType, matrices, vertices, light, overlay);
               }
           }
       }
    }

    public static void renderWoodenSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.WOODEN_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderStoneSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.STONE_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderIronSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.IRON_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderGoldenSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.GOLDEN_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderDiamondSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.DIAMOND_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderNetheriteSpear(SpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, model.getLayer(SpearEntityRenderer.NETHERITE_SPEAR), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    public static void renderWoodenCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.WOODEN_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderStoneCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.STONE_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderIronCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.IRON_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderGoldenCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.GOLDEN_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderDiamondCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.DIAMOND_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
    public static void renderNetheriteCross(CrossSpearModel model, ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexConsumer2 = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, RenderLayer.getEntityCutout(SpearEntityRenderer.NETHERITE_CROSS), false, stack.hasGlint());
        model.render(matrices, vertexConsumer2, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }

    @Override
    public Identifier getFabricId() {
        return new Identifier("builtin_item_mod_reloader");
    }
}


