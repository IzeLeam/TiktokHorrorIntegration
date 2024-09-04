package dev.kalized.minecraft.tiktokHorrorIntegration.managers;

import dev.kalized.minecraft.tiktokHorrorIntegration.TiktokHorrorIntegration;
import dev.kalized.minecraft.tiktokHorrorIntegration.utils.Cuboid;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;

public class ZoneManager {

    private static ZoneManager instance;

    public static ZoneManager getInstance() {
        if (instance == null) {
            instance = new ZoneManager();
        }
        return instance;
    }

    private final Cuboid cuboid;

    private ZoneManager() {
        FileConfiguration config = TiktokHorrorIntegration.getInstance().getConfig();
        final int x1 = config.getInt("zone.x1");
        final int y1 = config.getInt("zone.y1");
        final int z1 = config.getInt("zone.z1");
        final int x2 = config.getInt("zone.x2");
        final int y2 = config.getInt("zone.y2");
        final int z2 = config.getInt("zone.z2");

        this.cuboid = new Cuboid(x1, y1, z1, x2, y2, z2);
        this.cuboid.setHeightLimit(false);
    }

    public boolean isInZone(Location location) {
        return this.cuboid.isInCuboid(location);
    }

    public boolean isInZone(Block block) {
        return this.cuboid.isInCuboid(block.getLocation());
    }

    public boolean isInZone(LivingEntity entity) {
        return this.cuboid.isInCuboid(entity.getLocation());
    }

    public int getDistanceFromCenter(Location location) {
        return this.cuboid.getDistanceFromCenter(location);
    }

    public Vector getCenter() {
        return this.cuboid.getCenter();
    }
}
