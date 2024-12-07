package com.amatsagu.spark_utilities;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.MinecraftServer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.GameRules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SparkUtilities implements ModInitializer {
	public static final String MOD_ID = "spark_utilities";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Loaded Spark Utilities mod!");
		ServerLifecycleEvents.SERVER_STARTED.register(this::onServerStarted);
	}

	private void onServerStarted(MinecraftServer server) {
        // Access the current game rules from the server
        GameRules gameRules = server.getGameRules();

		GameRules.IntRule minecartSpeed = gameRules.get(GameRules.MINECART_MAX_SPEED);
		if (minecartSpeed == null) {
			LOGGER.warn("Failed to detect \"minecartMaxSpeed\" gamerule. Mod will not increase max minecart speed.");
			return;
		}

		minecartSpeed.set(minecartSpeed.get() * 2, server);
		LOGGER.info("Successfully doubled speed of minecarts.");
    }
}