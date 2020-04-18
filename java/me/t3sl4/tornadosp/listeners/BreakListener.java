package me.t3sl4.tornadosp.listeners;

import java.util.ArrayList;
import java.util.List;
import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakListener implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void spawnerBreakListener(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Location bloc = e.getBlock().getLocation();
        if (API.spawnertypes.getItemSpawnerTypeFromLocation(bloc) != null) {
            ItemSpawnerType ist = API.spawnertypes.getItemSpawnerTypeFromLocation(bloc);
            if (!e.isCancelled()) {
                e.setCancelled(true);
                if (API.checkInventory(p, ist.getKendisi().getItemStack())) {
                    if (!p.isOp()) {
                        if (p.getItemInHand() != null) {
                            ItemStack item = p.getItemInHand();
                            if (item.getType().getId() == Styles.Item_Pickaxe.getId()) {
                                String itemname = item.getItemMeta().getDisplayName();
                                ArrayList<String> itemlore = (ArrayList<String>)item.getItemMeta().getLore();
                                if (itemlore == null) {
                                    itemlore = new ArrayList<>();
                                    itemlore.add(".");
                                }
                                if (itemname == null)
                                    itemname = ".";
                                if (Styles.Minimum_SilkTouch_Level_For_Break_To_Spawner > 0) {
                                    if (item.getItemMeta().getEnchantLevel(Enchantment.SILK_TOUCH) >= Styles.Minimum_SilkTouch_Level_For_Break_To_Spawner) {
                                        if (itemCompare(itemname, itemlore)) {
                                            e.getBlock().setType(Material.AIR);
                                            ItemStack itemStack = ist.getKendisi().getItemStack();
                                            p.getInventory().addItem(new ItemStack[] { itemStack });
                                        } else {
                                            p.sendMessage(Styles.Just_Breakable_With_Speacial_Pickaxe);
                                        }
                                    } else {
                                        p.sendMessage(Styles.Insufficient_SilkTouch_Level.replaceAll("%Required%", String.valueOf(Styles.Minimum_SilkTouch_Level_For_Break_To_Spawner)));
                                    }
                                } else if (itemCompare(itemname, itemlore)) {
                                    e.getBlock().setType(Material.AIR);
                                    ItemStack itemStack = ist.getKendisi().getItemStack();
                                    p.getInventory().addItem(new ItemStack[] { itemStack });
                                } else {
                                    p.sendMessage(Styles.Just_Breakable_With_Speacial_Pickaxe);
                                }
                            } else {
                                p.sendMessage(Styles.Just_Breakable_With_Speacial_Pickaxe);
                            }
                        }
                    } else {
                        e.getBlock().setType(Material.AIR);
                        ItemStack item = ist.getKendisi().getItemStack();
                        p.getInventory().addItem(new ItemStack[] { item });
                    }
                } else {
                    p.sendMessage(Styles.Inventory_Is_Full);
                }
            }
        }
    }

    private boolean itemCompare(String name, List<String> lore) {
        String pickaxename = Styles.Item_Pickaxe.getName();
        List<String> pickaxelore = Styles.Item_Pickaxe.getLore();
        return !((!pickaxename.equals(".") || !((String)pickaxelore.get(0)).equals(".")) && (!name.equals(pickaxename) || !lore.equals(pickaxelore)));
    }
}
