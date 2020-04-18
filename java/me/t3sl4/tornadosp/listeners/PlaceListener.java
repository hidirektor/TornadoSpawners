package me.t3sl4.tornadosp.listeners;

import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceListener implements Listener {
    @EventHandler(
            priority = EventPriority.NORMAL
    )
    public void spawnerPlaceListener(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (API.getItemSpawnerTypeFromItemStack(p.getItemInHand()) != null) {
            ItemSpawnerType ist = API.getItemSpawnerTypeFromItemStack(p.getItemInHand());
            if (!e.isCancelled()) {
                Bukkit.getScheduler().runTaskLater(TornadoSpawnersPlugin.getPlugin(), () -> {
                    if (p.getGameMode() == GameMode.CREATIVE) {
                        if (p.getItemInHand().getAmount() == 1) {
                            p.getInventory().remove(p.getItemInHand());
                            p.updateInventory();
                        } else {
                            p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                            p.updateInventory();
                        }
                    }

                    API.item.setItemSpawner(p, ist, e.getBlock().getLocation());
                }, 1L);
            }
        }

    }
}