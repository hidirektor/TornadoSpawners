package me.t3sl4.tornadosp.nms.spawnerversions;

import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import net.minecraft.server.v1_9_R2.BlockPosition;
import net.minecraft.server.v1_9_R2.NBTTagCompound;
import net.minecraft.server.v1_9_R2.TileEntityMobSpawner;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSpawner1_9_R2 implements ItemSpawnerINT {
   public void setItemSpawner(Player p, ItemSpawnerType ist, Location loc) {
      BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
      TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
      NBTTagCompound nbtTileEntity = new NBTTagCompound();

      assert spawner != null;

      spawner.save(nbtTileEntity);
      ItemStack items = p.getInventory().getItemInHand();
      p.getInventory().setItemInHand(ist.getNecikaracagi().getItemStack());
      p.updateInventory();
      ItemStack items2 = p.getInventory().getItemInHand();
      NBTTagCompound itemstack = new NBTTagCompound();
      NBTTagCompound itemStackTag = new NBTTagCompound();
      net.minecraft.server.v1_9_R2.ItemStack itemStack = CraftItemStack.asNMSCopy(items2);
      itemStack.save(itemStackTag);
      itemstack.setString("id", "Item");
      itemstack.set("Item", itemStackTag);
      nbtTileEntity.set("SpawnData", itemstack);
      nbtTileEntity.remove("SpawnPotentials");
      nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
      nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
      nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
      nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
      nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
      spawner.a(nbtTileEntity);
      p.getInventory().setItemInHand(items);
      p.updateInventory();
   }

   public void setItemSpawner(ItemSpawnerType ist, Location loc) {
      BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
      TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
      NBTTagCompound nbtTileEntity = new NBTTagCompound();

      assert spawner != null;

      spawner.save(nbtTileEntity);
      NBTTagCompound itemstack = new NBTTagCompound();
      NBTTagCompound itemStackTag = new NBTTagCompound();
      net.minecraft.server.v1_9_R2.ItemStack itemStack = CraftItemStack.asNMSCopy(ist.getNecikaracagi().getItemStack());
      itemStack.save(itemStackTag);
      itemstack.setString("id", "Item");
      itemstack.set("Item", itemStackTag);
      nbtTileEntity.set("SpawnData", itemstack);
      nbtTileEntity.remove("SpawnPotentials");
      nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
      nbtTileEntity.setInt("MinSpawnDelay", ist.getMindelay() * 20);
      nbtTileEntity.setInt("MaxSpawnDelay", ist.getMaxdelay() * 20);
      nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
      nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
      spawner.a(nbtTileEntity);
   }
}
