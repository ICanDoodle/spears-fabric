package com.doodle.spearsmod.mixin.client;

import com.doodle.spearsmod.init.moditems;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static com.doodle.spearsmod.SimpleSpears.MOD_ID;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldWoodenSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.WOODEN_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "wooden_spear_in_hand", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldStoneSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.STONE_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "stone_spear_in_hand", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldIronSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.IRON_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "iron_spear_in_hand", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldGoldenSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.GOLDEN_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "golden_spear_in_hand", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldDiamondSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.DIAMOND_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "diamond_spear_in_hand", "inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldNetheriteSpearModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(moditems.NETHERITE_SPEAR)) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MOD_ID, "netherite_spear_in_hand", "inventory"));
        }
        return value;
    }
}
