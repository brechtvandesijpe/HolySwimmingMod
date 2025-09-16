package be.breroeluean;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EntityPose;

public class HolySwimmingMod implements ModInitializer {
    public static final String MOD_ID = "HolySwimmingMod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
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