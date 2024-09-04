package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import io.github.jwdeveloper.tiktok.data.models.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserCommentEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final User user;
    private final String message;

    public UserCommentEvent(final User user, final String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
