package dev.kalized.minecraft.tiktokHorrorIntegration;

import dev.kalized.minecraft.tiktokHorrorIntegration.listeners.PlayerConnectionListener;
import dev.kalized.minecraft.tiktokHorrorIntegration.listeners.PlayerMoveListener;
import dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok.UserFollowListener;
import dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok.UserLikeListener;
import dev.kalized.minecraft.tiktokHorrorIntegration.listeners.tiktok.UserSendGiftListener;
import dev.kalized.minecraft.tiktokHorrorIntegration.services.PlayerSprintLimit;
import dev.kalized.minecraft.tiktokHorrorIntegration.tiktok.TikTokClient;
import io.github.jwdeveloper.tiktok.TikTokLive;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TiktokHorrorIntegration extends JavaPlugin {

    private final PluginManager pluginManager = Bukkit.getPluginManager();
    private static TiktokHorrorIntegration instance = null;

    @Override
    public void onEnable() {
        instance = this;

        // Save the config
        saveDefaultConfig();

        // Listener registering
        pluginManager.registerEvents(new PlayerConnectionListener(), this);
        pluginManager.registerEvents(new PlayerMoveListener(), this);

        pluginManager.registerEvents(new UserLikeListener(), this);
        pluginManager.registerEvents(new UserFollowListener(), this);
        pluginManager.registerEvents(new UserSendGiftListener(), this);

        TikTokClient.getInstance();
        //PlayerSprintLimit.run(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TiktokHorrorIntegration getInstance() {
        return instance;
    }
}
