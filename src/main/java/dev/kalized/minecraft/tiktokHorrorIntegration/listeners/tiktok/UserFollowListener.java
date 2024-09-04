package dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok;

import dev.kalized.minecraft.tiktokHorrorIntegration.events.UserFollowEvent;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.EntityManager;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.PlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UserFollowListener implements Listener {

    @EventHandler
    public void onUserFollow(UserFollowEvent event) {
        PlayerManager.getInstance().sendTitle("§4" + event.getUser().getProfileName(), "§8just followed", 10, 40, 20);
        EntityManager.spawnEntity();
    }
}