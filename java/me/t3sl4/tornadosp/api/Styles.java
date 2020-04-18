package me.t3sl4.tornadosp.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.t3sl4.tornadosp.TornadoSpawnersPlugin;
import me.t3sl4.tornadosp.serialize.CustomItem;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;

public class Styles {
    static String Main_Command;
    static String Reload_Arg;
    static String Deal_Arg;
    static String Give_Arg;
    static String List_Arg;
    public static String Plugin_Prefix;
    public static String Help_Prefix;
    public static String Help_Reload;
    public static String Help_Deal;
    public static String Help_Give;
    public static String Help_List;
    public static String Spawner_List;
    public static int Minimum_SilkTouch_Level_For_Break_To_Spawner;
    public static boolean Stay_Exploded_Location;
    public static CustomItem Item_Pickaxe;
    public static String Files_Has_Been_Reloaded;
    public static String Spawner_Deal;
    public static String Spawner_Give;
    public static String Spawner_Has_Been_Gived;
    public static String Player_Not_Found;
    public static String Player_Help_Message;
    public static String Wrong_ID;
    public static String Inventory_Is_Full;
    public static String Player_Inventory_Is_Full;
    public static String Insufficient_SilkTouch_Level;
    public static String Just_Breakable_With_Speacial_Pickaxe;
    static String Unsupporting_Version;
    private static String languge;
    private static ConfigAPI komutlar;
    private static ConfigAPI ayarlar;
    private static ConfigAPI spawnerlar;
    public static List<ItemSpawnerType> ItemSpawner_Types = new ArrayList();

    public Styles() {
        komutlar = API.komutlar;
        ayarlar = API.ayarlar;
        languge = API.Plugin_Language;
        spawnerlar = API.spawnerlar;
        ItemSpawner_Types.clear();
        preFiles();
    }

