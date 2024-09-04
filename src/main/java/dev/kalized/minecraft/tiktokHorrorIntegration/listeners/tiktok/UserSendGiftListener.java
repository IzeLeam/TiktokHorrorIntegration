package dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok;

import dev.kalized.minecraft.tiktokHorrorIntegration.events.UserSendGiftEvent;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.EntityManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UserSendGiftListener implements Listener {

    @EventHandler
    public void onUserSendGift(UserSendGiftEvent event) {
        for (int i = 0; i < event.getGift().getDiamondCost(); i++) {
            EntityManager.spawnEntity();
        }
    }
}
