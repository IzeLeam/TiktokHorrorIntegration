package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import io.github.jwdeveloper.tiktok.data.models.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserFollowEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final User user;
    private final int totalFollowers;

    public UserFollowEvent(final User user, final int totalFollowers) {
        this.user = user;
        this.totalFollowers = totalFollowers;
    }

    public User getUser() {
        return user;
    }

    public int getTotalFollowers() {
        return totalFollowers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
