package me.t3sl4.tornadosp.nms.spawnertypes;

import java.util.Iterator;
import java.util.Objects;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.nms.SpawnerTypesINT;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import net.minecraft.server.v1_8_R1.BlockPosition;
import net.minecraft.server.v1_8_R1.ItemStack;
import net.minecraft.server.v1_8_R1.NBTTagCompound;
import net.minecraft.server.v1_8_R1.TileEntityMobSpawner;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.inventory.CraftItemStack;

public class SpawnerTypes1_8_R1 implements SpawnerTypesINT {
   public ItemSpawnerType getItemSpawnerTypeFromLocation(Location loc) {
      if (loc.getBlock().getType() == Material.MOB_SPAWNER) {
         BlockPosition blockPos = new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
         TileEntityMobSpawner spawner = (TileEntityMobSpawner)((CraftWorld)loc.getWorld()).getHandle().getTileEntity(blockPos);
         NBTTagCompound nbtTileEntity = new NBTTagCompound();
         spawner.b(nbtTileEntity);
         NBTTagCompound itemStacknbt_1 = (NBTTagCompound)nbtTileEntity.get("SpawnData");
         NBTTagCompound itemStacknbt_2 = (NBTTagCompound)itemStacknbt_1.get("Item");
         Iterator var8 = Styles.ItemSpawner_Types.iterator();

         while(var8.hasNext()) {
            ItemSpawnerType ist = (ItemSpawnerType)var8.next();
            ItemStack itemStack = CraftItemStack.asNMSCopy(ist.getNecikaracagi().getItemStack());
            NBTTagCompound itemStack_tmp = new NBTTagCompound();
            itemStack.save(itemStack_tmp);
            if (Objects.equals(itemStack_tmp.toString(), itemStacknbt_2.toString())) {
               return ist;
            }
         }
      }

      return null;
   }
}
