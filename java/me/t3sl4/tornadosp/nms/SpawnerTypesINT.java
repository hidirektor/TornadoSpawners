package me.t3sl4.tornadosp.nms;

import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Location;

public interface SpawnerTypesINT {
    ItemSpawnerType getItemSpawnerTypeFromLocation(Location paramLocation);
}
