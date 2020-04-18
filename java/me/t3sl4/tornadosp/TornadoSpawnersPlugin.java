package me.t3sl4.tornadosp;

import me.t3sl4.tornadosp.api.Initializing;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TornadoSpawnersPlugin extends JavaPlugin {
    public void onEnable() {
        Initializing.startPlugin(this);
    }

    public void onDisable() {
        Initializing.stopPlugin(this);
    }

    public static TornadoSpawnersPlugin getPlugin() {
        return (TornadoSpawnersPlugin)Bukkit.getPluginManager().getPlugin("TornadoSpawners");
    }
}
