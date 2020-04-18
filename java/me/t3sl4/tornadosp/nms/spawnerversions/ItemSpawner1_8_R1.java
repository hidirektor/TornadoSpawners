package me.t3sl4.tornadosp.nms.spawnerversions;

import me.t3sl4.tornadosp.nms.ItemSpawnerINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import net.minecraft.server.v1_8_R1.BlockPosition;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.TileEntityMobSpawner;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemSpawner1_8_R1 implements ItemSpawnerINT {
   public void setItemSpawner(Player p, ItemSpawnerType ist, Location loc) {
      BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
      TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
      NBTTagCompound nbtTileEntity = new NBTTagCompound();
      spawner.b(nbtTileEntity);
      ItemStack items = p.getItemInHand();
      p.setItemInHand(ist.getNecikaracagi().getItemStack());
      p.updateInventory();
      ItemStack items2 = p.getItemInHand();
      nbtTileEntity.remove("SpawnPotentials");
      nbtTileEntity.setString("EntityId", "Item");
      NBTTagCompound itemTag = new NBTTagCompound();
      net.minecraft.server.v1_8_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(items2);
      NBTTagCompound itemStackTag = new NBTTagCompound();
      itemStack.save(itemStackTag);
      itemTag.set("Item", itemStackTag);
      nbtTileEntity.set("SpawnData", itemTag);
      nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
      nbtTileEntity.setShort("MaxSpawnDelay", (short)(ist.getMaxdelay() * 20));
      nbtTileEntity.setShort("MinSpawnDelay", (short)(ist.getMindelay() * 20));
      nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
      nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
      spawner.a(nbtTileEntity);
      p.setItemInHand(items);
      p.updateInventory();
   }

   public void setItemSpawner(ItemSpawnerType ist, Location loc) {
      BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
      TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
      NBTTagCompound nbtTileEntity = new NBTTagCompound();
      spawner.b(nbtTileEntity);
      nbtTileEntity.remove("SpawnPotentials");
      nbtTileEntity.setString("EntityId", "Item");
      NBTTagCompound itemTag = new NBTTagCompound();
      net.minecraft.server.v1_8_R1.ItemStack itemStack = CraftItemStack.asNMSCopy(ist.getNecikaracagi().getItemStack());
      NBTTagCompound itemStackTag = new NBTTagCompound();
      itemStack.save(itemStackTag);
      itemTag.set("Item", itemStackTag);
      nbtTileEntity.set("SpawnData", itemTag);
      nbtTileEntity.setShort("SpawnCount", (short)ist.getCount());
      nbtTileEntity.setShort("MaxSpawnDelay", (short)(ist.getMaxdelay() * 20));
      nbtTileEntity.setShort("MinSpawnDelay", (short)(ist.getMindelay() * 20));
      nbtTileEntity.setShort("SpawnRange", (short)ist.getRange());
      nbtTileEntity.setShort("RequiredPlayerRange", (short)ist.getRequiredrange());
      spawner.a(nbtTileEntity);
   }
}
