
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.morb.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.morb.item.BloodItem;
import net.mcreator.morb.MorbMod;

public class MorbModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MorbMod.MODID);
	public static final RegistryObject<Item> BLOOD = REGISTRY.register("blood", () -> new BloodItem());
}
