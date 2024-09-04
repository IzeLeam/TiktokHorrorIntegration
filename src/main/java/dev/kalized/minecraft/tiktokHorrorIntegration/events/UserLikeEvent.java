package dev.kalized.minecraft.tiktokHorrorIntegration.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UserLikeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