    private static void preFiles() {
        String pickaxe_id;
        String pickaxe_name;
        List pickaxe_lore;
        String s;
        Iterator var4;
        String spawner_name;
        List spawner_lore;
        CustomItem spawner_customitem;
        int spawner_spawncount;
        int spawner_spawnrange;
        int spawner_minspawndelay;
        int spawner_maxspawndelay;
        int spawner_requiredplayerrange;
        String dropped_item_id;
        String dropped_item_name;
        List dropped_item_lore;
        CustomItem dropped_item_customitem;
        if (!Objects.equals(languge, "en")) {
            if (Objects.equals(languge, "tr")) {
                preOptions("Ana_Komut", "Args.Dagit_Arg", "Args.Ver_Arg", "Yardim_Prefix", "Yardim_Reload", "Yardim_Dagit", "Yardim_Ver", "Yardim_List", "ItemSpawner_Kirmak_Icin_Gerekli_SilkTouch_Seviyesi", "Patlayinca_Oldugu_Yerde_Kalsın", "Dosyalar_Yeniden_Yuklendi", "Spawner_Dagit", "Spawner_Ver", "Spawner_Verildi", "Oyuncu_Bulunamadi", "Oyuncu_Yardim_Mesaji", "Yanlis_ID", "Envanter_Dolu", "Oyuncunun_Envanteri_Dolu", "Yetersiz_SilkTouch_Seviyesi", "Yalnizca_Ozel_Kazma_Ile_Kilir", "Desteklenmeyen_Surum");
                pickaxe_id = ayarlar.getConfig().getString("Kazma_Esyasi.Kazma_ID");
                pickaxe_name = API.chatcolor(ayarlar.getConfig().getString("Kazma_Esyasi.Kazma_Ismi"));
                pickaxe_lore = API.getChatColorList(ayarlar.getConfig().getStringList("Kazma_Esyasi.Kazma_Aciklamasi"));
                (Item_Pickaxe = new CustomItem(pickaxe_id, pickaxe_name, pickaxe_lore)).setSilktouch(Minimum_SilkTouch_Level_For_Break_To_Spawner);
                var4 = spawnerlar.getConfigurationSection("Spawner_Tipleri").getKeys(false).iterator();

                while(var4.hasNext()) {
                    s = (String)var4.next();
                    spawner_name = API.chatcolor(spawnerlar.getConfig().getString("Spawner_Tipleri." + s + ".Spawner_Ismi"));
                    spawner_lore = API.getChatColorList(spawnerlar.getConfig().getStringList("Spawner_Tipleri." + s + ".Spawner_Aciklamasi"));
                    spawner_customitem = new CustomItem("52", spawner_name, spawner_lore);
                    spawner_spawncount = spawnerlar.getConfig().getInt("Spawner_Tipleri." + s + ".Spawner_CikacakMiktar");
                    spawner_spawnrange = spawnerlar.getConfig().getInt("Spawner_Tipleri." + s + ".Spawner_CikacakMesafe");
                    spawner_minspawndelay = spawnerlar.getConfig().getInt("Spawner_Tipleri." + s + ".Spawner_MinHizi");
                    spawner_maxspawndelay = spawnerlar.getConfig().getInt("Spawner_Tipleri." + s + ".Spawner_MaxHizi");
                    spawner_requiredplayerrange = spawnerlar.getConfig().getInt("Spawner_Tipleri." + s + ".Spawner_CalismaMesafesi");
                    dropped_item_id = spawnerlar.getConfig().getString("Spawner_Tipleri." + s + ".Dusen_Esya_ID");
                    dropped_item_name = API.chatcolor(spawnerlar.getConfig().getString("Spawner_Tipleri." + s + ".Dusen_Esya_Ismi"));
                    dropped_item_lore = API.getChatColorList(spawnerlar.getConfig().getStringList("Spawner_Tipleri." + s + ".Dusen_Esya_Aciklamasi"));
                    dropped_item_customitem = new CustomItem(dropped_item_id, dropped_item_name, dropped_item_lore);
                    ItemSpawner_Types.add(new ItemSpawnerType(s, spawner_customitem, dropped_item_customitem, spawner_spawncount, spawner_spawnrange, spawner_minspawndelay, spawner_maxspawndelay, spawner_requiredplayerrange));
                }
            }
        } else {
            preOptions("Main_Command", "Args.Deal_Arg", "Args.Give_Arg", "Help_Prefix", "Help_Reload", "Help_Deal", "Help_Give", "Help_List", "Minimum_SilkTouch_Level_For_Break_To_Spawner", "Stay_Exploded_Location", "Files_Has_Been_Reloaded", "Spawner_Deal", "Spawner_Give", "Spawner_Has_Been_Gived", "Player_Not_Found", "Player_Help_Message", "Wrong_ID", "Inventory_Is_Full", "Player_Inventory_Is_Full", "Insufficient_SilkTouch_Level", "Just_Breakable_With_Special_Pickaxe", "Unsupporting_Version");
            pickaxe_id = ayarlar.getConfig().getString("Item_Pickaxe.Pickaxe_ID");
            pickaxe_name = API.chatcolor(ayarlar.getConfig().getString("Item_Pickaxe.Pickaxe_Name"));
            pickaxe_lore = API.getChatColorList(ayarlar.getConfig().getStringList("Item_Pickaxe.Pickaxe_Lore"));
            (Item_Pickaxe = new CustomItem(pickaxe_id, pickaxe_name, pickaxe_lore)).setSilktouch(Minimum_SilkTouch_Level_For_Break_To_Spawner);
            var4 = spawnerlar.getConfigurationSection("Spawner_Types").getKeys(false).iterator();

            while(var4.hasNext()) {
                s = (String)var4.next();
                spawner_name = API.chatcolor(spawnerlar.getConfig().getString("Spawner_Types." + s + ".Spawner_Name"));
                spawner_lore = API.getChatColorList(spawnerlar.getConfig().getStringList("Spawner_Types." + s + ".Spawner_Lore"));
                spawner_customitem = new CustomItem("52", spawner_name, spawner_lore);
                spawner_spawncount = spawnerlar.getConfig().getInt("Spawner_Types." + s + ".Spawner_SpawnCount");
                spawner_spawnrange = spawnerlar.getConfig().getInt("Spawner_Types." + s + ".Spawner_SpawnRange");
                spawner_minspawndelay = spawnerlar.getConfig().getInt("Spawner_Types." + s + ".Spawner_MinSpawnerDelay");
                spawner_maxspawndelay = spawnerlar.getConfig().getInt("Spawner_Types." + s + ".Spawner_MaxSpawnerDelay");
                spawner_requiredplayerrange = spawnerlar.getConfig().getInt("Spawner_Types." + s + ".Spawner_RequiredPlayerRange");
                dropped_item_id = spawnerlar.getConfig().getString("Spawner_Types." + s + ".Dropped_Item_ID");
                dropped_item_name = API.chatcolor(spawnerlar.getConfig().getString("Spawner_Types." + s + ".Dropped_Item_Name"));
                dropped_item_lore = API.getChatColorList(spawnerlar.getConfig().getStringList("Spawner_Types." + s + ".Dropped_Item_Lore"));
                dropped_item_customitem = new CustomItem(dropped_item_id, dropped_item_name, dropped_item_lore);
                ItemSpawner_Types.add(new ItemSpawnerType(s, spawner_customitem, dropped_item_customitem, spawner_spawncount, spawner_spawnrange, spawner_minspawndelay, spawner_maxspawndelay, spawner_requiredplayerrange));
            }
        }

    }

