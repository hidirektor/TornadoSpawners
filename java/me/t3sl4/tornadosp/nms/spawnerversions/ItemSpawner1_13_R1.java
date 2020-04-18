package me.t3sl4.tornadosp.nms.spawnerversions;

import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import net.minecraft.server.v1_13_R1.BlockPosition;
import net.minecraft.server.v1_13_R1.NBTBase;
import net.minecraft.server.v1_13_R1.NBTTagCompound;
import net.minecraft.server.v1_13_R1.TileEntityMobSpawner;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSpawner1_13_R1 implements ItemSpawnerINT {

    public void setItemSpawner(Player p, ItemSpawnerType ist, Location loc) {
        BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
        NBTTagCompound nbtTileEntity = new NBTTagCompound();

        assert spawner != null;

        ItemStack items = p.getInventory().getItemInHand();
        p.getInventory().setItemInHand(ist.getNecikaracagi().getItemStack());
        p.updateInventory();
        ItemStack items2 = p.getInventory().getItemInHand();
        NBTTagCompound itemstack = new NBTTagCompound();
        NBTTagCompound itemStackTag = new NBTTagCompound();
        net.minecraft.server.v1_13_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(items2);
        itemStack.save(itemStackTag);
        itemstack.setString("id", "Item");
        itemstack.set("Item", (NBTBase)itemStackTag);
        nbtTileEntity.set("SpawnData", (NBTBase)itemstack);
        nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
        nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
        nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
        nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
        nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
        p.getInventory().setItemInHand(items);
        p.updateInventory();
        spawner.load(nbtTileEntity);
    }

    public void setItemSpawner(ItemSpawnerType ist, Location loc) {
        BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
        TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
        NBTTagCompound nbtTileEntity = new NBTTagCompound();

        assert spawner != null;

        NBTTagCompound itemstack = new NBTTagCompound();
        NBTTagCompound itemStackTag = new NBTTagCompound();
        net.minecraft.server.v1_13_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(ist.getNecikaracagi().getItemStack());
        itemStack.save(itemStackTag);
        itemstack.setString("id", "Item");
        itemstack.set("Item", (NBTBase)itemStackTag);
        nbtTileEntity.set("SpawnData", (NBTBase)itemstack);
        nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
        nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
        nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
        nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
        nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
        spawner.load(nbtTileEntity);
    }
}
