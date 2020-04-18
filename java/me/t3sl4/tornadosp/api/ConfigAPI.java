package me.t3sl4.tornadosp.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigAPI {
    private File configFile;

    private String filename;

    private JavaPlugin plugin;

    private FileConfiguration fileConfiguration;

    ConfigAPI(JavaPlugin plugin, String filename) {
        this.filename = String.valueOf(String.valueOf(filename)) + ".yml";
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), this.filename);
        firstRun(plugin);
        this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.configFile);
        load();
    }

    ConfigAPI(JavaPlugin plugin, String filename, String language) {
        this.filename = String.valueOf(String.valueOf(filename)) + ".yml";
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder() + "/" + language, this.filename);
        firstRun(plugin, language);
        this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.configFile);
        load();
    }

    public FileConfiguration getConfig() {
        load();
        return this.fileConfiguration;
    }

    public void save() {
        try {
            this.fileConfiguration.save(this.configFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }

    public void load() {
        try {
            this.fileConfiguration.load(this.configFile);
        } catch (InvalidConfigurationException var2) {
            var2.printStackTrace();
        } catch (FileNotFoundException var3) {
            this.configFile = new File(this.plugin.getDataFolder(), this.filename);
            firstRun(this.plugin);
            this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.configFile);
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }

    private void firstRun(JavaPlugin plugin, String language) {
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            copy(plugin.getResource(String.valueOf(String.valueOf(language)) + "/" + this.filename), this.configFile);
        }
    }

    private void firstRun(JavaPlugin plugin) {
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            copy(plugin.getResource(this.filename), this.configFile);
        }
    }

    private void copy(InputStream in, File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[63];
            int len;
            while ((len = in.read(buf)) > 0)
                out.write(buf, 0, len);
            out.close();
            in.close();
        } catch (Exception exception) {}
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return getConfig().getConfigurationSection(path);
    }
}
