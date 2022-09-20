
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.morb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.morb.MorbMod;

public class MorbModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, MorbMod.MODID);
	public static final RegistryObject<Potion> TUMMY_HURT_POTION = REGISTRY.register("tummy_hurt_potion",
			() -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 900, 3, false, false),
					new MobEffectInstance(MobEffects.BLINDNESS, 900, 2, false, false),
					new MobEffectInstance(MobEffects.BAD_OMEN, 900, 0, false, false)));
}
