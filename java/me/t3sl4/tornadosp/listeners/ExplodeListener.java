package me.t3sl4.tornadosp.listeners;

import java.util.Iterator;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeListener implements Listener {
    @EventHandler(
            priority = EventPriority.NORMAL
    )
    public void spawnerExplodeListener(EntityExplodeEvent event) {
        Iterator var3 = event.blockList().iterator();

        while(var3.hasNext()) {
            Block b = (Block)var3.next();
            if (b.getType() == Material.MOB_SPAWNER && API.spawnertypes.getItemSpawnerTypeFromLocation(b.getLocation()) != null) {
                ItemSpawnerType ist = API.spawnertypes.getItemSpawnerTypeFromLocation(b.getLocation());
                if (Styles.Stay_Exploded_Location) {
                    Bukkit.getScheduler().runTaskLater(TornadoSpawnersPlugin.getPlugin(), () -> {
                        b.setType(Material.MOB_SPAWNER);
                        API.item.setItemSpawner(ist, b.getLocation());
                    }, 1L);
                } else {
                    b.getLocation().getWorld().dropItemNaturally(b.getLocation(), ist.getKendisi().getItemStack());
                }
            }
        }

    }
}