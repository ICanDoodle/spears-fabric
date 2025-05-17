package com.doodle.spearsmod.mixin.client;

import com.doodle.spearsmod.SimpleSpears;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void addModel(ModelIdentifier modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addWoodenSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "wooden_spear_in_hand", "inventory"));
    }
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addStoneSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "stone_spear_in_hand", "inventory"));
    }
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addIronSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "iron_spear_in_hand", "inventory"));
    }
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addGoldenSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "golden_spear_in_hand", "inventory"));
    }
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addDiamondSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "diamond_spear_in_hand", "inventory"));
    }
    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addNetheriteSpear(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> modelResources, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStateResources, CallbackInfo ci) {
        this.addModel(new ModelIdentifier(SimpleSpears.MOD_ID, "netherite_spear_in_hand", "inventory"));
    }
}
