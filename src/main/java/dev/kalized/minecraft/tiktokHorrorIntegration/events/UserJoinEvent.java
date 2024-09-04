package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import io.github.jwdeveloper.tiktok.data.models.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserJoinEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final User user;
    private final int totalUsers;

    public UserJoinEvent(final User user, final int totalUsers) {
        this.user = user;
        this.totalUsers = totalUsers;
    }

    public User getUser() {
        return user;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
