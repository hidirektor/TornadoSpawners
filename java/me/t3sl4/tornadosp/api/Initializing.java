package me.t3sl4.tornadosp.api;

import java.util.Objects;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.nms.spawnertypes.*;
import me.t3sl4.tornadosp.nms.spawnerversions.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class Initializing implements Listener {
    private static TornadoSpawnersPlugin plugin;

    public static void startPlugin(TornadoSpawnersPlugin instance) {
        Bukkit.getConsoleSender().sendMessage("§5§l-------------------------");
        Bukkit.getConsoleSender().sendMessage("         §4SYN_T3SL4");
        Bukkit.getConsoleSender().sendMessage("                      ");
        Bukkit.getConsoleSender().sendMessage("         §4Halil#4439");
        Bukkit.getConsoleSender().sendMessage("                      ");
        Bukkit.getConsoleSender().sendMessage("§aTornadoSpawners: §c1.8.x§7-§c1.12.x");
        Bukkit.getConsoleSender().sendMessage("§5§l-------------------------");
        plugin = instance;
        API.languages = new ConfigAPI(plugin, "languages");
        if (API.languages.getConfig().get("Plugin_Language") != null) {
            API.Plugin_Language = API.languages.getConfig().getString("Plugin_Language");
            if (!Objects.equals(API.Plugin_Language, "en") && !Objects.equals(API.Plugin_Language, "tr")) {
                Bukkit.getConsoleSender().sendMessage(API.chatcolor("&7[&aTornadoSpawners&7] &cUnsupporting language, plugin can not be loaded!"));
                plugin.getServer().getPluginManager().disablePlugin(plugin);
                return;
            }

            new Dil(plugin, API.Plugin_Language);
        }

        String a = plugin.getServer().getClass().getPackage().getName();
        API.version = a.substring(a.lastIndexOf(46) + 1);
        new Styles();
        if (setupItemSpawner(API.version) == null) {
            Bukkit.getConsoleSender().sendMessage(Styles.Unsupporting_Version);
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        } else {
            API.item = setupItemSpawner(API.version);
            API.registerCommands();
            API.registerListener();
        }

    }

    public static void stopPlugin(TornadoSpawnersPlugin instance) {
        plugin = instance;
    }

    private static ItemSpawnerINT setupItemSpawner(String version) {
        if (Objects.equals(version, "v1_8_R1")) {
            API.spawnertypes = new SpawnerTypes1_8_R1();
            return new ItemSpawner1_8_R1();
        } else if (Objects.equals(version, "v1_8_R2")) {
            API.spawnertypes = new SpawnerTypes1_8_R2();
            return new ItemSpawner1_8_R2();
        } else if (Objects.equals(version, "v1_8_R3")) {
            API.spawnertypes = new SpawnerTypes1_8_R3();
            return new ItemSpawner1_8_R3();
        } else if (Objects.equals(version, "v1_9_R1")) {
            API.spawnertypes = new SpawnerTypes1_9_R1();
            return new ItemSpawner1_9_R1();
        } else if (Objects.equals(version, "v1_9_R2")) {
            API.spawnertypes = new SpawnerTypes1_9_R2();
            return new ItemSpawner1_9_R2();
        } else if (Objects.equals(version, "v1_10_R1")) {
            API.spawnertypes = new SpawnerTypes1_10_R1();
            return new ItemSpawner1_10_R1();
        } else if (Objects.equals(version, "v1_11_R1")) {
            API.spawnertypes = new SpawnerTypes1_11_R1();
            return new ItemSpawner1_11_R1();
        } else if (Objects.equals(version, "v1_12_R1")) {
            API.spawnertypes = new SpawnerTypes1_12_R1();
            return new ItemSpawner1_12_R1();
        } else if (Objects.equals(version, "v1_13_R1")) {
            API.spawnertypes = new SpawnerTypes1_13_R1();
            return new ItemSpawner1_13_R1();
        } else if (Objects.equals(version, "v1_13_R2")) {
            API.spawnertypes = new SpawnerTypes1_13_R2();
            return new ItemSpawner1_13_R2();
        } else if (Objects.equals(version, "v1_14_R1")) {
            API.spawnertypes = new SpawnerTypes1_14_R1();
            return new ItemSpawner1_14_R1();
        } else if (Objects.equals(version, "v1_15_R1")) {
            API.spawnertypes = new SpawnerTypes1_15_R1();
            return new ItemSpawner1_15_R1();
        } else {
            return null;
        }
    }
}