package dev.kalized.minecraft.tiktokHorrorIntegration.managers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityManager {

    public static void spawnEntity() {
        if (!PlayerManager.getInstance().isPlayerConnected()) {
            return;
        }

        spawnEntity(AllowedEntityTypes.getRandomEntityType());
    }

    public static void spawnEntity(final EntityType type) {
        Location location = ZoneManager.getInstance().getRandomPosition();
        if (location.getWorld() == null) {
            return;
        }

        location.setY(location.getWorld().getHighestBlockYAt(location));
        location.getWorld().spawnEntity(location, type);
    }

    private enum AllowedEntityTypes {
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

        public static EntityType getRandomEntityType() {
            return values()[(int) (Math.random() * values().length)].getEntityType();
        }
    }
}
