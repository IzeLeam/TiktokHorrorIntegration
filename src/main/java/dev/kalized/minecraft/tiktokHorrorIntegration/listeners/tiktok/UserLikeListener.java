package dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok;

import dev.kalized.minecraft.tiktokHorrorIntegration.TiktokHorrorIntegration;
import dev.kalized.minecraft.tiktokHorrorIntegration.events.UserLikeEvent;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.EntityManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UserLikeListener implements Listener {

    private final int likePerSpawn = TiktokHorrorIntegration.getInstance().getConfig().getInt("tiktok.like-per-spawn");
    //private int likeCountDown = likePerSpawn;

    @EventHandler
    public void onUserLike(UserLikeEvent event) {
        /*
        likeCountDown -= event.getLikes();
        while (likeCountDown <= 0) {
            EntityManager.spawnEntity();
            likeCountDown += likePerSpawn;
        }
        */
        System.out.println("UserLikeEvent");
    }
}
