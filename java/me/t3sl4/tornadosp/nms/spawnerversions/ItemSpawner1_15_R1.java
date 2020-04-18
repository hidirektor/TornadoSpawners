package me.t3sl4.tornadosp.nms.spawnerversions;

import me.t3sl4.tornadosp.api.ReflectionUtil;
import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import net.minecraft.server.v1_15_R1.BlockPosition;
import net.minecraft.server.v1_15_R1.NBTTagCompound;
import net.minecraft.server.v1_15_R1.TileEntityMobSpawner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSpawner1_15_R1 implements ItemSpawnerINT {

    String version = ((CraftServer) Bukkit.getServer()).getServer().getVersion();

    public void setItemSpawner(Player p, ItemSpawnerType ist, Location loc) {
        BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
        net.minecraft.server.v1_15_R1.NBTTagCompound nbtTileEntity = new net.minecraft.server.v1_15_R1.NBTTagCompound();
        spawner.save(nbtTileEntity);

        assert spawner != null;

        ItemStack items = p.getInventory().getItemInHand();
        p.getInventory().setItemInHand(ist.getNecikaracagi().getItemStack());
        p.updateInventory();
        ItemStack items2 = p.getInventory().getItemInHand();
        NBTTagCompound itemstack = new NBTTagCompound();
        NBTTagCompound itemStackTag = new NBTTagCompound();
        net.minecraft.server.v1_15_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(items2);
        itemStack.save(itemStackTag);
        itemstack.setString("id", "Item");
        itemstack.set("Item", itemStackTag);
        nbtTileEntity.set("SpawnData", itemstack);
        nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
        nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
        nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
        nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
        nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
        spawner.load(nbtTileEntity);
        p.getInventory().setItemInHand(items);
        p.updateInventory();
    }

    public void setItemSpawner(ItemSpawnerType ist, Location loc) {
        BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
        net.minecraft.server.v1_15_R1.NBTTagCompound nbtTileEntity = new net.minecraft.server.v1_15_R1.NBTTagCompound();
        spawner.save(nbtTileEntity);

        assert spawner != null;

        NBTTagCompound itemstack = new NBTTagCompound();
        NBTTagCompound itemStackTag = new NBTTagCompound();
        net.minecraft.server.v1_15_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(ist.getNecikaracagi().getItemStack());
        itemStack.save(itemStackTag);
        itemstack.setString("id", "Item");
        itemstack.set("Item", itemStackTag);
        nbtTileEntity.set("SpawnData", itemstack);
        nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
        nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
        nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
        nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
        nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
        spawner.load(nbtTileEntity);
    }
}
