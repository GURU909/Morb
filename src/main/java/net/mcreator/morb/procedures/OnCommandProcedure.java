package net.mcreator.morb.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.CommandEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.morb.init.MorbModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnCommandProcedure {
	@SubscribeEvent
	public static void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			execute(event, entity.level, event.getParseResults().getReader().getString());
		}
	}

	public static void execute(LevelAccessor world, String command) {
		execute(null, world, command);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, String command) {
		if (command == null)
			return;
		if ((command).equals("/gamerule morbMode true")) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(MorbModGameRules.MORBMODE).set((true), _level.getServer());
		}
		if ((command).equals("/gamerule morbMode false")) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(MorbModGameRules.MORBMODE).set((false), _level.getServer());
		}
	}
}
