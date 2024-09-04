package dev.kalized.minecraft.tiktokHorrorIntegration.listeners;

import dev.kalized.minecraft.tiktokHorrorIntegration.managers.PlayerManager;
import dev.kalized.minecraft.tiktokHorrorIntegration.managers.ZoneManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = PlayerManager.getInstance().getPlayer();
        Location location = player.getLocation();

        final int distance = ZoneManager.getInstance().getDistanceFromCenter(location);

        PlayerManager.getInstance().setActionBarMessage(getArrowDirection(location.getYaw()) + " " + distance);
    }

    private String getArrowDirection(float yaw) {
        final String arrows = "↑↗→↘↓↙←↖↑";
        final Vector center = ZoneManager.getInstance().getCenter();

        final float angle = center.clone().subtract(center).toLocation(PlayerManager.getInstance().getPlayer().getWorld()).getYaw();
        final int index = (int) ((yaw - angle + 180) / 45) & 7;

        return arrows.substring(index, index + 1);
    }
}
