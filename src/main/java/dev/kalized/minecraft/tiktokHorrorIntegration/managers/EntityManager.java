package dev.kalized.minecraft.tiktokHorrorIntegration.managers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager {

    public static void spawnEntity() {
        if (!PlayerManager.getInstance().isPlayerConnected()) {
            return;
        }
/*
        Player player = PlayerManager.getInstance().getPlayer();

        Map<EntityType, Integer> entityCount = player.getNearbyEntities(30, 10, 30).stream()
                .filter(entity -> AllowedEntityTypes.isAllowed(entity.getType()))
                .collect(Collectors.groupingBy(Entity::getType, Collectors.summingInt(entity -> 1)));
        EntityType entityType = entityCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(AllowedEntityTypes.getAllowedEntityTypes().getFirst());

        spawnEntity(entityType);
        */
    }

    public static void spawnEntity(final EntityType type) {
        Location location = ZoneManager.getInstance().getRandomPosition();
        if (location.getWorld() == null) {
            return;
        }

        location.setY(location.getWorld().getHighestBlockYAt(location));
        location.getWorld().spawnEntity(location, type);
    }
}

enum AllowedEntityTypes {
    ZOMBIE(EntityType.ZOMBIE),
    SKELETON(EntityType.SKELETON),
    SPIDER(EntityType.SPIDER),
    CREEPER(EntityType.CREEPER);

    private final EntityType entityType;

    AllowedEntityTypes(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public static boolean isAllowed(EntityType entityType) {
        for (AllowedEntityTypes allowedEntityTypes : values()) {
            if (allowedEntityTypes.getEntityType().equals(entityType)) {
                return true;
            }
        }
        return false;
    }

    public static List<EntityType> getAllowedEntityTypes() {
        return Arrays.stream(values()).map(AllowedEntityTypes::getEntityType).collect(Collectors.toList());
    }
}
