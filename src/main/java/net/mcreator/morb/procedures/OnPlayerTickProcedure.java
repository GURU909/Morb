package net.mcreator.morb.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import net.mcreator.morb.network.MorbModVariables;
import net.mcreator.morb.init.MorbModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(MorbModGameRules.MORBMODE)) {
			{
				double _setval = (entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new MorbModVariables.PlayerVariables())).TicksElapsed + 1;
				entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TicksElapsed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MorbModVariables.PlayerVariables())).TicksElapsed == 1) {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(
								new TextComponent((entity.getDisplayName().getString() + " is no longer MORB MODE!")), ChatType.SYSTEM,
								Util.NIL_UUID);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeAllEffects();
			}
			if ((entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MorbModVariables.PlayerVariables())).TicksElapsed == 7200) {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " has gone MORB MODE!")),
								ChatType.SYSTEM, Util.NIL_UUID);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 630720000, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 630720000, 2));
			}
			if ((entity.getCapability(MorbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MorbModVariables.PlayerVariables())).TicksElapsed > 7200) {
				if (entity instanceof Player _player) {
					_player.getAbilities().mayfly = (true);
					_player.onUpdateAbilities();
				}
				entity.hurt(DamageSource.STARVE, (float) 0.01);
			}
		}
	}
}
