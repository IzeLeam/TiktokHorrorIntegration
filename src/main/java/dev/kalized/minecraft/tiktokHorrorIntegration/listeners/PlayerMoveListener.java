package dev.kalized.minecraft.tiktokHorrorIntegration.listeners;

import dev.kalized.minecraft.tiktokHorrorIntegration.managers.PlayerManager;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.ZoneManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerSprint(PlayerToggleSprintEvent event) {
        if (event.getPlayer().getRemainingAir() < (event.getPlayer().getMaximumAir() / 2)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = PlayerManager.getInstance().getPlayer();
        Location location = player.getLocation();

        final int distance = (int) ZoneManager.getInstance().getCenter().setY(player.getLocation().getY()).toLocation(player.getWorld()).distance(player.getLocation());

        PlayerManager.getInstance().setActionBarMessage("§4" + distance);
    }

    private String getArrowDirection(float yaw) {
        return "<arrow>" + yaw;
    }
}
