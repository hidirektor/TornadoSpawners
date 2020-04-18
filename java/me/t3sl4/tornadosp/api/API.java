package me.t3sl4.tornadosp.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.commands.CommandHandler;
import me.t3sl4.tornadosp.commands.itemsp.general.ReloadCommand;
import me.t3sl4.tornadosp.commands.itemsp.spawner.DagitCommand;
import me.t3sl4.tornadosp.commands.itemsp.spawner.ListeleCommand;
import me.t3sl4.tornadosp.commands.itemsp.spawner.VerCommand;
import me.t3sl4.tornadosp.listeners.BreakListener;
import me.t3sl4.tornadosp.listeners.ExplodeListener;
import me.t3sl4.tornadosp.listeners.PlaceListener;
import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.nms.SpawnerTypesINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class API {
    public static String Plugin_Language = "en";
    public static ConfigAPI languages;
    public static ConfigAPI spawnerlar;
    public static ConfigAPI komutlar;
    public static ConfigAPI ayarlar;
    public static String version;
    public static ItemSpawnerINT item;
    public static SpawnerTypesINT spawnertypes;

    public static String chatcolor(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static List<String> getChatColorList(List<String> list) {
        ArrayList<String> liste = new ArrayList();
        list.forEach((templist) -> {
            liste.add(chatcolor(templist));
        });
        return liste;
    }

    public static void registerListener() {
        registerListeners(new PlaceListener(), new BreakListener(), new ExplodeListener());
    }

    private static void registerListeners(Listener... listeners) {
        Arrays.stream(listeners).forEach((listener) -> {
            Bukkit.getPluginManager().registerEvents(listener, TornadoSpawnersPlugin.getPlugin());
        });
    }

    public static void registerCommands() {
        CommandHandler handler = new CommandHandler(Styles.Main_Command);
        handler.addArgs(Styles.Reload_Arg, new ReloadCommand());
        handler.addArgs(Styles.List_Arg, new ListeleCommand());
        handler.addArgs(Styles.Give_Arg, new VerCommand());
        handler.addArgs(Styles.Deal_Arg, new DagitCommand());
        handler.build();
    }

    public static boolean checkInventory(Player p, ItemStack item) {
        if (p.getInventory().firstEmpty() >= 0 && item.getAmount() <= item.getMaxStackSize()) {
            return true;
        } else {
            HashMap<Integer, ? extends ItemStack> items = p.getInventory().all(item.getType());
            int amount = item.getAmount();

            ItemStack i;
            for(Iterator var5 = items.values().iterator(); var5.hasNext(); amount -= i.getMaxStackSize() - i.getAmount()) {
                i = (ItemStack)var5.next();
            }

            return amount <= 0;
        }
    }

    public static ItemSpawnerType getItemSpawnerTypeFromItemStack(ItemStack itemInHand) {
        Iterator var2 = Styles.ItemSpawner_Types.iterator();

        while(var2.hasNext()) {
            ItemSpawnerType ist = (ItemSpawnerType)var2.next();
            if (itemInHand.isSimilar(ist.getKendisi().getItemStack())) {
                return ist;
            }
        }

        return null;
    }

    public static ItemSpawnerType getItemSpawnerTypeFromID(String arg) {
        Iterator var2 = Styles.ItemSpawner_Types.iterator();

        while(var2.hasNext()) {
            ItemSpawnerType ist = (ItemSpawnerType)var2.next();
            if (Objects.equals(ist.getSpawnerid(), arg)) {
                return ist;
            }
        }

        return null;
    }
}