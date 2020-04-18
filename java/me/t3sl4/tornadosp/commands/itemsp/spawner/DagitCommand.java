package me.t3sl4.tornadosp.commands.itemsp.spawner;

import java.util.Iterator;
import me.t3sl4.tornadosp.api.API;
import me.t3sl4.tornadosp.api.Styles;
import me.t3sl4.tornadosp.commands.CommandInterface;
import me.t3sl4.tornadosp.serialize.ItemSpawnerType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DagitCommand implements CommandInterface {
   private StringBuilder helpmessage = this.a();

   public void onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      ItemSpawnerType type;
      Player ps;
      Iterator var8;
      if (sender instanceof Player) {
         Player p = (Player)sender;
         if (args.length == 2) {
            if (API.getItemSpawnerTypeFromID(args[1]) != null) {
               type = API.getItemSpawnerTypeFromID(args[1]);
               var8 = Bukkit.getOnlinePlayers().iterator();

               while(var8.hasNext()) {
                  ps = (Player)var8.next();

                  assert type != null;

                  if (API.checkInventory(ps, type.getKendisi().getItemStack())) {
                     ps.getInventory().addItem(new ItemStack[]{type.getKendisi().getItemStack()});
                     ps.updateInventory();
                  } else {
                     p.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", ps.getName()));
                     ps.sendMessage(Styles.Inventory_Is_Full);
                  }
               }
            } else {
               p.sendMessage(Styles.Wrong_ID);
            }
         } else if (args.length == 3) {
            if (API.getItemSpawnerTypeFromID(args[1]) != null) {
               ItemSpawnerType type2 = API.getItemSpawnerTypeFromID(args[1]);

               int amount;
               try {
                  amount = Integer.parseInt(args[2]);
               } catch (Exception var12) {
                  p.sendMessage(this.helpmessage.toString());
                  return;
               }

               Iterator var9 = Bukkit.getOnlinePlayers().iterator();

               while(true) {
                  while(var9.hasNext()) {
                     Player ps2 = (Player)var9.next();

                     assert type2 != null;

                     if (API.checkInventory(ps2, type2.getKendisi().getItemStack())) {
                        for(int i = 0; i < amount; ++i) {
                           ps2.getInventory().addItem(new ItemStack[]{type2.getKendisi().getItemStack()});
                           ps2.updateInventory();
                        }
                     } else {
                        p.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", ps2.getName()));
                        ps2.sendMessage(Styles.Inventory_Is_Full);
                     }
                  }

                  return;
               }
            } else {
               p.sendMessage(Styles.Wrong_ID);
            }
         } else {
            p.sendMessage(this.helpmessage.toString());
         }
      } else if (args.length == 2) {
         if (API.getItemSpawnerTypeFromID(args[1]) != null) {
            ItemSpawnerType type3 = API.getItemSpawnerTypeFromID(args[1]);
            Iterator var18 = Bukkit.getOnlinePlayers().iterator();

            while(var18.hasNext()) {
               Player ps3 = (Player)var18.next();

               assert type3 != null;

               if (API.checkInventory(ps3, type3.getKendisi().getItemStack())) {
                  ps3.getInventory().addItem(new ItemStack[]{type3.getKendisi().getItemStack()});
                  ps3.updateInventory();
               } else {
                  sender.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", ps3.getName()));
                  ps3.sendMessage(Styles.Inventory_Is_Full);
               }
            }
         } else {
            sender.sendMessage(Styles.Wrong_ID);
         }
      } else if (args.length == 3) {
         if (API.getItemSpawnerTypeFromID(args[1]) != null) {
            type = API.getItemSpawnerTypeFromID(args[1]);

            int amount2;
            try {
               amount2 = Integer.parseInt(args[2]);
            } catch (Exception var11) {
               sender.sendMessage(this.helpmessage.toString());
               return;
            }

            var8 = Bukkit.getOnlinePlayers().iterator();

            while(true) {
               while(var8.hasNext()) {
                  ps = (Player)var8.next();

                  assert type != null;

                  if (API.checkInventory(ps, type.getKendisi().getItemStack())) {
                     for(int j = 0; j < amount2; ++j) {
                        ps.getInventory().addItem(new ItemStack[]{type.getKendisi().getItemStack()});
                        ps.updateInventory();
                     }

                     ps.sendMessage(Styles.Spawner_Deal);
                  } else {
                     sender.sendMessage(Styles.Player_Inventory_Is_Full.replaceAll("%Player_Name%", ps.getName()));
                     ps.sendMessage(Styles.Inventory_Is_Full);
                  }
               }

               return;
            }
         } else {
            sender.sendMessage(Styles.Wrong_ID);
         }
      } else {
         sender.sendMessage(this.helpmessage.toString());
      }

   }

   private StringBuilder a() {
      this.helpmessage = new StringBuilder();
      this.helpmessage.append(Styles.Plugin_Prefix).append("\n");
      this.helpmessage.append(Styles.Help_Deal);
      return this.helpmessage;
   }
}
