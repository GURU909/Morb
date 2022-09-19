package net.mcreator.morb.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.morb.network.MorbModVariables;
import net.mcreator.morb.init.MorbModGameRules;

public class BloodPlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(MorbModGameRules.MORBMODE)) {
			{
				double _setval = 0;
				entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TicksElapsed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
