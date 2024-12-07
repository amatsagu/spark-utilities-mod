package amatsagu.spark_utilities;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePack;
import net.minecraft.text.Text;

public class ClientInitializer implements ClientModInitializer {
    private static final String REQUIRED_IDENTIFIER = "my_unique_resource_pack";

    @Override
    public void onInitializeClient() {
        // Schedule the check when the client starts
        // MinecraftClient client = MinecraftClient.getInstance();

        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        // client.execute(() -> {
        //     client
        //     .getResourcePackManager()
        //     .getEnabledProfiles()
        //     .stream()
        //     .forEach(pack -> System.out.println(pack.getInformationText(true).toString()));

        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            //     .anyMatch(pack -> pack.getName().equals(REQUIRED_IDENTIFIER));

            // if (!hasRequiredPack) {
            //     client.world.disconnect(); // Disconnect the player
            //     client.setScreen(new net.minecraft.client.gui.screen.DisconnectedScreen(
            //         null,
            //         Text.of("Resource Pack Missing"),
            //         Text.of("You must enable the required resource pack to play.")
            //     ));
            // }
        // });
    }
}