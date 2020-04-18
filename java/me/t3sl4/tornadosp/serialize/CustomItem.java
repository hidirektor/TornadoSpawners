package me.t3sl4.tornadosp.serialize;

import java.util.List;
import java.util.Objects;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem {
    private int id;

    private byte data;

    private int amount;

    private String name;

    private List<String> lore;

    private int silktouch;

    public CustomItem(String id, String name, List<String> lore) {
        String[] tmp_id = id.split(":");
        if (tmp_id.length == 1) {
            this.id = Integer.parseInt(tmp_id[0]);
            this.data = 0;
        }
        if (tmp_id.length == 2) {
            this.id = Integer.parseInt(tmp_id[0]);
            this.data = Byte.parseByte(tmp_id[1]);
        }
        this.amount = 1;
        this.name = name;
        this.lore = lore;
    }

    public ItemStack getItemStack() {
        if (this.id != 0 && Material.getMaterial(this.id) != null) {
            ItemStack item = (this.amount == 0) ? new ItemStack(Material.getMaterial(this.id), 1, (short)1, Byte.valueOf(this.data)) : new ItemStack(Material.getMaterial(this.id), this.amount, (short)1, Byte.valueOf(this.data));
            ItemMeta m = item.getItemMeta();
            if (!Objects.equals(this.name, "."))
                m.setDisplayName(this.name);
            if (!Objects.equals(this.lore.get(0), "."))
                m.setLore(this.lore);
            if (this.silktouch > 0)
                m.addEnchant(Enchantment.SILK_TOUCH, this.silktouch, true);
            item.setItemMeta(m);
            return item;
        }
        return null;
    }

    public void setSilktouch(int silktouch) {
        this.silktouch = silktouch;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getLore() {
        return this.lore;
    }
}
