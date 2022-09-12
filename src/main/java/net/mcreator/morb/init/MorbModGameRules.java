
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.morb.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MorbModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> MORBMODE = GameRules.register("morbMode", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(false));
}
