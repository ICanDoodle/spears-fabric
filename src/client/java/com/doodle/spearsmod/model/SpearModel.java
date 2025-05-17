package com.doodle.spearsmod.model;

import com.doodle.spearsmod.SimpleSpears;
import com.doodle.spearsmod.entity.DiamondSpearEntity;
import com.doodle.spearsmod.entity.SpearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.util.Identifier;

public class SpearModel extends Model {
	private final ModelPart group;

	public static final EntityModelLayer SPEAR =
			new EntityModelLayer(new Identifier(SimpleSpears.MOD_ID, "spear"), "main");

	public SpearModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		this.group = root.getChild("group");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData group = modelPartData.addChild("group", ModelPartBuilder.create().uv(0, 0).cuboid(-0.9239F, -0.3827F, 0.0F, 1.0F, 31.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.4239F, -6.6173F, -0.5F));

		ModelPartData cube_r1 = group.addChild("cube_r1", ModelPartBuilder.create().uv(9, 12).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		ModelPartData cube_r2 = group.addChild("cube_r2", ModelPartBuilder.create().uv(7, 12).cuboid(-2.0F, 0.0F, 0.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0761F, 0.0F, 0.0761F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r3 = group.addChild("cube_r3", ModelPartBuilder.create().uv(5, 12).cuboid(0.0F, -6.0F, 1.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.4483F, 5.5433F, -1.0F, 0.0F, 0.0F, -0.3927F));

		ModelPartData cube_r4 = group.addChild("cube_r4", ModelPartBuilder.create().uv(4, 2).cuboid(-1.0F, -7.0F, -1.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0761F, 6.4672F, -1.7549F, -0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		group.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}


}