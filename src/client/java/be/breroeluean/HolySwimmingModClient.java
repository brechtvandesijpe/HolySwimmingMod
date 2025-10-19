package be.breroeluean;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.api.ClientModInitializer;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class HolySwimmingModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null) {
                disableSwimming(client.world);
            }
        });
	}

    private static void disableSwimming(World world) {
        for (PlayerEntity player : world.getPlayers()) {
            if (player.isSwimming()) {
                player.setSwimming(false);
                player.setPose(EntityPose.STANDING);
            }
        }
    }
}