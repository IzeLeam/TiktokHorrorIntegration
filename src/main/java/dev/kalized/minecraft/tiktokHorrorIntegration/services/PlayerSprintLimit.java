package dev.kalized.minecraft.tiktokHorrorIntegration.services;

import dev.kalized.minecraft.tiktokHorrorIntegration.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlayerSprintLimit {

    public static void run(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            Player player = PlayerManager.getInstance().getPlayer();
            if (player == null) {
                return;
            }

            if (player.isSprinting()) {
                Bukkit.getScheduler().runTask(plugin,
                        () -> player.setRemainingAir(player.getRemainingAir() - (player.getMaximumAir() / 5)));
                if (player.getRemainingAir() <= (player.getMaximumAir() / 5)) {
                    player.setSprinting(false);
                }
            }
        }, 0, 5);
    }
}
