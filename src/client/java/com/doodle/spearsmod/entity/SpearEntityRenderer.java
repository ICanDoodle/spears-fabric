package com.doodle.spearsmod.entity;



import com.doodle.spearsmod.config.SimpleSpearsConfig;
import com.doodle.spearsmod.model.CrossSpearModel;
import com.doodle.spearsmod.model.SpearModel;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

import static com.doodle.spearsmod.config.SimpleSpearsConfig.*;

public class SpearEntityRenderer extends EntityRenderer<SpearEntity> {
    public static final Identifier WOODEN_SPEAR = new Identifier("spearsmod:textures/entity/wooden_spear.png");
    public static final Identifier STONE_SPEAR = new Identifier("spearsmod:textures/entity/stone_spear.png");
    public static final Identifier IRON_SPEAR = new Identifier("spearsmod:textures/entity/iron_spear.png");
    public static final Identifier GOLDEN_SPEAR = new Identifier("spearsmod:textures/entity/golden_spear.png");
    public static final Identifier DIAMOND_SPEAR = new Identifier("spearsmod:textures/entity/diamond_spear.png");
    public static final Identifier NETHERITE_SPEAR = new Identifier("spearsmod:textures/entity/netherite_spear.png");

    public static final Identifier WOODEN_CROSS = new Identifier("spearsmod:textures/entity/wooden_spear_plane.png");
    public static final Identifier STONE_CROSS = new Identifier("spearsmod:textures/entity/stone_spear_plane.png");
    public static final Identifier IRON_CROSS = new Identifier("spearsmod:textures/entity/iron_spear_plane.png");
    public static final Identifier GOLDEN_CROSS = new Identifier("spearsmod:textures/entity/golden_spear_plane.png");
    public static final Identifier DIAMOND_CROSS = new Identifier("spearsmod:textures/entity/diamond_spear_plane.png");
    public static final Identifier NETHERITE_CROSS = new Identifier("spearsmod:textures/entity/netherite_spear_plane.png");
    private final SpearModel spearModel;
    private final CrossSpearModel crossModel;



    public SpearEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.spearModel = new SpearModel(context.getPart(SpearModel.SPEAR));
        this.crossModel = new CrossSpearModel(context.getPart(CrossSpearModel.CROSS_SPEAR));
    }


    @Override
    public void render(SpearEntity spear, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (!isModelCross) {
            if (spear instanceof WoodenSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof StoneSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof IronSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof GoldenSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof DiamondSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof NetheriteSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.spearModel.getLayer(this.getTexture(spear)), false, spear.isEnchanted());
                this.spearModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            }
        } else if (isModelCross) {
            if (spear instanceof WoodenSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof StoneSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof IronSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof GoldenSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof DiamondSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            } else if (spear instanceof NetheriteSpearEntity) {
                matrixStack.push();
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevYaw, (float) spear.getYaw()) - 90.0f));
                matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp((float) g, (float) spear.prevPitch, (float) spear.getPitch()) + 90.0f));
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, RenderLayer.getEntityCutout(this.getTexture(spear)), false, spear.isEnchanted());
                this.crossModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
                matrixStack.pop();
                super.render(spear, f, g, matrixStack, vertexConsumerProvider, i);
            }
        }
    }

    @Override
    public Identifier getTexture(SpearEntity spear) {
        if (!isModelCross) {
            if (spear instanceof WoodenSpearEntity) {
                return WOODEN_SPEAR;
            } else if (spear instanceof StoneSpearEntity) {
                return STONE_SPEAR;
            } else if (spear instanceof IronSpearEntity) {
                return IRON_SPEAR;
            } else if (spear instanceof GoldenSpearEntity) {
                return GOLDEN_SPEAR;
            } else if (spear instanceof DiamondSpearEntity) {
                return DIAMOND_SPEAR;
            } else if (spear instanceof NetheriteSpearEntity) {
                return NETHERITE_SPEAR;
            } else return WOODEN_SPEAR;

        } 
        else if (isModelCross) {
            if (spear instanceof WoodenSpearEntity) {
                return WOODEN_CROSS;
            } else if (spear instanceof StoneSpearEntity) {
                return STONE_CROSS;
            } else if (spear instanceof IronSpearEntity) {
                return IRON_CROSS;
            } else if (spear instanceof GoldenSpearEntity) {
                return GOLDEN_CROSS;
            } else if (spear instanceof DiamondSpearEntity) {
                return DIAMOND_CROSS;
            } else if (spear instanceof NetheriteSpearEntity) {
                return NETHERITE_CROSS;
            } else return WOODEN_CROSS;
        } return null;
    }
}
