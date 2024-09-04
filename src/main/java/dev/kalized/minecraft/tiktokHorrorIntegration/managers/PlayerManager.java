package dev.kalized.minecraft.tiktokHorrorIntegration.managers;

import dev.kalized.minecraft.tiktokHorrorIntegration.TiktokHorrorIntegration;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class PlayerManager {

    private static PlayerManager instance;

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }

    private Player player;

    public boolean isPlayerConnected() {
        return this.player != null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(final Player player) {
        this.player = player;
        //player.setGameMode(GameMode.SURVIVAL);todo
        initActionBarTask();
    }

    public void removePlayer() {
        this.player = null;
        this.actionBarTask.cancel();
    }

    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        if (player == null) {
            return;
        }
        player.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    private BukkitTask actionBarTask;
    private String actionBarMessage = "";

    public void setActionBarMessage(String actionBarMessage) {
        this.actionBarMessage = actionBarMessage;
    }

    public void initActionBarTask() {
        this.actionBarTask = player.getServer().getScheduler().runTaskTimerAsynchronously(TiktokHorrorIntegration.getInstance(), () -> {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(actionBarMessage));
        }, 0, 1);
    }
}