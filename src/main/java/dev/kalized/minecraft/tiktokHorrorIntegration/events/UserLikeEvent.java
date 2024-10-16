package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import io.github.jwdeveloper.tiktok.data.models.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserLikeEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final User user;
    private final int likes;
    private final int totalLikes;

    public UserLikeEvent(final User user, final int likes, final int totalLikes) {
        this.user = user;
        this.likes = likes;
        this.totalLikes = totalLikes;
    }

    public User getUser() {
        return user;
    }

    public int getLikes() {
        return likes;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
