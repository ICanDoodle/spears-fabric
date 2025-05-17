package com.doodle.spearsmod.model;

import com.doodle.spearsmod.SimpleSpears;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class CrossSpearModel extends EntityModel<Entity> {
	private final ModelPart group;

	public static final EntityModelLayer CROSS_SPEAR =
			new EntityModelLayer(new Identifier(SimpleSpears.MOD_ID, "cross_spear_model"), "main");

	public CrossSpearModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		this.group = root.getChild("group");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create().uv(0, 0).cuboid(-0.9239F, 4.6173F, 0.0F, 1.0F, 26.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(-3.9239F, -1.3827F, 0.5F, 7.0F, 8.0F, 0.0F, new Dilation(0.0F))
		.uv(4, 16).cuboid(-1.4239F, 6.6173F, -0.5F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.4239F, -6.6173F, -0.5F));

		ModelPartData cube_r1 = group.addChild("cube_r1", ModelPartBuilder.create().uv(4, 0).cuboid(-3.5F, 1.0F, 0.0F, 7.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.4239F, -2.3827F, 0.5F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		group.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}