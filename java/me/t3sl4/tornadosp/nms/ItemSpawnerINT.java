package me.t3sl4.tornadosp.nms;

import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface ItemSpawnerINT {
    void setItemSpawner(Player paramPlayer, ItemSpawnerType paramItemSpawnerType, Location paramLocation);

    void setItemSpawner(ItemSpawnerType paramItemSpawnerType, Location paramLocation);
}
