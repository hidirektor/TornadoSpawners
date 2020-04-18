package me.t3sl4.tornadosp.commands.itemsp.spawner;

import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.commands.CommandInterface;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class VerCommand implements CommandInterface {
   private StringBuilder helpmessage = this.a();

   public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      Player target;
      ItemSpawnerType type2;
      if (args.length == 3) {
         if (Bukkit.getPlayer(args[1]) != null) {
            target = Bukkit.getPlayer(args[1]);
            if (API.getItemSpawnerTypeFromID(args[2]) != null) {
               type2 = API.getItemSpawnerTypeFromID(args[2]);

               assert type2 != null;

               if (API.checkInventory(target, type2.getKendisi().getItemStack())) {
                  target.getInventory().addItem(new ItemStack[]{type2.getKendisi().getItemStack()});
                  target.updateInventory();
                  target.sendMessage(Styles.Spawner_Give);
                  sender.sendMessage(Styles.Spawner_Has_Been_Gived.replaceAll("%Target_Name%", target.getName()));
               } else {
                  sender.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", target.getName()));
               }
            } else {
               sender.sendMessage(Styles.Wrong_ID);
            }
         } else {
            sender.sendMessage(Styles.Player_Not_Found.replaceAll("%Player_Name%", args[1]));
         }
      } else if (args.length == 4) {
         if (Bukkit.getPlayer(args[1]) != null) {
            target = Bukkit.getPlayer(args[1]);
            if (API.getItemSpawnerTypeFromID(args[2]) != null) {
               type2 = API.getItemSpawnerTypeFromID(args[2]);

               int amount;
               try {
                  amount = Integer.parseInt(args[3]);
               } catch (Exception var9) {
                  sender.sendMessage(this.helpmessage.toString());
                  return;
               }

               assert type2 != null;

               if (API.checkInventory(target, type2.getKendisi().getItemStack())) {
                  for(int i = 0; i < amount; ++i) {
                     target.getInventory().addItem(new ItemStack[]{type2.getKendisi().getItemStack()});
                     target.updateInventory();
                  }

                  target.sendMessage(Styles.Spawner_Give);
               } else {
                  sender.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", target.getName()));
               }
            }
         } else {
            sender.sendMessage(Styles.Player_Not_Found.replaceAll("%Player_Name%", args[1]));
         }
      } else {
         sender.sendMessage(this.helpmessage.toString());
      }

   }

   private StringBuilder a() {
      this.helpmessage = new StringBuilder();
      this.helpmessage.append(Styles.Plugin_Prefix).append("\n");
      this.helpmessage.append(Styles.Help_Give);
      return this.helpmessage;
   }
}
