package me.t3sl4.tornadosp.api;

import java.util.Objects;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import org.bukkit.plugin.java.JavaPlugin;

class Dil {
    Dil(TornadoSpawnersPlugin plugin, String language) {
        if (Objects.equals(language, "en")) {
            API.ayarlar = new ConfigAPI((JavaPlugin)plugin, "options", "en");
            API.komutlar = new ConfigAPI((JavaPlugin)plugin, "commands", "en");
            API.spawnerlar = new ConfigAPI((JavaPlugin)plugin, "spawners", "en");
        } else if (Objects.equals(language, "tr")) {
            API.ayarlar = new ConfigAPI((JavaPlugin)plugin, "ayarlar", "tr");
            API.komutlar = new ConfigAPI((JavaPlugin)plugin, "komutlar", "tr");
            API.spawnerlar = new ConfigAPI((JavaPlugin)plugin, "spawnerlar", "tr");
        }
    }
}
