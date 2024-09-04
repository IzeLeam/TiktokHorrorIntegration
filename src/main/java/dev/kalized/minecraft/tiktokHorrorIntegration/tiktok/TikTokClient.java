package dev.kalized.minecraft.tiktokHorrorIntegration.tiktok;

import dev.kalized.minecraft.tiktokHorrorIntegration.TiktokHorrorIntegration;
import dev.kalized.minecraft.tiktokHorrorIntegration.events.*;
import io.github.jwdeveloper.tiktok.TikTokLive;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashSet;
import java.util.Set;

public class TikTokClient {

    private static TikTokClient instance;
    private final Set<String> clients = new HashSet<>();

    public static TikTokClient getInstance() {
        if (instance == null) {
            instance = new TikTokClient();
        }
        return instance;
    }

    public TikTokClient() {
        Bukkit.getScheduler().runTaskTimerAsynchronously(TiktokHorrorIntegration.getInstance(), () -> {
            final FileConfiguration config = TiktokHorrorIntegration.getInstance().getConfig();

            for (String host : config.getStringList("tiktok.hosts")) {
                if (TikTokLive.isLiveOnline(host) && !clients.contains(host)) {
                    clients.add(host);
                        TikTokLive.newClient(host)
                                .onDisconnected((liveClient, event) -> {
                                    Bukkit.getLogger().info("Disconnected from " + liveClient.getRoomInfo().getHost().getProfileName() + "'s stream");
                                    clients.remove(host);
                                })
                                .onConnected((liveClient, event) -> Bukkit.getLogger().info("Connected to " + liveClient.getRoomInfo().getHost().getProfileName() + "'s stream"))
                                .onLike(((liveClient, event) -> Bukkit.getScheduler().runTask(TiktokHorrorIntegration.getInstance(), () -> {
                                    Bukkit.getPluginManager().callEvent(new UserLikeEvent(event.getUser(), event.getLikes(), event.getTotalLikes()));
                                })))
                                .onComment((liveClient, event) -> Bukkit.getScheduler().runTask(TiktokHorrorIntegration.getInstance(), () -> {
                                    Bukkit.getPluginManager().callEvent(new UserCommentEvent(event.getUser(), event.getText()));
                                }))
                                .onFollow((liveClient, event) -> Bukkit.getScheduler().runTask(TiktokHorrorIntegration.getInstance(), () -> {
                                    Bukkit.getPluginManager().callEvent(new UserFollowEvent(event.getUser(), event.getTotalFollowers()));
                                }))
                                .onJoin((liveClient, event) -> Bukkit.getScheduler().runTask(TiktokHorrorIntegration.getInstance(), () -> {
                                    Bukkit.getPluginManager().callEvent(new UserJoinEvent(event.getUser(), event.getTotalUsers()));
                                }))
                                .onGift((liveClient, event) -> Bukkit.getScheduler().runTask(TiktokHorrorIntegration.getInstance(), () -> {
                                    Bukkit.getPluginManager().callEvent(new UserSendGiftEvent(event.getUser(), event.getGift()));
                                }))
                                .onError((liveClient, event) ->
                                {
                                    System.out.println("Error! " + event.getException().getMessage());
                                })
                        .buildAndConnect();
                } else {
                    System.out.println(host + " is not on live");
                }
            }
        }, 0, 60 * 20);
    }
}
