package amatsagu.spark_utilities;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInitializer implements ModInitializer {
	public static final String MOD_ID = "spark_utilities";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded Spark Utilities mod!");
		ServerLifecycleEvents.SERVER_STARTED.register((MinecraftServer server) -> {
            executeCommand(server, "say Successfully loaded Sparkle Uilities mod.");
            LOGGER.info("Successfully loaded Spark Utilities mod.");
        });

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            unlockAllRecipes(handler.getPlayer());
        });
	}

	private void unlockAllRecipes(ServerPlayerEntity player) {
        if (player != null && player.getServer() != null) {
            Collection<RecipeEntry<?>> recipes = player.getServer().getRecipeManager().values();

            player.unlockRecipes(recipes);
            LOGGER.info("Unlocked " + recipes.size() + " recipes for player: " + player.getName().getString());
        }
    }

    private void executeCommand(MinecraftServer server, String command) {
        server.getCommandManager().executeWithPrefix(server.getCommandSource(), command);
    }
}