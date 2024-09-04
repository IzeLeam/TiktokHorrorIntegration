package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import io.github.jwdeveloper.tiktok.data.models.gifts.Gift;
import io.github.jwdeveloper.tiktok.data.models.users.User;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserSendGiftEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private final User user;
    private final Gift gift;

    public UserSendGiftEvent(final User user, final Gift gift) {
        this.user = user;
        this.gift = gift;
    }

    public User getUser() {
        return user;
    }

    public Gift getGift() {
        return gift;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
