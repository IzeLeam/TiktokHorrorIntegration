package dev.kalized.minecraft.tiktokHorrorIntegration.utils;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Cuboid {

    private int x1;
    private int y1;
    private int z1;
    private int x2;
    private int y2;
    private int z2;
    private boolean heightLimit = true;

    public Cuboid(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = y1;
        this.z1 = Math.min(z1, z2);
        this.x2 = Math.max(x1, x2);
        this.y2 = y2;
        this.z2 = Math.max(z1, z2);
    }

    public Cuboid(Location l1, Location l2) {
        this(l1.getBlockX(), l1.getBlockY(), l1.getBlockZ(), l2.getBlockX(), l2.getBlockY(), l2.getBlockZ());
    }

    public boolean isInCuboid(Location location) {
        return (between(x1, location.getBlockX(), x2) && ( !heightLimit || between(y1, location.getBlockY(), y2)) && between(z1, location.getBlockZ(), z2));
    }

    public Vector getCenter() {
        return new Vector((x1 + x2) / 2, (y1 + y2) / 2, (z1 + z2) / 2);
    }

    public boolean isHeightLimit() {
        return heightLimit;
    }

    public void setHeightLimit(boolean heightLimit) {
        this.heightLimit = heightLimit;
    }

    private boolean between(int a, int b, int c) {
        return b >= Math.min(a, c) && b <= Math.max(a, c);
    }

    public int getDistanceFromCenter(Location location) {
        Vector center = getCenter();
        if (heightLimit) {
            return (int) Math.max(Math.abs(center.getX() - location.getX()), Math.abs(center.getZ() - location.getZ()));
        } else {
            return (int) Math.max(Math.abs(center.getX() - location.getX()), Math.max(Math.abs(center.getY() - location.getY()), Math.abs(center.getZ() - location.getZ())));
        }
    }
}