    private static String setArgs(String s) {
        String ss;
        String sss;
        for(Iterator var2 = komutlar.getConfigurationSection("Args").getKeys(false).iterator(); var2.hasNext(); s = s.replaceAll("%" + ss + "%", sss)) {
            ss = (String)var2.next();
            sss = komutlar.getConfig().getString("Args." + ss);
        }

        if (Objects.equals(languge, "en")) {
            return s.replaceAll("%Main_Command%", Main_Command);
        } else if (Objects.equals(languge, "tr")) {
            return s.replaceAll("%Ana_Komut%", Main_Command);
        } else {
            Bukkit.getConsoleSender().sendMessage(API.chatcolor("&e[ItemSpawner] &cUnsupporting language, plugin can not be loaded!"));
            TornadoSpawnersPlugin.getPlugin().getServer().getPluginManager().disablePlugin(TornadoSpawnersPlugin.getPlugin());
            return "";
        }
    }

    private static String setPrefix(String s) {
        return s.replaceAll("%Prefix%", Plugin_Prefix);
    }

    private static void preOptions(String main_Command, String deal_Arg, String give_Arg, String help_Prefix, String help_Reload, String help_Deal, String help_Give, String help_List, String silkTouch_Level_For_Break_To_Spawner, String stay_Exploded_Location, String files_Has_Been_Reloaded, String spawner_Deal, String spawner_Give, String spawner_Has_Been_Gived, String player_Not_Found, String player_Help_Message, String wrong_ID, String inventory_Is_Full, String player_Inventory_Is_Full, String insufficient_SilkTouch_Level, String just_Breakable_With_Speacial_Pickaxe, String unsupporting_Version) {
        Main_Command = komutlar.getConfig().getString(main_Command);
        Reload_Arg = komutlar.getConfig().getString("Args.Reload_Arg");
        Deal_Arg = komutlar.getConfig().getString(deal_Arg);
        Give_Arg = komutlar.getConfig().getString(give_Arg);
        List_Arg = komutlar.getConfig().getString("Args.List_Arg");
        Plugin_Prefix = API.chatcolor(ayarlar.getConfig().getString("Plugin_Prefix"));
        Help_Prefix = API.chatcolor(setArgs(ayarlar.getConfig().getString(help_Prefix)));
        Help_Reload = API.chatcolor(setArgs(ayarlar.getConfig().getString(help_Reload)));
        Help_Deal = API.chatcolor(setArgs(ayarlar.getConfig().getString(help_Deal)));
        Help_Give = API.chatcolor(setArgs(ayarlar.getConfig().getString(help_Give)));
        Help_List = API.chatcolor(setArgs(ayarlar.getConfig().getString(help_List)));
        Spawner_List = API.chatcolor(setArgs(ayarlar.getConfig().getString("Spawner_List")));
        Minimum_SilkTouch_Level_For_Break_To_Spawner = ayarlar.getConfig().getInt(silkTouch_Level_For_Break_To_Spawner);
        Stay_Exploded_Location = ayarlar.getConfig().getBoolean(stay_Exploded_Location);
        Files_Has_Been_Reloaded = API.chatcolor(setPrefix(ayarlar.getConfig().getString(files_Has_Been_Reloaded)));
        Spawner_Deal = API.chatcolor(setPrefix(ayarlar.getConfig().getString(spawner_Deal)));
        Spawner_Give = API.chatcolor(setPrefix(ayarlar.getConfig().getString(spawner_Give)));
        Spawner_Has_Been_Gived = API.chatcolor(setPrefix(ayarlar.getConfig().getString(spawner_Has_Been_Gived)));
        Player_Not_Found = API.chatcolor(setPrefix(ayarlar.getConfig().getString(player_Not_Found)));
        Player_Help_Message = API.chatcolor(setPrefix(ayarlar.getConfig().getString(player_Help_Message)));
        Wrong_ID = API.chatcolor(setPrefix(ayarlar.getConfig().getString(wrong_ID)));
        Inventory_Is_Full = API.chatcolor(setPrefix(ayarlar.getConfig().getString(inventory_Is_Full)));
        Player_Inventory_Is_Full = API.chatcolor(setPrefix(ayarlar.getConfig().getString(player_Inventory_Is_Full)));
        Insufficient_SilkTouch_Level = API.chatcolor(setPrefix(ayarlar.getConfig().getString(insufficient_SilkTouch_Level)));
        Just_Breakable_With_Speacial_Pickaxe = API.chatcolor(setPrefix(ayarlar.getConfig().getString(just_Breakable_With_Speacial_Pickaxe)));
        Unsupporting_Version = API.chatcolor(setPrefix(ayarlar.getConfig().getString(unsupporting_Version)));
    }
}